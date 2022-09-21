package player;

public class PlayerStatistics {
    private Player player;
    private int games;
    private int goals;

    public PlayerStatistics(Player player, int games, int goals) {
        this.player = player;
        this.games = games;
        this.goals = goals;
    }

    public double getGoalsPerGame(){
        return (double)this.goals / (double) this.games;
    }

    public double getGamesPerGoal(){
        return (double) this.games / (double) this.goals;
    }

    public boolean underThirty(){
        return player.getAge() < 30;
    }

    public Double[] createCSVRecord(){
        if (this.games == 0)
            return null;
        else {
            return new Double[]{getGoalsPerGame(), getGamesPerGoal()};
        }
    }

    public static Player getYoungerPlayer (Player p1, Player p2){
        return p1.getAge() < p2.getAge() ? p1 : p2;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
