package javatutorials;

/**
 * The qualified class name and pathname would be as follows:
 * Class name → javatutorials.DirectoryStructureOfPackages
 * Path name → javatutorials\DirectoryStructureOfPackages.java (in windows)
 *
 * In general, a company uses its reversed Internet domain name for its package names.
 * Example − A company's Internet domain name is apple.com, then all its package names would start with com.apple.
   Each component of the package name corresponds to a subdirectory.

 * Example − The company had a com.apple.computers package that contained a Dell.java source file, it would be
   contained in a series of subdirectories like this:
   ....\com\apple\computers\Dell.java

 * At the time of compilation, the compiler creates a different output file for each class, interface and enumeration
   defined in it. The base name of the output file is the name of the type, and its extension is .class.
 * Compile this file as follows using -d option −> $javac -d . Dell.java

 * The files will be compiled as follows:
   .\javatutorials\DirectoryStructureOfPackages.class
   .\javatutorials\DSP.class

 * Like the .java source files, the compiled .class files should be in a series of directories that reflect
   the package name. However, the path to the .class files does not have to be the same as the path to the .java
   source files.
 * You can arrange your source and class directories separately, as:
   <path-one>\sources\javatutorials\DirectoryStructureOfPackages.java
   <path-two>\classes\\javatutorials\DirectoryStructureOfPackages.class

 * By doing this, it is possible to give access to the classes directory to other programmers without revealing
   your sources. You also need to manage source and class files in this manner so that the compiler and the Java
   Virtual Machine (JVM) can find all the types your program uses.

 * The full path to the classes directory, <path-two>\classes, is called the class path, and is set with the CLASSPATH
   system variable. Both the compiler and the JVM construct the path to your .class files by adding the package
   name to the class path.

 * Say <path-two>\classes is the class path, and the package name is javatutorials, then the compiler and JVM will
   look for .class files in <path-two>\classes\javatutorials

 * A class path may include several paths. Multiple paths should be separated by a semicolon (Windows) or colon (Unix).
 * By default, the compiler and the JVM search the current directory and the JAR file containing the Java platform
   classes so that these directories are automatically in the class path.

 * Set CLASSPATH System Variable
 * To display the current CLASSPATH variable, use the following commands in Windows and UNIX (Bourne shell):
 * In Windows → C:\> set CLASSPATH
 * In UNIX → % echo $CLASSPATH

 * To delete the current contents of the CLASSPATH variable, use:
 * In Windows → C:\> set CLASSPATH =
 * In UNIX → % unset CLASSPATH; export CLASSPATH

 * To set the CLASSPATH variable:
 * In Windows → set CLASSPATH = C:\ users\ jack\ java\ classes
 * In UNIX → % CLASSPATH = /home/jack/java/classes; export CLASSPATH

 * */

public class DirectoryStructureOfPackages {
}

class DSP {}
