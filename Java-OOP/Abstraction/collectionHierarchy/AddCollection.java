package Abstraction.collectionHierarchy;
import Abstraction.Interfaces.Addable;

public class AddCollection extends Collection implements Addable {

    public AddCollection (){

    }

    @Override
    public int add(String input) {
        this.items.add(input);
        return this.items.indexOf(input);
    }

}
