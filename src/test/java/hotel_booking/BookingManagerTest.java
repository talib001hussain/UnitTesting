package hotel_booking;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class BookingManagerTest {
    private BookingManager bookingManager;

    @Before
    public void setup() throws SQLException {
        HotelDao mockedHotelDao = mock(HotelDao.class);
        bookingManager = new BookingManager(mockedHotelDao);

        List<String> availableRooms = Arrays.asList("Room 1", "Room 2");
        when(mockedHotelDao.fetchAvailableRooms())
                .thenReturn(availableRooms);
    }

    @Test
    public void checkAvailableRoomsTrue() throws SQLException {
        Assert.assertTrue(bookingManager.checkRoomAvailability("Room 1"));
    }

    @Test
    public void checkAvailableRoomsFalse() throws SQLException {
        Assert.assertFalse(bookingManager.checkRoomAvailability("Room 3"));
    }
}
