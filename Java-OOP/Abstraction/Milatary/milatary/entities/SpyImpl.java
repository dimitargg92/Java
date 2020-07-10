package milatary.entities;
import milatary.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {

    private Integer codeNumber;

    public SpyImpl(int id, String firstName, String lastName,Integer codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public Integer getCodeNumber (){
        return this.codeNumber;
    }

    @Override
    public String toString (){
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(String.format("Code Number: %d",this.getCodeNumber()));

        return sb.toString();
    }
}
