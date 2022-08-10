package programming.generics;

public class Main {
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);

//        adelaideCrows.addPlayer(pat);
//        adelaideCrows.addPlayer(beckham);

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
        baseballTeam.addPlayer(pat);

        Team<SoccerPlayer> brokenTeam = new Team<>("this won't work");
        brokenTeam.addPlayer(beckham);

        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);

        Team<FootballPlayer> hawthorn= new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle= new Team<>("Fremantle");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle, 2, 1);

        System.out.println("Ranking:");
        System.out.println(hawthorn.getName() + ": " + hawthorn.ranking());
        System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());
        System.out.println(fremantle.getName() + ": " + fremantle.ranking());

//        List<Team> teams = new ArrayList<>();
//        teams.add(hawthorn);
//        teams.add(adelaideCrows);
//        teams.add(fremantle);
//
//        teams.sort((t1, t2) -> {
//           return t2.ranking() - t1.ranking();
//        });
//
//        teams.forEach(t -> System.out.println(t.getName()));

        League<Team<FootballPlayer>> teamLeague = new League<>("Apex League");
        teamLeague.addTeam(hawthorn);
        teamLeague.addTeam(adelaideCrows);
        teamLeague.addTeam(fremantle);

        teamLeague.showLeagueTable();
    }
}
