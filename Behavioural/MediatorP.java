//                         --------------  Example - 1  ---------------- 
/*
import java.util.ArrayList;
import java.util.List;

//Step:1 Mediator Interface 
interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}


//Step:2 Create the Concrete Mediator
class ChatRoom implements ChatMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            // Message should not be sent to the sender
            if (user != sender) {
                user.receive(message);
            }
        }
    }
}


//Step:3  Define the Colleague Class
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}


// Step 4: Create Concrete Colleague Classes
class UserImpl extends User {
    public UserImpl(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " receives: " + message);
    }
}


//Step:5 Use the Mediator Pattern
public class Mediator {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        User user1 = new UserImpl(chatRoom, "Alice");
        User user2 = new UserImpl(chatRoom, "Bob");
        User user3 = new UserImpl(chatRoom, "Charlie");
        User user4 = new UserImpl(chatRoom, "Diana");

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);
        chatRoom.addUser(user4);

        user1.send("Hello, everyone!");
    }
}

*/


import java.util.*;

interface ChatMediator {
     public void sendMessage(String Mssg,User user);
     public void addUser(User user);
}

class Mediator implements ChatMediator {
      private List<User> users;

      public Mediator(){
        this.users = new ArrayList<>();
      }

      public void addUser(User user){
        users.add(user);
      }

      public void sendMessage(String Mssg,User sender){
         for(User user: users){
            if(user!=sender){
                user.receive(Mssg);
            }
         }
      }
}

abstract class User{
    protected String name;
    protected ChatMediator Medi ;

    public User(ChatMediator Medi,String name){
        this.Medi = Medi;
        this.name = name;
    }

    public abstract void send(String Mssg);
    public abstract void receive(String Mssg);
}


class UserImpl extends User{
     
     public UserImpl(ChatMediator Medi,String name){
        super(Medi,name);
     }

     public void send(String Mssg){
          System.out.println(this.name + " User Sends Mssg");
          Medi.sendMessage(Mssg,this);
     }

     public void receive(String Mssg){
        System.out.println(this.name +  " User Mssg Received ");
     }
}

class MediatorP{
    public static void main(String args[]){
    ChatMediator m1 = new Mediator();

    User u1 = new UserImpl( m1,"Ramu");
    User u2 = new UserImpl( m1,"Ramuu");
    User u3 = new UserImpl( m1,"Ramuzzzz");

    m1.addUser(u1);
    m1.addUser(u2);
    m1.addUser(u3);

    u1.send("Hello World");
}
}


