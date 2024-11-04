
import java.util.ArrayList;
import java.util.List;

// Step 1: Create the Observer Interface

interface Observer {
    void update(String message);
}


// Step 2: Create the Subject Class

// Here we can also create an Subject interface as well .

class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    // Add observer to list
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // Remove observer from list
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    // Notify all observers about state change
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    // Change state and notify observers
    public void setState(String newState) {
        this.state = newState;
        notifyObservers();
    }
}

// Step 3: Create Concrete Observers
class ConcreteObserverA implements Observer {
    private String name;

    public ConcreteObserverA(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

class ConcreteObserverB implements Observer {
    private String name;

    public ConcreteObserverB(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}


//Step 4: Testing the Observer Pattern
public class Main {
    public static void main(String[] args) {
        // Create subject
        Subject subject = new Subject();

        // Create observers
        Observer observer1 = new ConcreteObserverA("Observer A");
        Observer observer2 = new ConcreteObserverB("Observer B");

        // Attach observers to subject
        subject.attach(observer1);
        subject.attach(observer2);

        // Change subject state and notify observers
        System.out.println("Changing state to 'New State 1'");
        subject.setState("New State 1");

        System.out.println("\nChanging state to 'New State 2'");
        subject.setState("New State 2");
    }
}
