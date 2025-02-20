
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/*
 * Class to read the MQTT file and store the data into variables
 */
public class DataReader {


    //Variables
    private String epc;
    private String logicalDevice;
    private String baseLogicalDevice;
    private int antenna;
    private double rssi;
    private int timeUTC;
    private String coordinates; 

    private String filePath = "C:\\Users\\colin\\OneDrive\\Documents\\CSCI 455 Project\\TestDataOne.json";

    
    public void ReadFile(String filePath){

        try{
    
            File file = new File(filePath);
            Scanner scan = new Scanner(file);
    
            while(scan.hasNextLine()){
                String data = scan.nextLine();
                System.out.println(data);






                
            }
        }
        catch(FileNotFoundException exc){
            System.out.println("Exception: " + exc);
        }

    }

}
