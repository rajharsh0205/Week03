package doublylinkedlist.undoredofunctionalityfortexteditor;

public class TextState {
    String content; // The text content at a given state
    TextState prev, next; // Doubly linked list pointers

    // Constructor to create a new state with content
    TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}
