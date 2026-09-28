// Have a lower level (sub) class that represent a specific sport (FootballStats, CricketStats, CyclingStats etc…). Tailor the services of the classes to the sport in question, with common attributes and methods in the higher-level class, as appropriate. Create a driver class to instantiate and text instances of the classes.

class Stats {

    private String playerName;
    private String teamName;
    private int gamesPlayed;

     public Stats(String playerName, String teamName, int gamesPlayed) {
        this.playerName = playerName;
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
    }

     public String getPlayerName() {
        return playerName;
    }

     public String getTeamName() {
        return teamName;
    }

     public int getGamesPlayed() {
        return gamesPlayed;
    }
}

class FootballStats extends Stats {
    private int goalsScored;

    public FootballStats(String playerName, String teamName, int gamesPlayed, int goalsScored) {
        super(playerName, teamName, gamesPlayed);
        this.goalsScored = goalsScored;
    }

    public int getGoalsScored() {
        return goalsScored;
    }
}

class CricketStats extends Stats {
    private int runsScored;

    public CricketStats(String playerName, String teamName, int gamesPlayed, int runsScored) {
        super(playerName, teamName, gamesPlayed);
        this.runsScored = runsScored;
    }

    public int getRunsScored() {
        return runsScored;
    }
}

class CyclingStats extends Stats {
    private int racesWon;

    public CyclingStats(String playerName, String teamName, int gamesPlayed, int racesWon) {
        super(playerName, teamName, gamesPlayed);
        this.racesWon = racesWon;
    }

    public int getRacesWon() {
        return racesWon;
    }
}


public class PlayerStats {

    public static void main(String[] args) {
        FootballStats fPlayerStats = new FootballStats("Lionel Messi", "Paris Saint-Germain", 778, 672);
        CricketStats cPlayerStats = new CricketStats("Virat Kohli", "India", 254, 12040);
        CyclingStats cyPlayerStats = new CyclingStats("Eddy Merckx", "Belgium", 500, 525);

        System.out.println(fPlayerStats.getPlayerName() + " is apart of " + fPlayerStats.getTeamName() + " and has played " + fPlayerStats.getGamesPlayed() + " games and scored " + fPlayerStats.getGoalsScored() + " goals.");
        System.out.println(cPlayerStats.getPlayerName() + " is apart of " + cPlayerStats.getTeamName() + " and has played " + cPlayerStats.getGamesPlayed() + " games and scored " + cPlayerStats.getRunsScored() + " runs.");
        System.out.println(cyPlayerStats.getPlayerName() + " is apart of " + cyPlayerStats.getTeamName() + " and has played " + cyPlayerStats.getGamesPlayed() + " games and won " + cyPlayerStats.getRacesWon() + " races.");
    }
}

