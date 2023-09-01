package javatutorials;

/**
 * Encapsulation is one of the four fundamental OOP concepts. The other three are inheritance, polymorphism, and
 * abstraction.

 * Encapsulation in Java is a mechanism of wrapping the data (variables) and code acting on the data (methods)
 * together as a single unit. In encapsulation, the variables of a class will be hidden from other classes, and
 * can be accessed only through the methods of their current class. Therefore, it is also known as data hiding.

 * To achieve encapsulation in Java:
 * Declare the variables of a class as private.
 * Provide public setter and getter methods to modify and view the variables values.

 * Normally, these methods are referred as getters and setters. Therefore, any class that wants to access the
 * variables should access them through these getters and setters.

 * Benefits of Encapsulation
 * The fields of a class can be made read-only or write-only.
 * A class can have total control over what is stored in its fields.
 * */

public class EncapsulationSample {
    private String name;
    private String idNum;
    private int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setAge( int newAge) {
        age = newAge;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setIdNum( String newId) {
        idNum = newId;
    }

    public static void main(String[] args) {
        EncapsulationSample enc = new EncapsulationSample();
        enc.setName("James");
        enc.setAge(20);
        enc.setIdNum("12343ms");

        System.out.print("Name : " + enc.getName() + " Age : " + enc.getAge());
    }
}
