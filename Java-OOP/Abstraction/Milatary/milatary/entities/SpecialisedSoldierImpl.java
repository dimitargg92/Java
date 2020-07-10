package milatary.entities;
import milatary.enums.Corps;
import milatary.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {


    private Corps corps;

    protected SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary,Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String getCorps (){
        return this.corps.toString();
    }

    @Override
    public String toString (){

        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append(String.format("\nCorps: %s",getCorps())).append(System.lineSeparator());

        return sb.toString();
    }
}
