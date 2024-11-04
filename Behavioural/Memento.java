 import java.util.Stack;
 
// 1. Define the Memento Class
class TextEditorMemento {
    private final String content;

    public TextEditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}



//  2. Create the Originator Class
class TextEditor {

    private String content = "";

    public void write(String text) {
        content += text;
    }

    public String getContent() {
        return content;
    }

    // Creates a memento of the current content
    public TextEditorMemento save() {
        return new TextEditorMemento(content);
    }

    // Restores the content from a memento
    public void undoToLastSave(TextEditorMemento memento) {
        content = memento.getContent();
    }
}



// 3. Implement the Caretaker Class

class TextEditorCaretaker {
    private final Stack<TextEditorMemento> history = new Stack<>();

    public void save(TextEditor editor) {
        history.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            editor.undoToLastSave(history.pop());
        } else {
            System.out.println("No states to undo.");
        }
    }
}



// 4. Client Code to Test the Memento Pattern

public class Memento {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        TextEditorCaretaker caretaker = new TextEditorCaretaker();

        editor.write("Hello, ");
        caretaker.save(editor);

        editor.write("world!");
        caretaker.save(editor);

        editor.write(" This is a test.");
        System.out.println("Current Content: " + editor.getContent());

        caretaker.undo(editor);
        System.out.println("After undo: " + editor.getContent());

        caretaker.undo(editor);
        System.out.println("After second undo: " + editor.getContent());
    }
}
