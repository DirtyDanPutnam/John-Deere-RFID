import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseActions {

    public static int InsertPing(PingData pd) throws SQLException {
        String query = "INSERT INTO Ping_Data (epc, logical_device, base_logical_device, rssi, timeUTC, latitude, longitude, antenna_num) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = DatabaseManager.getConnection().prepareStatement(query);

        pstmt.setString(1, pd.epc);
        pstmt.setString(2, pd.logicalDevice);
        pstmt.setString(3, pd.baseLogicalDevice);
        pstmt.setDouble(4, pd.rssi);
        pstmt.setInt(5, pd.timeUTC);
        pstmt.setDouble(6, pd.latitude);
        pstmt.setDouble(7, pd.longitude);
        pstmt.setInt(8, pd.antenna);
        
        int count = pstmt.executeUpdate();

        return count;
    }

    public static int PullLastPingNum(PingData pd){
        String query = "SELECT antenna_num FROM ping_data WHERE ping_id IN (SELECT antenna_last_ping FROM tool WHERE epc = ?)";

        PreparedStatement pstmt = DatabaseManager.getConnection().prepareStatement(query);

        pstmt.setString(1, pd.epc);

        ResultSet rs = pstmt.executeQuery();

        int pingNum = rs.getInt("antenna_num");

        return pingNum;
    }

    public static int PullLastPingUTC(PingData pd){
        String query = "SELECT timeutc FROM ping_data WHERE ping_id IN (SELECT antenna_last_ping FROM tool WHERE epc = ?)";

        PreparedStatement pstmt = DatabaseManager.getConnection().prepareStatement(query);

        pstmt.setString(1, pd.epc);

        ResultSet rs = pstmt.executeQuery();

        int pingUTC = rs.getInt("antenna_num");

        return pingUTC;
    }

    //Insert tool?
}
