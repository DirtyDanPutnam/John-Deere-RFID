public class PingData {
    
    private String epc;
    private String logicalDevice;
    private String baseLogicalDevice;
    private int antenna;
    private double rssi;
    private int timeUTC;
    private String coordinates;
    //private String location;
    //private int lastPing;
    //private int lastTimeUTC;

    public PingData(String epc, String logicalDevice, String baseLogicalDevice, int antenna,
        double rssi, int timeUTC, String coordinates){

            this.epc = epc;
            this.logicalDevice = logicalDevice;
            this.baseLogicalDevice = baseLogicalDevice;
            this.antenna = antenna;
            this.rssi = rssi;
            this.timeUTC = timeUTC;
            this.coordinates = coordinates;
            //this.location = location;
            //this.lastPing = lastPing;
            //this.lastTimeUTC = lastTimeUTC;

    }
    
}
