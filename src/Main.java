import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentController controller = new StudentController();
        StudentView view = new StudentView();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            controller.addStudent(id, name, marks);
        }

        while (true) {

            view.showMenu();
            int choice = view.getChoice();

            switch (choice) {

                case 1:
                    controller.viewStudents();
                    break;

                case 2:
                    String search = view.getName("Enter student name: ");
                    if (controller.findStudent(search))
                        System.out.println("Student Found");
                    else
                        System.out.println("Student Not Found");
                    break;

                case 3:
                    String update = view.getName("Enter student name: ");
                    int marks = view.getMarks();
                    controller.updateMarks(update, marks);
                    break;

                case 4:
                    String del = view.getName("Enter student name: ");
                    controller.deleteStudent(del);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}