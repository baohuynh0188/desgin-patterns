package programming.generics;

import java.util.ArrayList;
import java.util.List;

public class League<T extends Team> {
    private String name;

    private List<T> teams = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTeam(T team) {
        if (this.teams.contains(team)) {
            System.out.println(team.getName() + " is already on the league " + this.getName());
        } else {
            this.teams.add(team);
            System.out.println(team.getName() + " has been added for league " + this.getName());
        }
    }

    public void showLeagueTable() {
        this.teams.sort((t1, t2) -> t2.ranking() - t1.ranking());
        this.teams.forEach(t -> System.out.println(t.getName()));
    }
}
