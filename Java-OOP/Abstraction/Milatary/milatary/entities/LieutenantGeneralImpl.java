package milatary.entities;
import milatary.interfaces.LieutenantGeneral;
import java.util.Set;
import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {


    private Set<PrivateImpl> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<>((first,second)-> second.getId() - first.getId());
    }

    @Override
    public void addPrivate(PrivateImpl prv) {
        this.privates.add(prv);
    }
    @Override
    public String toString (){

        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("\nPrivates:").append(System.lineSeparator());

        for (PrivateImpl prv : this.privates) {
            sb.append("  ").append(prv.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
