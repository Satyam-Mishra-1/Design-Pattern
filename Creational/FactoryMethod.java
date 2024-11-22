// // Step 1: Define the Product interface
// interface Shape {
//     void draw();
// }


// // Step 2: Create Concrete Products
// class Circle implements Shape {
//     @Override
//     public void draw() {
//         System.out.println("Drawing a Circle");
//     }
// }


// class Rectangle implements Shape {
//     @Override
//     public void draw() {
//         System.out.println("Drawing a Rectangle");
//     }
// }


// // Step 3: Define the Factory Method Creator
// abstract class ShapeFactory {
//     abstract Shape createShape();
// }


// // Step 4: Create Concrete Factories
// class CircleFactory extends ShapeFactory {
//     @Override
//     Shape createShape() {
//         return new Circle();
//     }
// }


// class RectangleFactory extends ShapeFactory {
//     @Override
//     Shape createShape() {
//         return new Rectangle();
//     }
// }


// // Step 5: Use the Factory Method
// public class FactoryMethodExample {
//     public static void main(String[] args) {
//         // Create a Circle using the factory method
//         ShapeFactory circleFactory = new CircleFactory();
//         Shape circle = circleFactory.createShape();
//         circle.draw();

//         // Create a Rectangle using the factory method
//         ShapeFactory rectangleFactory = new RectangleFactory();
//         Shape rectangle = rectangleFactory.createShape();
//         rectangle.draw();
//     }
// }



/

abstract class Shape{
  abstract void toDraw();
}


class Circle extends Shape{
      public String Shape;


      Circle(String Shape){
        this.Shape = Shape;
      }


      void toDraw(){
        System.out.println("The Shape is : "+ this.Shape);
      }
}


class Rectangle extends Shape{
      public String Shape;


      Rectangle(String Shape){
        this.Shape = Shape;
      }


      void toDraw(){
        System.out.println("The Shape is : "+ this.Shape);
      }
}


class Square extends Shape{
      public String Shape;


      Square(String Shape){
        this.Shape = Shape;
      }


      void toDraw(){
        System.out.println("The Shape is : "+ this.Shape);
      }
}


class ShapeFactory {
     
  public Shape getInstance(String type){
     switch(type){
        case "Circle" : {
             return new Circle("Circle");
        }
        case "Rectangle" : {
             return new Rectangle("Rectangle");
        }
        case "Square" : {
             return new Square("Square");
        }
        default : return new Square("Square");
       }
     }


}


public class Pract{
  public static void main(String args[]){
      ShapeFactory sf = new ShapeFactory();
      Shape s = sf.getInstance("Circle");
      s.toDraw();
      s = sf.getInstance("Rectangle");
      s.toDraw();
      s = sf.getInstance("Square");
      s.toDraw();
  }
}
