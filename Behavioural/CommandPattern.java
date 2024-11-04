 
// Command Interface
interface Command {
    void execute();
    void undo();  // Optional method for undo functionality
}

// Receiver Class (Light)
class Light {
    protected int intensity = 0;  // Light intensity level from 0 to 100

    public void turnOn() {
        intensity = 100;
        System.out.println("Light is ON with intensity: " + intensity);
    }

    public void turnOff() {
        intensity = 0;
        System.out.println("Light is OFF.");
    }

    public void setIntensity(int level) {
        intensity = level;
        System.out.println("Light intensity set to: " + intensity);
    }
}

// Concrete Command for turning on the light
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }

    public void undo() {
        light.turnOff();
    }
}

// Concrete Command for turning off the light
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }

    public void undo() {
        light.turnOn();
    }
}

// Concrete Command for setting light intensity 
class SetIntensityCommand implements Command {
    private Light light;
    private int previousIntensity;
    private int newIntensity;

    public SetIntensityCommand(Light light, int newIntensity) {
        this.light = light;
        this.newIntensity = newIntensity;
    }

    public void execute() {
        previousIntensity = light.intensity;
        light.setIntensity(newIntensity);
    }

    public void undo() {
        light.setIntensity(previousIntensity);
    }
}

// Invoker class (Remote Control)
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndo() {
        command.undo();
    }
}

// Client code
public class CommandPattern {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command setIntensity = new SetIntensityCommand(livingRoomLight, 50);

        RemoteControl remote = new RemoteControl();

        // Turn the light on
        remote.setCommand(lightOn);
        remote.pressButton();

        // Set intensity
        remote.setCommand(setIntensity);
        remote.pressButton();

        // Undo intensity setting
        remote.pressUndo();

        // Turn the light off
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}



























//                        --------------  Example -2 ---------------


/*
// Command Interface
interface Command {
    void execute();
    void undo();
}


// Receiver Class (e.g., Light)
class Light {
    public void turnOn() {
        System.out.println("The light is on.");
    }
    public void turnOff() {
        System.out.println("The light is off.");
    }
}

// Concrete Command for turning the light on
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}

// Concrete Command for turning the light off
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}


// Invoker Class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndo() {
        command.undo();
    }
}


public class CommandPatternExample {
    public static void main(String[] args) {
        // Receiver
        Light livingRoomLight = new Light();

        // Concrete Commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // Turn the light on
        remote.setCommand(lightOn);
        remote.pressButton(); // Output: The light is on.

        // Turn the light off
        remote.setCommand(lightOff);
        remote.pressButton(); // Output: The light is off.

        // Undo last command (light will turn on)
        remote.pressUndo();   // Output: The light is on.
    }
}



*/