create database postgresql;

use postgresql;


create table user_profile
(
    id           int primary key,
    username     varchar(255) not null,
    password     varchar(255) not null,
    fullname     varchar(255) not null,
    avatar       varchar(255),
    birthday     timestamp,
    created_time timestamp    not null
);

create table friend
(
    id           int primary key,
    sender_id    int not null,
    receiver_id  int not null,
    status       varchar(20) check ( status IN ('pending', 'accepted', 'rejected') ),
    created_time timestamp,
    foreign key (sender_id) references user_profile (id),
    foreign key (receiver_id) references user_profile (id)
);


create table message
(
    id           int primary key,
    sender_id    int                                                             not null,
    receiver_id  int                                                             not null,
    type         varchar(20) check ( type in ('text', 'image', 'video', 'file')) not null,
    content      varchar(255),
    status       varchar(20) check ( status in ('sent', 'pending_read', 'read') ),
    created_time datetime,
    foreign key (sender_id) references user_profile (id),
    foreign key (receiver_id) references user_profile (id)
);


INSERT INTO user_profile (id, username, password, fullname, avatar, birthday, created_time)
VALUES (1, 'user1', 'pass1', 'User One', 'avatar1.jpg', '2000-01-01', CURRENT_TIMESTAMP),
       (2, 'user2', 'pass2', 'User Two', 'avatar2.jpg', '1999-02-15', CURRENT_TIMESTAMP),
       (3, 'user3', 'pass3', 'User Three', 'avatar3.jpg', '1998-05-20', CURRENT_TIMESTAMP),
       (4, 'user4', 'pass4', 'User Four', 'avatar4.jpg', '1997-08-25', CURRENT_TIMESTAMP),
       (5, 'user5', 'pass5', 'User Five', 'avatar5.jpg', '1996-11-30', CURRENT_TIMESTAMP),
       (6, 'user6', 'pass6', 'User Six', 'avatar6.jpg', '1995-04-05', CURRENT_TIMESTAMP),
       (7, 'user7', 'pass7', 'User Seven', 'avatar7.jpg', '1994-07-10', CURRENT_TIMESTAMP),
       (8, 'user8', 'pass8', 'User Eight', 'avatar8.jpg', '1993-10-15', CURRENT_TIMESTAMP),
       (9, 'user9', 'pass9', 'User Nine', 'avatar9.jpg', '1992-01-20', CURRENT_TIMESTAMP),
       (10, 'user10', 'pass10', 'User Ten', 'avatar10.jpg', '1991-04-25', CURRENT_TIMESTAMP);

INSERT INTO friend (id, sender_id, receiver_id, status, created_time)
VALUES (1, 1, 2, 'accepted', CURRENT_TIMESTAMP),
       (2, 1, 3, 'accepted', CURRENT_TIMESTAMP),
       (3, 1, 4, 'accepted', CURRENT_TIMESTAMP),
       (4, 2, 3, 'accepted', CURRENT_TIMESTAMP),
       (5, 2, 4, 'accepted', CURRENT_TIMESTAMP),
       (6, 2, 5, 'accepted', CURRENT_TIMESTAMP),
       (7, 3, 4, 'accepted', CURRENT_TIMESTAMP),
       (8, 3, 5, 'accepted', CURRENT_TIMESTAMP),
       (9, 3, 6, 'accepted', CURRENT_TIMESTAMP),
       (10, 4, 5, 'accepted', CURRENT_TIMESTAMP);

INSERT INTO message (id, sender_id, receiver_id, type, content, status, created_time)
VALUES (1, 1, 2, 'text', 'Hello user2', 'sent', CURRENT_TIMESTAMP),
       (2, 1, 3, 'text', 'Hi user3', 'sent', CURRENT_TIMESTAMP),
       (3, 1, 4, 'text', 'Hey user4', 'sent', CURRENT_TIMESTAMP),
       (4, 2, 3, 'text', 'How are you, user3?', 'sent', CURRENT_TIMESTAMP),
       (5, 2, 4, 'text', 'What\'s up, user4?', 'sent', CURRENT_TIMESTAMP),
       (6, 2, 5, 'text', 'Greetings, user5!', 'sent', CURRENT_TIMESTAMP),
       (7, 3, 4, 'text', 'Good day, user4!', 'sent', CURRENT_TIMESTAMP),
       (8, 3, 5, 'text', 'Hello, user5!', 'sent', CURRENT_TIMESTAMP),
       (9, 3, 6, 'text', 'Hi there, user6!', 'sent', CURRENT_TIMESTAMP),
       (10, 4, 5, 'text', 'Howdy, user5!', 'sent', CURRENT_TIMESTAMP);

#c/1-Lấy id, username, fullname, avatar: của các user có id =  2, 3.
SELECT id, username, fullname, avatar
FROM user_profile
WHERE id IN (2, 3);

#c/2-Lấy các bạn bè(gồm thông tin sau: id, username, fullname, avatar) của user có id = 2.
SELECT friend.id, user_profile.username, user_profile.fullname, user_profile.avatar
FROM friend
         JOIN user_profile ON friend.receiver_id = user_profile.id
WHERE friend.sender_id = 2
  AND friend.status = 'accepted';


#c/3-Lấy tin nhắn của user có id = 2 với một nào đó bạn bè (ví dụ: id bạn bè = 3).
# Các trường lấy ra gồm: message_id, sender_id, receiver_id, type, status, content, created_time.
SELECT id AS message_id, sender_id, receiver_id, type, status, content, created_time
FROM message
WHERE (sender_id = 2 AND receiver_id = 3)
   OR (sender_id = 3 AND receiver_id = 2)
ORDER BY created_time DESC;

#c/4-/Lấy tin nhắn cuối cùng(last_message) với tất cả bạn bè của user có id = 2. Các trường lấy ra gồm: friend_id, mesage_id, type, status, content, sender_id, created_time.
WITH LastMessages AS (SELECT CASE
                                 WHEN sender_id = 2 THEN receiver_id
                                 ELSE sender_id
                                 END AS friend_id,
                             MAX(id) AS last_message_id
                      FROM message
                      WHERE sender_id = 2
                         OR receiver_id = 2
                      GROUP BY CASE
                                   WHEN sender_id = 2 THEN receiver_id
                                   ELSE sender_id
                                   END)

SELECT lm.friend_id,
       m.id AS message_id,
       m.type,
       m.status,
       m.content,
       m.sender_id,
       m.created_time
FROM LastMessages lm
         JOIN message m ON lm.last_message_id = m.id
ORDER BY lm.friend_id;

#c/5-Lấy dánh sách 10 user(id, username, avatar, birthday) có số lượng bạn bè nhiều nhất trong hệ thống.
SELECT user_profile.id, user_profile.username, user_profile.avatar, user_profile.birthday
FROM user_profile
         JOIN (SELECT user_id, COUNT(*) AS friend_count
               FROM (SELECT sender_id AS user_id
                     FROM friend
                     UNION ALL
                     SELECT receiver_id AS user_id
                     FROM friend) AS user_friends
               GROUP BY user_id
               ORDER BY friend_count DESC
               LIMIT 10) AS top_users ON user_profile.id = top_users.user_id;