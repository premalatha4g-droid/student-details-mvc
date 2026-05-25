class StudentController{
    Student[] students;
    int count;
    StudentController(int size){
        students = new Student[size];
        count = 0;
    }
    void addStudent(int id, String name, int marks){
        students[count++] = new Student(id, name, marks);
    }
    Student[] getStudents(){
        return students;
    }
    int getCount(){
        return count;
    }
    Student findStudent(String name){
        for (int i = 0; i < count; i++){
            if (students[i].name.equalsIgnoreCase(name)){
                return students[i];
            }
        }
        return null;
    }
    String updateMarks(String name, int newMarks){
        Student s = findStudent(name);
        if (s == null)
            return "Student Not Found";
        s.marks = newMarks;
        return "Marks Updated Successfully";
    }
    String deleteStudent(String name){
        for (int i = 0; i < count; i++){
            if (students[i].name.equalsIgnoreCase(name)){
                for (int j = i; j < count - 1; j++){
                    students[j] = students[j + 1];
                }
                students[count - 1] = null;
                count--;
                return "Student Deleted Successfully";
            }
        }
        return "Student Not Found";
    }
}