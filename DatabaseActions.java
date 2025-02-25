import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseActions {

    public static int InsertPing(PingData pd) throws SQLException {
        String query = "INSERT INTO Ping_Data (epc, logical_device, base_logical_device, rssi, timeUTC, latitude, longitude, antenna_num) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = DatabaseManager.getConnection().prepareStatement(query);

        pstmt.setString(1, pd.epc);
        pstmt.setString(2, pd.logicalDevice);
        pstmt.setString(3, pd.baseLogicalDevice);
        pstmt.setString(4, pd.rssi);
        pstmt.setString(5, pd.timeUTC);
        pstmt.setString(6, pd.latitude);
        pstmt.setInt(7, pd.longitude);
        pstmt.setBoolean(8, pd.antenna);
        
        int count = pstmt.executeUpdate();

        return count;
    }

}
