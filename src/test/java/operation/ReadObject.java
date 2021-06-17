package operation;

import java.io.*;
import java.util.Properties;

public class ReadObject {

    Properties properties = new Properties();

    public Properties getObjectRepository() throws IOException {
        InputStream stream = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\java\\objects\\object.properties"));
        //load all objects
        properties.load(stream);
        return properties;
    }
}
