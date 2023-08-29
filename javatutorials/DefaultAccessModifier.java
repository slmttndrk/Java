package javatutorials;

/**
 * Default access modifier means we do not explicitly declare an access modifier for a class, field, method, etc.

 * A variable or method declared without any access control modifier is available to any other class in the same
 * package. The fields in an interface are implicitly public static final and the methods in an interface are
 * by default public.
 * */

class DefaultAccessModifier {
    boolean processOrder() {
        return true;
    }

    public static void main(String[] args) {
        String version = "1.5.1";
        System.out.println(version);
    }
}
