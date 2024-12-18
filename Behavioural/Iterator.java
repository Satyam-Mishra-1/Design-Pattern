//                   ----------------- Example 1:  Iterator for a Shopping Cart  ------------------- 

import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}



interface ProductIterator {
    boolean hasNext();
    Product next();
}

interface ProductCollection {
    ProductIterator createIterator();
}



class ShoppingCart implements ProductCollection {
    private List<Product> products = new ArrayList<>();

    public void addProduct(String name, double price) {
        products.add(new Product(name, price));
    }

    @Override
    public ProductIterator createIterator() {
        return new ShoppingCartIterator(products);
    }
}


class ShoppingCartIterator implements ProductIterator {
    private List<Product> products;
    private int position = 0;

    public ShoppingCartIterator(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return position < products.size();
    }

    @Override
    public Product next() {
        return products.get(position++);
    }
}






public class Iterator {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 1000.00);
        cart.addProduct("Smartphone", 500.00);
        cart.addProduct("Tablet", 300.00);

        ProductIterator iterator = cart.createIterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            System.out.println("Product: " + product.getName() + ", Price: $" + product.getPrice());
        }
    }
}
