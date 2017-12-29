package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    Properties prop;

    public PropertiesLoader(){
        // Properties file path.
        String filePath = "config.properties";
        prop = new Properties();
        try(InputStream inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(filePath)) {
            prop.load(inputStream);
        }
        catch(IOException ex){
            System.out.println("Problem occurs when reading file !");
            ex.printStackTrace();
        }
    }

    public String get(String name){
        return prop.getProperty(name);
    }

}
