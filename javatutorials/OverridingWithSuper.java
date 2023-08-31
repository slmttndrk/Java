package javatutorials;

class Animall {
    public void move() {
        System.out.println("Animals can move");
    }
}

class Dogg extends Animall {
    @Override
    public void move() {
        super.move();   // invokes the super class method
        System.out.println("Dogs can walk and run");
    }
}

public class OverridingWithSuper {
    public static void main(String[] args) {
        Animall b = new Dogg();   // Animal reference but Dog object
        b.move();   // runs the method in Dog class
    }
}
