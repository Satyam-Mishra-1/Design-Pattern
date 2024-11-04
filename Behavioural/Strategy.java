
// Consider a scenario where we need to implement a payment system with multiple payment methods (like credit card, PayPal, and Google Pay). Using the Strategy pattern, each payment method can be encapsulated as a separate strategy.

// 1. Define the Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}


//2. Implement Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String name, String cardNumber, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Credit Card.");
    }
}



class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal.");
    }
}


// 3. Define the Context Class
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}



//     4. Client Code
public class Strategy {
    public static void main(String[] args) {


        ShoppingCart cart = new ShoppingCart();
        
        
        // Pay using Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("John Doe", "123456789", "123", "12/25"));
        cart.checkout(150);

        // Change strategy to PayPal and pay
        cart.setPaymentStrategy(new PayPalPayment("john@example.com"));
        cart.checkout(75);
    }
}

