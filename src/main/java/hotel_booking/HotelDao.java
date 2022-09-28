package hotel_booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDao {
    public List<String> fetchAvailableRooms() throws SQLException {
        List<String> availableRooms = new ArrayList<>();
        Connection connection = DriverManager.getConnection("DATABASE_URL");
        ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery("SELECT * FROM ROOMS WHERE AVAILABLE like '1'");
        }

        while (resultSet.next()) {
            availableRooms.add(resultSet.getString("Room Name"));
        }
        return availableRooms;
    }
}
