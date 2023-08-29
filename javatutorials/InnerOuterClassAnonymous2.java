package javatutorials;

/**
 * Generally, if a method accepts an object of an interface, an abstract class, or a concrete class, then we can
 * implement the interface, extend the abstract class, and pass the object to the method. If it is a class, then
 * we can directly pass it to the method.

 * But in all the three cases, you can pass an anonymous inner class to the method.
 * */

// interface
interface Message {
    String greet();
}

public class InnerOuterClassAnonymous2 {
    // method which accepts the object of interface Message
    public void displayMessage(Message m) {
        System.out.println(m.greet() +
                ", This is an example of anonymous inner class as an argument");
    }

    public static void main(String[] args) {
        // Instantiating the class
        InnerOuterClassAnonymous2 obj = new InnerOuterClassAnonymous2();

        // Passing an anonymous inner class as an argument
        obj.displayMessage(new Message() {
            public String greet() {
                return "Hello";
            }
        });
    }
}
