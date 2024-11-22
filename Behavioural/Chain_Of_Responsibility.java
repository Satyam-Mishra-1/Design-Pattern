

abstract class CashDispenser{
    protected CashDispenser nextDispenser;
    public void setNextDispenser(CashDispenser nextDispenser){
        this.nextDispenser = nextDispenser;
    }

    public abstract void dispense(int amount);
}

class dispense2000 extends CashDispenser{
      public void dispense(int amount){
        if(amount >= 2000){
            int count = amount / 2000;
            int rem = amount % 2000; 
            
            System.out.println("Dispensing " + count + " Notes of 2000 ");
            if(rem != 0) nextDispenser.dispense(rem);
        }
        else{
            nextDispenser.dispense(amount);
        }
      }
}
            
class dispense500 extends CashDispenser{
      public void dispense(int amount){
        if(amount >= 500){
            int count = amount / 500;
            int rem = amount % 500; 
            
            System.out.println("Dispensing " + count + " Notes of 500 ");
            if(rem != 0) nextDispenser.dispense(rem);
        }
        else{
            nextDispenser.dispense(amount);
        }
      }
}

class dispense100 extends CashDispenser{
      public void dispense(int amount){
        if(amount >= 100){
            int count = amount / 100;
            int rem = amount % 100; 
            
            System.out.println("Dispensing " + count + " Notes of 100 ");
            if(rem != 0) nextDispenser.dispense(rem);
        }
        else{
            System.out.println("This Amount "+ amount +" Cann't be Despensiated from Machine");
        }
      }
}


public class Chain_Of_Responsibility{
    public static void main(String args[]){
        CashDispenser c2000 = new dispense2000();
        CashDispenser c500 = new dispense100();
        CashDispenser c100 = new dispense100();

        c2000.setNextDispenser(c500);
        c500.setNextDispenser(c100);

        c2000.dispense(3700);
    }
}