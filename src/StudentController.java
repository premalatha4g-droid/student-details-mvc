import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentController {

    Connection con;

    public StudentController() {
        con = DBConnection.getConnection();
    }
    public void addStudent(int id, String name, int marks) {
        try {
            String sql = "INSERT INTO stud (id, name, marks) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, marks);

            ps.executeUpdate();

            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void viewStudents() {
        try {
            String sql = "SELECT * FROM stud";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\nStudents List:");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " - " +
                    rs.getString("name") + " - " +
                    rs.getInt("marks")
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public boolean findStudent(String name) {
        try {
            String sql = "SELECT * FROM stud WHERE name = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }
    public void updateMarks(String name, int marks) {
        try {
            String sql = "UPDATE stud SET marks = ? WHERE name = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, marks);
            ps.setString(2, name);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Marks Updated Successfully");
            else
                System.out.println("Student Not Found");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteStudent(String name) {
        try {
            String sql = "DELETE FROM stud WHERE name = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Deleted Successfully");
            else
                System.out.println("Student Not Found");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}