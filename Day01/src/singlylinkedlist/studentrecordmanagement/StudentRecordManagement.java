package singlylinkedlist.studentrecordmanagement;

public class StudentRecordManagement {
    public static void main(String[] args) {
        // Create an instance of StudentManagement to manage student records
        StudentManagement studentList = new StudentManagement();

        // Add students at different positions in the list
        studentList.addFirst(1, "honey", 15, 'B');
        studentList.addFirst(2, "Monu", 17, 'A');
        studentList.addLast(3, "Sonu", 14, 'C');
        studentList.insertAtPosition(4, "Yaya", 18, 'B', 3);

        // Display records after adding students
        System.out.println("--------------------");

        // Search for a student by roll number and display their details
        System.out.println("Search By roll Number");
        studentList.searchByRollNo(2);
        System.out.println("--------------------");

        // Update grade for a student based on roll number
        studentList.updateGradeByRollNumber(1, 'A');

        // Display all records after updating the grade
        System.out.println("Display record after update");
        studentList.displayRecord();
        System.out.println("--------------------");

        // Delete a student record by roll number
        studentList.deleteByRollNo(3);

        // Display all records after deletion
        System.out.println("Display record after delete");
        studentList.displayRecord();
        System.out.println("--------------------");
    }
}
