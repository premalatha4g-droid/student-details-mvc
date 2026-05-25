public class Main{
    public static void main(String[] args){
        StudentController controller = new StudentController(10);
        StudentView view = new StudentView();
        controller.addStudent(1, "Arun", 85);
        controller.addStudent(2, "Priya", 90);
        controller.addStudent(3, "Rahul", 78);
        while (true){
            view.showMenu();
            int choice = view.getChoice();
            switch (choice){
                case 1:
                    view.displayStudents(
                            controller.getStudents(),
                            controller.getCount());
                    break;
                case 2:
                    String search = view.getName("Enter student name: ");
                    if (controller.findStudent(search) != null)
                        view.showMessage("Student Found");
                    else
                        view.showMessage("Student Not Found");

                    break;
                case 3:
                    String update = view.getName("Enter student name: ");
                    int marks = view.getMarks();
                    view.showMessage(
                            controller.updateMarks(update, marks));
                    break;
                case 4:
                    String del = view.getName("Enter student name: ");
                    view.showMessage(
                            controller.deleteStudent(del));
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