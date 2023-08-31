package javatutorials;

/**
 * IS-A is a way of saying: This object is a type of that object.
 *
 * The following are true:
 * Animal is the superclass of Mammal class.
 * Animal is the superclass of Reptile class.
 * Mammal and Reptile are subclasses of Animal class.
 * RelationshipIsA is the subclass of both Mammal and Animal classes.

 * Now, if we consider the IS-A relationship, we can say:
 * Mammal IS-A Animal
 * Reptile IS-A Animal
 * RelationshipIsA IS-A Mammal
 * Hence: RelationshipIsA IS-A Animal as well

 * With the use of the extends keyword, the subclasses will be able to inherit all the properties of the superclass
 * except for the private properties of the superclass.

 * We can assure that Mammal is actually an Animal with the use of the instance operator.
 * */

class Animal {
}

class Mammal extends Animal {
}

class Reptile extends Animal {
}

public class RelationshipIsA  extends Mammal{
    public static void main(String[] args) {
        Animal a = new Animal();
        Mammal m = new Mammal();
        RelationshipIsA r = new RelationshipIsA();

        System.out.println(m instanceof Animal);
        System.out.println(r instanceof Mammal);
        System.out.println(r instanceof Animal);
    }
}
