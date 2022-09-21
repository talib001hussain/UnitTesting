package player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerStatisticsTest {

    Player player;
    PlayerStatistics playerStatistics;
    @Before
    public void setup(){
        player = new Player("Talib Hussain", 24);
        playerStatistics = new PlayerStatistics(player, 10, 100);
    }


    @Test
    public void arePlayerNameSame(){
        Player p2 = new Player("Talib Hussain", 25);

        Assert.assertEquals(player, p2);
    }

    @Test
    public void checkPlayersNamesNotSame(){
        Player p2 = new Player("Hamza", 23);

        Assert.assertNotEquals(player, p2);
    }

    @Test
    public void checkYoungerPlayer(){
        Player p2 = new Player("Hamza", 23);

        Assert.assertSame(p2, PlayerStatistics.getYoungerPlayer(player, p2));
    }

    @Test
    public void checkUnderThirtyTrue(){
        Assert.assertTrue(playerStatistics.underThirty());
    }

    @Test
    public void csvRecordNull(){
        playerStatistics = new PlayerStatistics(player, 0, 0);
        Assert.assertNull(playerStatistics.createCSVRecord());
    }

    @Test
    public void csvRecordNotNull(){
        Assert.assertNotNull(playerStatistics.createCSVRecord());
    }

    @Test
    public void csvStatusRecord(){
        Double[] expectedArray = {10d, 0.1};
        Assert.assertArrayEquals(expectedArray, playerStatistics.createCSVRecord());
    }
}
