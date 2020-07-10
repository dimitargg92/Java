package milatary.entities;
import milatary.enums.MissionState;

public class Mission {

    private String codeName;
    private MissionState state;

    public Mission (String codeName,MissionState state){
        this.codeName = codeName;
        this.state = MissionState.valueOf(state.toString());
    }
    public void setState (){
        this.state = MissionState.finished;
    }
    public MissionState getState(){
        return this.state;
    }

    @Override
    public boolean equals (Object object){

        if (object == null || object.getClass() != this.getClass()){
            return false;
        }
        Mission mission = (Mission) object;
        return mission.codeName.equals(this.codeName) &&
                mission.getState().toString().equals(this.getState().toString());
    }
    public int hashCode (){
        return this.codeName.hashCode() * 17 + this.state.toString().hashCode();
    }

    @Override
    public String toString (){
        return String.format("  Code Name: %s State: %s\n",
                this.codeName,this.getState());
    }
}
