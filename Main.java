import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new StartingPoint().start();

        
        String filePath = "C:\\Users\\colin\\OneDrive\\Documents\\CSCI 455 Project\\TestDataOne.json";
        
        DataReader r = new DataReader();
        r.ReadFile(filePath);

    }

}
