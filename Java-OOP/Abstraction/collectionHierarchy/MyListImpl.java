package Abstraction.collectionHierarchy;
import Abstraction.Interfaces.MyList;

public class MyListImpl extends Collection implements MyList {


    MyListImpl(){

    }
    @Override
    public int getUsed() {
        return this.items.size();
    }

    @Override
    public String remove() {
        return this.items.remove(0);
    }
    @Override
    public int add(String input) {
        this.items.add(0,input);
        return 0;
    }
}
