import java.util.*;
import java.io.*;

public class IOTest {
    public static void main(String[] args) throws IOException
    {
        String str = "This is a comma separated test string, \n 2017,Honda,Civic \n 2015,Mazda,Mazda3\n";
        String location = ".\\filetest.txt";
        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream(location);
            fs.write(str.getBytes());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            fs.close();
        }

    }
}
