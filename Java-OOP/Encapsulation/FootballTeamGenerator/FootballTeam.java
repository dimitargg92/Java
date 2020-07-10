package Encapsulation.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class FootballTeam {

    private String name;
    private List<Player> players;

    public FootballTeam (String name){

        setName(name);
        this.players = new ArrayList<>();

    }
    private void setName (String name){
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
    public String getName (){
        return name;
    }
    public void addPlayer (Player player){

        this.players.add(player);
    }
    public void removePlayer (String player){

        boolean itExist = false;
        int index = 0;

        for (int i = 0; i < players.size(); i++) {

            if (players.get(i).getName().equals(player)){
                itExist = true;
                index = i;
                break;
            }
        }
        if (itExist){
            this.players.remove(index);

        }else {
            throw new IllegalArgumentException
                    ("Player " + player + " is not in " + this.name + " team.");
        }
    }
    public double getRating (){

        double rating = this.players
                .stream()
                .mapToDouble(Player::getOverAllSkillLever)
                .sum();

        return Math.ceil((int)(rating / this.players.size()));
    }
}
