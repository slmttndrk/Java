package javatutorials;

/**
 * HAS-A relationship
 * These relationships are mainly based on the usage. This determines whether a certain class HAS-A certain thing.
 * This relationship helps to reduce duplication of code as well as bugs.

 * Class RelationshipHasA HAS-A Speed. By having a separate class for Speed, we do not have to put the entire code that
 * belongs to speed inside the RelationshipHasA class, which makes it possible to reuse the Speed class in multiple
 * applications.

 * In Object-Oriented feature, the users do not need to bother about which object is doing the real work. To achieve
 * this, the RelationshipHasA class hides the implementation details from the users of the RelationshipHasA class.
 * So, basically what happens is the users would ask the RelationshipHasA class to do a certain action and
 * the RelationshipHasA class will either do the work by itself or ask another class to perform the action.

 * A very important fact to remember is that Java does not support multiple inheritance. This means that a class
 * cannot extend more than one class. However, a class can implement one or more interfaces, which has helped Java
 * get rid of the impossibility of multiple inheritance.
 * */

class Vehicles{}
class Speed{}

public class RelationshipHasA extends Vehicles {
    private Speed sp;
}
