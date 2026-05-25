import java.util.Scanner;
class StudentView{
    Scanner sc = new Scanner(System.in);
    void showMenu(){
        System.out.println("\n--- Student Menu ---");
        System.out.println("1. Display Students");
        System.out.println("2. Search Student");
        System.out.println("3. Update Marks");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
    }
    int getChoice(){
        System.out.print("Enter choice: ");
        return sc.nextInt();
    }
    String getName(String msg){
        sc.nextLine();
        System.out.print(msg);
        return sc.nextLine();
    }
    int getMarks(){
        System.out.print("Enter Marks: ");
        return sc.nextInt();
    }
    void displayStudents(Student[] students, int count){
        System.out.println("\nStudents List:");
        for (int i = 0; i < count; i++) {
            System.out.println(
                    students[i].id + " - " +
                    students[i].name + " - " +
                    students[i].marks);
        }
    }
    void showMessage(String msg){
        System.out.println(msg);
    }
}