package javatutorials;

/**
 * A subclass inherits all the members (fields, methods, and nested classes) from its superclass.
 * Constructors are not members, so they are not inherited by subclasses, but the constructor of
 * the superclass can be invoked from the subclass.

 * The super keyword is similar to this keyword. Following are the scenarios where the super keyword is used:
 * It is used to differentiate the members of superclass from the members of subclass, if they have same names.
 * It is used to invoke the superclass constructor from subclass.

 * Differentiating the Members
 * If a class is inheriting the properties of another class. And if the members of the superclass have the
 * names same as the subclass, to differentiate these variables we use super keyword
 * */

class ParentSuperKeyword {
    int num = 20;

    // display method of superclass
    public void display() {
        System.out.println("This is the display method of superclass");
    }
}

public class SuperKeyword extends  ParentSuperKeyword{
    int num = 10;

    // display method of sub class
    @Override
    public void display() {
        System.out.println("This is the display method of subclass");
    }

    public void myMethod() {
        // Instantiating subclass
        SuperKeyword sub = new SuperKeyword();

        // Invoking the display() method of subclass
        sub.display();

        // Invoking the display() method of superclass
        super.display();

        // printing the value of variable num of subclass
        System.out.println("value of the variable named num in sub class:"+ sub.num);

        // printing the value of variable num of superclass
        System.out.println("value of the variable named num in super class:"+ super.num);
    }

    public static void main(String[] args) {
        SuperKeyword obj = new SuperKeyword();
        obj.myMethod();
    }
}
