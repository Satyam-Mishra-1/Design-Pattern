//     Abstract Factory Code


interface PenFactory {
    public Tube createTube();
    public Refill createRefill();
}


class SketchPenFactory implements PenFactory {
    public Tube createTube(){
        return new Fiber();
    }


    public Refill createRefill(){
        return new Sponge();
    }
}


class GelPenFactory implements PenFactory {
    public Tube createTube(){
        return new Metal();
    }


    public Refill createRefill(){
        return new Plastic();
    }
}


interface Tube {
    public void getMaterial();
}


interface Refill {
   public void getMaterial();
}


class Fiber implements Tube{
   public void getMaterial(){
        System.out.println("This is Fiber Tube ");
    }
}


class Metal implements Tube{
   public void getMaterial(){
        System.out.println("This is Metal Tube ");
    }
}


class Sponge implements Refill{
   public void getMaterial(){
        System.out.println("This is Sponge Refill ");
    }
}


class Plastic implements Refill{
    public void getMaterial(){
        System.out.println("This is Plastic Refill ");
    }
}


public class Pract{
    private Tube tube;
    private Refill refill;


    public Pract(PenFactory factory){
        tube = factory.createTube();
        refill = factory.createRefill();
    }


    public void display(){
        tube.getMaterial();
        refill.getMaterial();
    }


    public static void main(String args[]){
       PenFactory S1 = new SketchPenFactory();
       Pract p1 = new Pract(S1);
       p1.display();
       




       PenFactory S2 = new GelPenFactory();
       Pract p2 = new Pract(S2);
       p2.display();  
    }
}

