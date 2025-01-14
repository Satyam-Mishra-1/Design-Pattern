// Step 1: Define the Visitable interface
interface Shape {
    void accept(ShapeVisitor visitor);
}

// Step 2: Create Concrete Visitable classes
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

// Step 3: Define the Visitor interface
interface ShapeVisitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
    void visit(Triangle triangle);
}

// Step 4: Create Concrete Visitor classes
class AreaCalculator implements ShapeVisitor {
    @Override
    public void visit(Circle circle) {
        double area = Math.PI * Math.pow(circle.getRadius(), 2);
        System.out.println("Circle Area: " + area);
    }

    @Override
    public void visit(Rectangle rectangle) {
        double area = rectangle.getLength() * rectangle.getWidth();
        System.out.println("Rectangle Area: " + area);
    }

    @Override
    public void visit(Triangle triangle) {
        double area = 0.5 * triangle.getBase() * triangle.getHeight();
        System.out.println("Triangle Area: " + area);
    }
}

class Renderer implements ShapeVisitor {
    @Override
    public void visit(Circle circle) {
        System.out.println("Rendering a Circle with radius: " + circle.getRadius());
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("Rendering a Rectangle with length: " + rectangle.getLength() + ", width: " + rectangle.getWidth());
    }

    @Override
    public void visit(Triangle triangle) {
        System.out.println("Rendering a Triangle with base: " + triangle.getBase() + ", height: " + triangle.getHeight());
    }
}

// Step 5: Demonstrate the Visitor Pattern
public class VisitorPatternDemo {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[] {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 7)
        };

        ShapeVisitor areaCalculator = new AreaCalculator();
        ShapeVisitor renderer = new Renderer();

        System.out.println("Calculating Areas:");
        for (Shape shape : shapes) {
            shape.accept(areaCalculator);
        }

        System.out.println("\nRendering Shapes:");
        for (Shape shape : shapes) {
            shape.accept(renderer);
        }
    }
}
