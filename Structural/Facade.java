// Step 1: Subsystem Classes
class TV {
    public void turnOn() {
        System.out.println("TV is turned ON.");
    }

    public void turnOff() {
        System.out.println("TV is turned OFF.");
    }
}

class SoundSystem {
    public void setVolume(int level) {
        System.out.println("Sound System volume set to " + level + ".");
    }
}

class StreamingDevice {
    public void playMovie(String movieName) {
        System.out.println("Playing movie: " + movieName + ".");
    }

    public void stopMovie() {
        System.out.println("Stopping the movie.");
    }
}

// Step 2: Facade Class
class HomeTheaterFacade {
    private TV tv;
    private SoundSystem soundSystem;
    private StreamingDevice streamingDevice;

    public HomeTheaterFacade(TV tv, SoundSystem soundSystem, StreamingDevice streamingDevice) {
        this.tv = tv;
        this.soundSystem = soundSystem;
        this.streamingDevice = streamingDevice;
    }

    public void watchMovie(String movieName) {
        System.out.println("Get ready to watch a movie...");
        tv.turnOn();
        soundSystem.setVolume(10);
        streamingDevice.playMovie(movieName);
        System.out.println("Enjoy the movie!");
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        streamingDevice.stopMovie();
        tv.turnOff();
        System.out.println("Home theater is off.");
    }
}

// Step 3: Client Code
public class FacadePatternExample {
    public static void main(String[] args) {
        // Subsystem instances
        TV tv = new TV();
        SoundSystem soundSystem = new SoundSystem();
        StreamingDevice streamingDevice = new StreamingDevice();

        // Facade instance
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, soundSystem, streamingDevice);

        // Use the facade to operate the home theater
        homeTheater.watchMovie("Inception");
        System.out.println();
        homeTheater.endMovie();
    }
}
