package javatutorials;

interface Animals{}

class Mammals implements Animals{}

public class KeywordInstanceOf extends Mammals{
    public static void main(String[] args) {
        Mammals m = new Mammals();
        KeywordInstanceOf k = new KeywordInstanceOf();

        System.out.println(m instanceof Animals);
        System.out.println(k instanceof Mammals);
        System.out.println(k instanceof Animals);
    }
}
