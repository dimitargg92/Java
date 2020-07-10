package milatary.entities;
import milatary.enums.Corps;
import milatary.interfaces.Commando;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private Set<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }
    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }
    public void completeMission (){
        for (Mission mission : this.missions) {
            mission.setState();
        }
    }
    @Override
    public String toString (){

        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Missions:").append(System.lineSeparator());

        if (this.missions.size() != 0){
            sb.append(this.missions.stream().map(Mission::toString)
            .collect(Collectors.joining(System.lineSeparator())));
        }
        return sb.toString();
    }
}
