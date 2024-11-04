// --------------------------------------- ATM Withdrawal Handler  ---------------------------  
// Step 1: Define the handler interface 
/*  abstract class CashDispenser {
    protected CashDispenser nextDispenser;
    public void setNextDispenser(CashDispenser nextDispenser) {
        this.nextDispenser = nextDispenser;
    }
    public abstract void dispense(int amount);
}

// Step 2: Create concrete dispensers  
class Rs2000Dispenser extends CashDispenser {
    public void dispense(int amount) {
        if (amount >= 2000) {
            int count = amount / 2000;
            int remainder = amount % 2000;
            System.out.println("Dispensing " + count + " Rs 2000 notes");
            if (remainder != 0) nextDispenser.dispense(remainder);
        } else {
            nextDispenser.dispense(amount);
        }
    }
}

class Rs500Dispenser extends CashDispenser {
    public void dispense(int amount) {
        if (amount >= 500) {
            int count = amount / 500;
            int remainder = amount % 500;
            System.out.println("Dispensing " + count + " Rs 500 notes");
            if (remainder != 0) nextDispenser.dispense(remainder);
        } else {
            nextDispenser.dispense(amount);
        }
    }
}

class Rs100Dispenser extends CashDispenser {
    public void dispense(int amount) {
        if (amount >= 100) {
            int count = amount / 100;
            System.out.println("Dispensing " + count + " Rs 100 notes");
        }
        else{
           System.out.println("Enter Amount Multiple of 100"); 
        }
    }
}

// Step 3: Set up and test the chain
public class Chain_Of_Responsibility { 
    public static void main(String[] args) {
        CashDispenser rs2000Dispenser = new Rs2000Dispenser();
        CashDispenser rs500Dispenser = new Rs500Dispenser();
        CashDispenser rs100Dispenser = new Rs100Dispenser();

        rs2000Dispenser.setNextDispenser(rs500Dispenser);
        rs500Dispenser.setNextDispenser(rs100Dispenser);

        int amount = 3700;
        rs2000Dispenser.dispense(amount);
    }
}

*/



























//  ------------------------------ Customer Support System Example --------------------------- 

// Step 1: Define an enum to represent different issue levels

/* 
enum IssueLevel {
    LOW, MEDIUM, HIGH
}

// Step 2: Define a SupportHandler abstract class
abstract class SupportHandler {
    protected SupportHandler nextHandler;

    // Method to set the next handler in the chain
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // Method to handle the request
    public void handleRequest(IssueLevel issueLevel) {
        if (canHandle(issueLevel)) {
            handle(issueLevel);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issueLevel);
        } else {
            System.out.println("Issue could not be resolved.");
        }
    }

    // Abstract method for each handler to implement
    protected abstract boolean canHandle(IssueLevel issueLevel);
    protected abstract void handle(IssueLevel issueLevel);
}

// Step 3: Define concrete handlers for each support level

class BasicSupport extends SupportHandler {
    @Override
    protected boolean canHandle(IssueLevel issueLevel) {
        return issueLevel == IssueLevel.LOW;
    }

    @Override
    protected void handle(IssueLevel issueLevel) {
        System.out.println("Basic Support: Resolving low-level issue.");
    }
}

class TechnicalSupport extends SupportHandler {
    @Override
    protected boolean canHandle(IssueLevel issueLevel) {
        return issueLevel == IssueLevel.MEDIUM;
    }

    @Override
    protected void handle(IssueLevel issueLevel) {
        System.out.println("Technical Support: Resolving medium-level issue.");
    }
}

class ManagerialSupport extends SupportHandler {
    @Override
    protected boolean canHandle(IssueLevel issueLevel) {
        return issueLevel == IssueLevel.HIGH;
    }

    @Override
    protected void handle(IssueLevel issueLevel) {
        System.out.println("Managerial Support: Resolving high-level issue.");
    }
}

// Step 4: Set up and test the chain
public class CustomerSupportSystem {
    public static void main(String[] args) {
        // Create the support handlers
        SupportHandler basicSupport = new BasicSupport();
        SupportHandler technicalSupport = new TechnicalSupport();
        SupportHandler managerialSupport = new ManagerialSupport();

        // Build the chain
        basicSupport.setNextHandler(technicalSupport);
        technicalSupport.setNextHandler(managerialSupport);

        // Test the chain with different issue levels
        System.out.println("Testing with LOW level issue:");
        basicSupport.handleRequest(IssueLevel.LOW);

        System.out.println("\nTesting with MEDIUM level issue:");
        basicSupport.handleRequest(IssueLevel.MEDIUM);

        System.out.println("\nTesting with HIGH level issue:");
        basicSupport.handleRequest(IssueLevel.HIGH);

        System.out.println("\nTesting with UNKNOWN level issue:");
        basicSupport.handleRequest(null); // Null or any unhandled level
    }
}
*/ 



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