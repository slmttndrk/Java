package javatutorials;

/**
 * A generic class declaration looks like a non-generic class declaration, except that the class name is followed
   by a type parameter section.

 * As with generic methods, the type parameter section of a generic class can have one or more type parameters
   separated by commas. These classes are known as parameterized classes or parameterized types because they accept
   one or more parameters.
 * */

public class GenericClasses<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        GenericClasses<Integer> integerBox = new GenericClasses<Integer>();
        GenericClasses<String> stringBox = new GenericClasses<String>();

        integerBox.add(10);
        stringBox.add("Hello World");

        System.out.printf("Integer Value :%d\n\n", integerBox.get());
        System.out.printf("String Value :%s\n", stringBox.get());
    }
}
