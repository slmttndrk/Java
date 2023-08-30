package javatutorials;

/**
 * The StringBuffer and StringBuilder classes are used when there is a necessity to make a lot of modifications
 * to Strings of characters.

 * Unlike Strings, objects of type StringBuffer and String builder can be modified over and over again without
 * leaving behind a lot of new unused objects.

 * The StringBuilder class was introduced as of Java 5 and the main difference between the StringBuffer and
 * StringBuilder is that StringBuilders methods are not thread safe (not synchronised).

 * It is recommended to use StringBuilder whenever possible because it is faster than StringBuffer. However, if
 * the thread safety is necessary, the best option is StringBuffer objects.
 * */

public class BuilderString {
    public static void main(String[] args){
        StringBuilder sb=new StringBuilder("Hello ");
        sb.append("Java");//now original string is changed
        System.out.println(sb);//prints Hello Java
    }
}
