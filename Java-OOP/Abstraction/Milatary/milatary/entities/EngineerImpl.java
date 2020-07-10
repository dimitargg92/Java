package milatary.entities;
import milatary.enums.Corps;
import milatary.interfaces.Engineer;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private Set<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {

        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }
    @Override
    public String toString (){
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Repairs:").append(System.lineSeparator());

        if (this.repairs.size() != 0){
            sb.append(this.repairs.stream().map(Repair::toString)
            .collect(Collectors.joining(System.lineSeparator())));
        }
        return sb.toString();
    }
}
