package milatary.entities;
import milatary.interfaces.Private;

public class PrivateImpl extends SoldierImpl implements Private {

    private double salary;

    public PrivateImpl(int id, String firstName, String lastName,double salary) {
        super(id, firstName, lastName);
        setSalary(salary);
    }
    private void setSalary (double salary){
        if (salary > 0){
            this.salary = salary;
        }
    }
    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString (){

        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(String.format("Salary: %.2f",getSalary()));

        return sb.toString();
    }
}
