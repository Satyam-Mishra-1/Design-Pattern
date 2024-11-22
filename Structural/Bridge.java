// Step 1: Define the Implementation Interface
interface Color {
    void applyColor();
}

// Step 2: Implement Concrete Implementations
class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying Red color");
    }
}

class BlueColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying Blue color");
    }
}

// Step 3: Define the Abstraction
abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

// Step 4: Implement Refined Abstractions
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing Circle in ");
        color.applyColor();
    }
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing Square in ");
        color.applyColor();
    }
}

// Step 5: Client Code
public class BridgePatternExample {
    public static void main(String[] args) {
        // Create shapes with different colors
        Shape redCircle = new Circle(new RedColor());
        Shape blueSquare = new Square(new BlueColor());

        // Draw the shapes
        redCircle.draw();
        blueSquare.draw();
    }
}
