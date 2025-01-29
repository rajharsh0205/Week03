package singlylinkedlist.studentrecordmanagement;

public class Node {
    // Node class to store student data and link to the next student
    private int rollNumber;
    private String name;
    private int age;
    private char grade;
    Node next;

    // Constructor to initialize student details
    Node(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null; // Initialize next as null
    }

    // Setter for grade
    void setGrade(char grade) {
        this.grade = grade;
    }

    // Getter methods for student data
    int getRollNo() {
        return rollNumber;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    char getGrade() {
        return grade;
    }
}
