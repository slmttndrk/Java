package javatutorials;

/**
 * Variables, methods, and constructors, which are declared protected in a superclass can be accessed only by
 * the subclasses in other package or any class within the package of the protected members' class.

 * The protected access modifier cannot be applied to class and interfaces. Methods, fields can be declared
 * protected, however methods and fields in a interface cannot be declared protected.

 * Protected access gives the subclass a chance to use the helper method or variable, while preventing a non-related
 * class from trying to use it.


 * Here, if we define openSpeaker() method as private, then it would not be accessible from any other class
 * other than AudioPlayer. If we define it as public, then it would become accessible to all the outside world.
 * But our intention is to expose this method to its subclass only, that’s why we have used protected modifier.
 * */

class AudioPlayer {
    protected void openSpeaker(String s) {
        // implementation details
    }
}

class ProtectedAccessModifier extends AudioPlayer {
    @Override
    protected void openSpeaker(String s) {
        // implementation details
    }
}
