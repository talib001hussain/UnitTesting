package hotel_booking;

import java.sql.SQLException;
import java.util.List;

public class BookingManager {
    private HotelDao hotelDao;

    public BookingManager(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    public boolean checkRoomAvailability(String roomName) throws SQLException {
        List<String> roomsAvailable = hotelDao.fetchAvailableRooms();
        return roomsAvailable.contains(roomName);
    }
}
