import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerStudent manager = new ManagerStudent();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("=== Student Management System ===");
            System.out.println("1. Search student by name");
            System.out.println("2. Get students by rank");
            System.out.println("3. Sort students by name and average");
            System.out.println("4. Chưa làm được câu F");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name to search: ");
                    String searchName = scanner.nextLine();
                    Student foundStudent = manager.searchStudentByName(searchName);
                    if (foundStudent != null) {
                        System.out.println("Found student: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter rank to search: ");
                    String rankToSearch = scanner.nextLine();
                    List<Student> studentsByRank = manager.getStudentsByRank(rankToSearch);
                    System.out.println("Students with rank " + rankToSearch + ": " + studentsByRank);
                    break;

                case 3:
                    manager.sortStudentsByNameAndAvg();
                    System.out.println("Students sorted by name and average: " + manager.getStudents());
                    break;

                case 4:
                System.out.println("Chưa làm được câu F.");
                    break;

                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}