import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesRead {
    public static void main(String[] args) throws Exception {
        System.getProperties().list(System.out);
    }
}