// 1.  Eager Initialization 

public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return instance;
    }
}


// 2. Lazy Initialization 
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}


// 3. Thread- Safe Innitialization(Multi Threaded) 
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}




// class Singleton{
//     private String name;
//     private int age;


//     private static Singleton inst = null ;


//     private Singleton(String name,int age){
//         this.name = name;
//         this.age = age;
//     }


//     public static Singleton getInstance(String name, int age){
//         if(inst == null ){
//             inst = new Singleton(name,age);
//         }
//         return inst;
//     }


//      public void doWork(){
//         System.out.println("The Name and Age is : "+ this.name + " " + this.age);
//      }
// }


// public class Pract{
//     public static void main(String args[]){
//         Singleton s1 = Singleton.getInstance("Ram",12);
//         s1.doWork();
//     }
// }



// Eager
public Singleton{
    private static final Singleton ins = new Singleton();

    private Singleton() {}

    public static Singleton getInstance(){
        return ins;
    }
}

// Lazy
public Singleton{
    private static Singleton ins;

    private Singleton() {}

    public static Singleton getInstance(){
        if(ins == null) {
            ins = new Singleton();
        }
        return ins;
    }
}

// Thread Safe
public Singleton{
    private static final Singleton ins;

    private Singleton() {}

    public synchronized Singleton getInstance(){
        if(ins == null) {
            ins = new Singleton();
        }
        return ins;
    }
}