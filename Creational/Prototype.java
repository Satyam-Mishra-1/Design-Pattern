public interface Prototype {
    Prototype clone();
}


// Step 2: Concrete Classes Implementing Prototype
public class Circle implements Prototype {
    private String color;

    public Circle(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public Prototype clone() {
        return new Circle(this.color); // Deep copy (if color were a reference, you'd copy it too)
    }

    @Override
    public String toString() {
        return "Circle with color: " + color;
    }
}


public class Rectangle implements Prototype {
    private String color;

    public Rectangle(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public Prototype clone() {
        return new Rectangle(this.color); // Deep copy
    }

    @Override
    public String toString() {
        return "Rectangle with color: " + color;
    }
}


// Step 3: Prototype Registry
import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {
    private Map<String, Prototype> prototypes = new HashMap<>();

    // Register a prototype
    public void registerPrototype(String key, Prototype prototype) {
        prototypes.put(key, prototype);
    }

    // Clone a prototype by key
    public Prototype getPrototype(String key) {
        Prototype prototype = prototypes.get(key);
        if (prototype != null) {
            return prototype.clone();
        }
        throw new IllegalArgumentException("No prototype found for key: " + key);
    }
}



// Step 4: Test the Prototype Pattern
public class PrototypePatternDemo {
    public static void main(String[] args) {

        PrototypeRegistry registry = new PrototypeRegistry();

        registry.registerPrototype("blueCircle", new Circle("Blue"));
        registry.registerPrototype("redRectangle", new Rectangle("Red"));

        Prototype clonedCircle = registry.getPrototype("blueCircle");
        Prototype clonedRectangle = registry.getPrototype("redRectangle");

    
        System.out.println(clonedCircle);
        System.out.println(clonedRectangle);

        
        Prototype anotherCircle = registry.getPrototype("blueCircle");
        System.out.println("Are the circles different objects? " + (clonedCircle != anotherCircle));
    }
}


