package javatutorials;

import java.io.File;

// Java automatically takes care of path separators on UNIX and Windows as per conventions. If
// you use a forward slash (/) on a Windows version of Java, the path will still resolve correctly.

public class CreateDirectory {
    public static void main(String args[]) {
        String dirname = "/tmp/user/java/bin";
        File d = new File(dirname);

        // Create directory now.
        d.mkdirs();
    }
}
