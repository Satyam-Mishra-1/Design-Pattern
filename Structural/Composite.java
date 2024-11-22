import java.util.ArrayList;
import java.util.List;

// Step 1: Define the Component Interface
interface FileSystem {
    void display();
}

// Step 2: Create the Leaf Class
class File implements FileSystem {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println(" File: " + name);
    }
}

// Step 3: Create the Composite Class
class Folder implements FileSystem {
    private String name;
    private List<FileSystem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystem component) {
        children.add(component);
    }

    public void remove(FileSystem component) {
        children.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Folder: " + name);
        for (FileSystem child : children) {
            child.display();
        }
    }
}

// Step 4: Client Code
public class CompositePatternExample{
    public static void main(String[] args) {
        // Create individual files
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("file3.doc");

        // Create folders
        Folder folder1 = new Folder("Documents");
        Folder folder2 = new Folder("Pictures");

        // Add files to folders
        folder1.add(file1);
        folder1.add(file2);
        folder2.add(file3);

        // Create a root folder
        Folder rootFolder = new Folder("Root");
        rootFolder.add(folder1);
        rootFolder.add(folder2);

        // Display the entire structure
        rootFolder.display();
    }
}
