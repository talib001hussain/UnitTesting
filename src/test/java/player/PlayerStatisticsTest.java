package player;

import org.junit.Assert;
import org.junit.Test;

public class PlayerStatisticsTest {

    @Test
    public void arePlayerNameSame(){
        Player p1 = new Player("Talib Hussain", 24);
        Player p2 = new Player("Talib Hussain", 25);

        Assert.assertEquals(p1, p2);
    }

    @Test
    public void checkPlayersNamesNotSame(){
        Player p1 = new Player("Talib Hussain", 24);
        Player p2 = new Player("Hamza", 23);

        Assert.assertNotEquals(p1, p2);
    }

    @Test
    public void checkYoungerPlayer(){
        Player p1 = new Player("Talib Hussain", 24);
        Player p2 = new Player("Hamza", 23);

        Assert.assertSame(p2, PlayerStatistics.getYoungerPlayer(p1, p2));
    }

    @Test
    public void checkUnderThirtyTrue(){
        Player p1 = new Player("Talib Hussain", 24);
        PlayerStatistics playerStatistics = new PlayerStatistics(p1, 10, 20);
        Assert.assertTrue(playerStatistics.underThirty());
    }

    @Test
    public void csvRecordNull(){
        Player player = new Player("Talib Hussain", 24);
        PlayerStatistics playerStatistics = new PlayerStatistics(player, 0, 0);
        Assert.assertNull(playerStatistics.createCSVRecord());
    }

    @Test
    public void csvRecordNotNull(){
        Player player = new Player("Talib Hussain", 24);
        PlayerStatistics playerStatistics = new PlayerStatistics(player, 10, 100);
        Assert.assertNotNull(playerStatistics.createCSVRecord());
    }

    @Test
    public void csvStatusRecord(){
        Player player = new Player("Talib Hussain", 24);
        PlayerStatistics playerStatistics = new PlayerStatistics(player, 10, 100);
        Double[] expectedArray = {10d, 0.1};
        Assert.assertArrayEquals(expectedArray, playerStatistics.createCSVRecord());
    }
}
