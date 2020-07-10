package Encapsulation.FootballTeamGenerator;

public class Player {

    private final String INVALID_STATS_MESSAGE = "should be between 0 and 100.";

    private String name;

    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;


    public Player (String name,int end,int spr,int drb,int pass,int sht){

        setName(name); setEndurance(end); setSprint(spr);
        setDribble(drb);setPassing(pass); setShooting(sht);
    }

    private void setName (String name){
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
    private void setEndurance (int endurance){
        if (endurance < 0 || endurance > 100){
            throw new IllegalArgumentException("Endurance " + INVALID_STATS_MESSAGE);
        }
        this.endurance = endurance;
    }
    private void setSprint (int sprint){
        if (sprint < 0 || sprint > 100){
            throw new IllegalArgumentException("Sprint " + INVALID_STATS_MESSAGE);
        }
        this.sprint = sprint;
    }
    private void setDribble (int dribble){
        if (dribble < 0 || dribble > 100){
            throw new IllegalArgumentException("Dribble " + INVALID_STATS_MESSAGE);
        }
        this.dribble = dribble;
    }
    private void setPassing (int passing){
        if (passing < 0 || passing > 100){
            throw new IllegalArgumentException("Passing " + INVALID_STATS_MESSAGE);
        }
        this.passing = passing;
    }
    private void setShooting (int shooting){
        if (shooting < 0 || shooting > 100){
            throw new IllegalArgumentException("Shooting " + INVALID_STATS_MESSAGE);
        }
        this.shooting = shooting;
    }
    public String getName (){
        return name;
    }
    public double getOverAllSkillLever (){

        return Math.round((this.endurance
                + this.sprint
                + this.dribble
                + this.passing
                + this.shooting) / 5.0);
    }
}
