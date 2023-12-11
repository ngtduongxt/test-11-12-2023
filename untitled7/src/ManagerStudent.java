import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManagerStudent {
    private List<Student> students = new ArrayList<>();

    public ManagerStudent() {
        this.students = students;
        initializeStudent();
    }

    private void initializeStudent() {
        students.add(new Student("John", 18, 9.0, 8.5, 7.5));
        students.add(new Student("Alice", 19, 8.0, 7.0, 6.5));
        students.add(new Student("Bob", 20, 7.5, 6.0, 8.0));
        students.add(new Student("Darius",20,6.5,5.5,4.5));
        students.add(new Student("Yasuo",18,6.5,7,8.5));
        students.add(new Student("Yone",19,4.5,3.5,5.5));
    }

    public Student searchStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) ;
            return student;
        }
        return null;
    }

    public List<Student> getStudentsByRank(String rank) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getRank().equalsIgnoreCase(rank)) {
                result.add(student);
            }
        }
        return result;
    }

    public void sortStudentsByNameAndAvg() {
        Collections.sort(students, Comparator
                .comparing(Student::getName)
                .thenComparing(Student::getAvg));
    }

    public List<Student> getStudents() {
        return students;
    }
}
