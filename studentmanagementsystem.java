import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;
    private String contact;

    public Student(String name, int rollNumber, String grade, String contact) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.contact = contact;
    }

    // Getters and Setters
    public String getName() { return name; }
    public int getRollNumber() { return rollNumber; }
    public String getGrade() { return grade; }
    public String getContact() { return contact; }

    public void setName(String name) { this.name = name; }
    public void setGrade(String grade) { this.grade = grade; }
    public void setContact(String contact) { this.contact = contact; }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name + 
               ", Grade: " + grade + ", Contact: " + contact;
    }
}

public class studentmanagementsystem {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.run();
    }

    public void run() {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        System.out.print("Enter contact number: ");
        String contact = scanner.nextLine();

        students.add(new Student(name, rollNumber, grade, contact));
        System.out.println("Student added successfully!");
    }

    private void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }

        System.out.println("\nList of all students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void updateStudent() {
        System.out.print("Enter roll number of student to update: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.print("Enter new name (leave blank to keep current): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) student.setName(name);

                System.out.print("Enter new grade (leave blank to keep current): ");
                String grade = scanner.nextLine();
                if (!grade.isEmpty()) student.setGrade(grade);

                System.out.print("Enter new contact (leave blank to keep current): ");
                String contact = scanner.nextLine();
                if (!contact.isEmpty()) student.setContact(contact);

                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    private void deleteStudent() {
        System.out.print("Enter roll number of student to delete: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == rollNumber) {
                students.remove(i);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    private void searchStudent() {
        System.out.print("Enter roll number of student to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student found:");
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }
}
