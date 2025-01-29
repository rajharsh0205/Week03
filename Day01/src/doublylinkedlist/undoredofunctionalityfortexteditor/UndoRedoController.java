package doublylinkedlist.undoredofunctionalityfortexteditor;


public class UndoRedoController {
    public static void main(String[] args) {
        // Initialize text editor with a history limit of 5 states
        TextEditor editor = new TextEditor(5);

        // Simulating user actions
        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.addState("Hello, World!!");
        editor.addState("Hello, World!!!");

        // Display current state
        editor.displayCurrentState(); // "Hello, World!!!"

        // Perform undo operations
        editor.undo(); // "Hello, World!!"
        editor.undo(); // "Hello, World!"

        // Perform redo operations
        editor.redo(); // "Hello, World!!"
        editor.redo(); // "Hello, World!!!"

        // Adding more states, exceeding the limit
        editor.addState("Hello, Universe!");
        editor.addState("Hello, Universe!!!");

        // Display current state (last state after adding new ones)
        editor.displayCurrentState(); // "Hello, Universe!!!"

        // Performing undo after exceeding limit
        editor.undo(); // "Hello, Universe!"
        editor.undo(); // "Hello, World!!!"
        editor.undo(); // "Hello, World!!"
        editor.undo(); // "Hello, World!"
    }
}
