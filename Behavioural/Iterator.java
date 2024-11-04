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

















//                            ---------------- Example - 2 :  Iterator for a Library of Books  -----------------
/*
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}





interface BookIterator {
    boolean hasNext();
    Book next();
}

interface BookCollection {
    BookIterator createIterator();
}






class Library implements BookCollection {
    private List<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    @Override
    public BookIterator createIterator() {
        return new LibraryIterator(books);
    }
}

class LibraryIterator implements BookIterator {
    private List<Book> books;
    private int position = 0;

    public LibraryIterator(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }

    @Override
    public Book next() {
        return books.get(position++);
    }
}






public class LibraryIteratorExample {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook("Moby Dick", "Herman Melville");
        library.addBook("1984", "George Orwell");

        BookIterator iterator = library.createIterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println("Reading: " + book.getTitle() + " by " + book.getAuthor());
        }
    }
}

*/
