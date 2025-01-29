package singlylinkedlist.studentrecordmanagement;

public class StudentManagement {
    private Node head; // Head of the linked list

    // Add a student at the beginning of the list
    void addFirst(int rollNumber, String name, int age, char grade) {
        Node newStudent = new Node(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent; // Set new student as the head of the list
    }

    // Add a student at the end of the list
    void addLast(int rollNumber, String name, int age, char grade) {
        Node newStudent = new Node(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent; // If the list is empty, set the new student as the head
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // Traverse to the last student
            }
            current.next = newStudent; // Add new student at the end
        }
    }

    // Insert a student at a specified position in the list
    void insertAtPosition(int rollNumber, String name, int age, char grade, int position) {
        Node newStudent = new Node(rollNumber, name, age, grade);
        if (position == 1) {
            newStudent.next = head;
            head = newStudent; // Insert at the beginning
            return;
        }
        Node current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next; // Traverse to the node before the target position
            count++;
        }
        if (current == null) {
            System.out.println("Position out of bound");
            return;
        }
        newStudent.next = current.next;
        current.next = newStudent; // Insert the new student at the specified position
    }

    // Delete a student by roll number
    void deleteByRollNo(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.getRollNo() == rollNumber) {
            head = head.next; // If the head is to be deleted, adjust the head pointer
            System.out.println("Record with Roll Number " + rollNumber + " has been deleted.");
            return;
        }
        Node current = head;
        Node previous = null;
        while (current != null && current.getRollNo() != rollNumber) {
            previous = current;
            current = current.next; // Traverse to find the student by roll number
        }
        if (current == null) {
            System.out.println("Record with Roll Number " + rollNumber + " not found.");
            return;
        }
        previous.next = current.next; // Remove the student from the list
        System.out.println("Record with Roll Number " + rollNumber + " has been deleted.");
    }

    // Search for a student by roll number and display the details
    void searchByRollNo(int rollNumber) {
        boolean flag = false;
        if (head == null) {
            System.out.println("The list is empty. No records to search.");
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.getRollNo() == rollNumber) {
                flag = true;
                System.out.println("Student Record Found:");
                System.out.println("Name of the Student is: " + current.getName());
                System.out.println("Age of the Student is: " + current.getAge());
                System.out.println("Roll Number of the Student is: " + current.getRollNo());
                System.out.println("Grade of the student is: " + current.getGrade());
                return;
            }
            current = current.next; // Continue searching in the next node
        }
        if (flag == false) {
            System.out.println("Record not found!");
        }
    }

    // Display all student records in the list
    void displayRecord() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println("Name of the Student is: " + current.getName());
            System.out.println("Age of the Student is: " + current.getAge());
            System.out.println("Roll Number of the Student is: " + current.getRollNo());
            System.out.println("Grade of the student is: " + current.getGrade());
            current = current.next; // Move to the next student
        }
    }

    // Update grade for a student by roll number
    public void updateGradeByRollNumber(int rollNumber, char newGrade) {
        if (head == null) {
            System.out.println("The list is empty. No records to update.");
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.getRollNo() == rollNumber) {
                // Update the grade if the student is found
                System.out.println("Record found! Updating grade...");
                System.out.println("Old Grade: " + current.getGrade());
                current.setGrade(newGrade);
                System.out.println("New Grade: " + current.getGrade());
                return;
            }
            current = current.next; // Continue searching for the student
        }
        // If the student is not found
        System.out.println("No record found with Roll Number " + rollNumber);
    }
}
