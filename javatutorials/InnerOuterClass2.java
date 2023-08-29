package javatutorials;

/**
 * Inner classes are also used to access the private members of a class. Suppose, a class is having private members
 * to access them. Write an inner class in it, return the private members from a method within the inner class
 * */

class OuterDemo2 {
    // private variable of the outer class
    private int num = 175;

    // inner class
    public class InnerDemo2 {
        public int getNum() {
            System.out.println("This is the getnum method of the inner class");
            return num;
        }
    }
}

public class InnerOuterClass2 {
    public static void main(String[] args) {
        // Instantiating the outer class
        OuterDemo2 outer = new OuterDemo2();

        // Instantiating the inner class
        OuterDemo2.InnerDemo2 inner = outer.new InnerDemo2();
        System.out.println(inner.getNum());
    }
}
