package javatutorials;

import java.io.IOException;
import java.net.URL;

/**
 * URL stands for Uniform Resource Locator and represents a resource on the World Wide Web, such as a Web page or FTP
   directory.

 * A URL can be broken down into parts, as follows:
   protocol://host:port/path?query#ref

 *  Examples of protocols include HTTP, HTTPS, FTP, and File. The path is also referred to as the filename, and
    the host is also called the authority.

 * The following is a URL to a web page whose protocol is HTTP:
   http://www.amrood.com/index.htm?language=en#j2se

 * Notice that this URL does not specify a port, in which case the default port for the protocol is used.
 * With HTTP, the default port is 80.

 * The java.net.URL class represents a URL and has a complete set of methods to manipulate URL in Java.
 * The URL class contains many methods for accessing the various parts of the URL being represented.
 * */

public class NetworkingUrlProcessing {
    public static void main(String [] args) {
        try {
            URL url = new URL("https://www.amrood.com/index.htm?language=en#j2se");

            System.out.println("URL is " + url.toString());
            System.out.println("protocol is " + url.getProtocol());
            System.out.println("authority is " + url.getAuthority());
            System.out.println("file name is " + url.getFile());
            System.out.println("host is " + url.getHost());
            System.out.println("path is " + url.getPath());
            System.out.println("port is " + url.getPort());
            System.out.println("default port is " + url.getDefaultPort());
            System.out.println("query is " + url.getQuery());
            System.out.println("ref is " + url.getRef());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
