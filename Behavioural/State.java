
//  1. Define the State Interface
interface PlayerState {
    void play(AudioPlayerContext context);
    void pause(AudioPlayerContext context);
    void stop(AudioPlayerContext context);
}

//  2. Create Concrete States
class PlayingState implements PlayerState {
    @Override
    public void play(AudioPlayerContext context) {
        System.out.println("Already playing.");
    }

    @Override
    public void pause(AudioPlayerContext context) {
        System.out.println("Pausing the player.");
        context.setState(new PausedState());
    }

    @Override
    public void stop(AudioPlayerContext context) {
        System.out.println("Stopping the player.");
        context.setState(new StoppedState());
    }
}



class PausedState implements PlayerState {
    @Override
    public void play(AudioPlayerContext context) {
        System.out.println("Resuming playback.");
        context.setState(new PlayingState());
    }

    @Override
    public void pause(AudioPlayerContext context) {
        System.out.println("Already paused.");
    }

    @Override
    public void stop(AudioPlayerContext context) {
        System.out.println("Stopping the player.");
        context.setState(new StoppedState());
    }
}




class StoppedState implements PlayerState {
    @Override
    public void play(AudioPlayerContext context) {
        System.out.println("Starting playback.");
        context.setState(new PlayingState());
    }

    @Override
    public void pause(AudioPlayerContext context) {
        System.out.println("Can't pause. The player is stopped.");
    }

    @Override
    public void stop(AudioPlayerContext context) {
        System.out.println("Already stopped.");
    }
}





//  3. Create the Context
class AudioPlayerContext {
    private PlayerState state;

    public AudioPlayerContext() {
        state = new StoppedState(); // Initial state
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public void play() {
        state.play(this);
    }

    public void pause() {
        state.pause(this);
    }

    public void stop() {
        state.stop(this);
    }
}





//  4. Client Code
public class State {
    public static void main(String[] args) {
        AudioPlayerContext player = new AudioPlayerContext();

        player.play();   // Moves to Playing
        player.pause();  // Moves to Paused
        player.play();   // Resumes playing
        player.stop();   // Moves to Stopped
        player.pause();  // Shows that pause action is not available in Stopped state
    }
}
