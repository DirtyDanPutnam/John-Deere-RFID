import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        //Match on KEY & VALUE using any non-space between quotes
        //   "KEY": "VALUE" 
        Pattern keyStringValuepattern = 
            Pattern.compile("\s*\"(\\S+)\"\s*:\s*\"(\\S+)\"");

        //Match on KEY & VALUE using numbers only for VALUE
        //   "KEY": VALUE 
        Pattern keyNumValuepattern = 
            Pattern.compile("\s*\"(\\S+)\"\s*:\s*([\\-\\d\\.]+),*");

        try{

            File file = new File(filePath);
            Scanner scan = new Scanner(file);

            //Skip the first "{" in the file
            //Information needed starts at second bracket
            scan.nextLine();

            //Loop to read the document
            while(scan.hasNextLine()){

                String line = scan.nextLine();
                
                //Looks for "{" in the file
                if(line.contains("{")){

                    do{

                        line = scan.nextLine();
                        String key = "";
                        String value = "";

                        //Check when line is a string value pattern
                        Matcher matcher = keyStringValuepattern.matcher(line);
                        if(matcher.find()){
                            key = matcher.group(1);
                            value = matcher.group(2);
                            System.out.println("Found pair key="+key+" value="+value);
                        } 
                        else{
                            //Check when line is a number value pattern
                            matcher = keyNumValuepattern.matcher(line);
                            if(matcher.find()){
                                key = matcher.group(1);
                                value = matcher.group(2);
                                System.out.println("Found pair key="+key+" value="+value);
                            }
                            else{
                                System.out.println("No match found for line="+ line);
                            }    
                        } 

                        //Assign data to variables
                        if (key == "epc") {
                            epc = value;
                        }
                        else if(key == "logicalDevice"){
                            logicalDevice = value;
                        }
                        else if(key == "baseLogicalDevice"){
                            baseLogicalDevice = value;
                        }
                        else if(key == "antenna"){
                            antenna = Integer.parseInt(value);
                        }
                        else if(key == "rssi"){
                            rssi = Double.parseDouble(value);
                        }
                        else if(key == "timeUTC"){
                            timeUTC = Integer.parseInt(value);
                        }
                        else if(key == "coordinates"){
                            coordinates = value;
                        }
                    }
                    while(!line.contains("}"));

                    //System.out.println();

                    PingData temp = new PingData(epc, logicalDevice, baseLogicalDevice, antenna, rssi, timeUTC, coordinates);
                    //Replace "Processing" and ".method" with whatever it is
                    //temp = Processing.method(temp);
                    //DatabaseActions.InsertPing(temp);

                }
            }
        }
        catch(FileNotFoundException exc){
            System.out.println("Error: " + exc);
        }
    }
}
