package javatutorials;

/**
 * Invoking Superclass Constructor
 * If a class is inheriting the properties of another class, the subclass automatically acquires the default
 * constructor of the superclass. But if you want to call a parameterized constructor of the superclass,
 * you need to use the super keyword.
 * */

class ParentSuperKeywordForConstructor {
    int age;

    ParentSuperKeywordForConstructor(int age) {
        this.age = age;
    }

    public void getAge() {
        System.out.println("The value of the variable named age in super class is: " +age);
    }
}

public class SuperKeywordForConstructor extends ParentSuperKeywordForConstructor{
    SuperKeywordForConstructor(int age) {
        super(age);
    }

    public static void main(String[] args) {
        SuperKeywordForConstructor s = new SuperKeywordForConstructor(24);
        s.getAge();
    }
}
