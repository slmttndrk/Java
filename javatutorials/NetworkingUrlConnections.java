package javatutorials;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * URLConnections Class Methods
 * The openConnection() method returns a java.net.URLConnection, an abstract class whose subclasses represent the
   various types of URL connections.
 * If you connect to a URL whose protocol is HTTP, the openConnection() method returns an HttpURLConnection object.
 * If you connect to a URL that represents a JAR file, the openConnection() method returns a JarURLConnection object.

 * The URLConnection class has many methods for setting or determining information about the connection.

 * The following URLConnectionDemo program connects to a URL entered from the command line. If the URL represents an
   HTTP resource, the connection is cast to HttpURLConnection, and the data in the resource is read one line at a time.
 * */

public class NetworkingUrlConnections {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.amrood.com");
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if(urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
            }else {
                System.out.println("Please enter an HTTP URL.");
                return;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String urlString = "";
            String current;

            while((current = in.readLine()) != null) {
                urlString += current;
            }
            System.out.println(urlString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
