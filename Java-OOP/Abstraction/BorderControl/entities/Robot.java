package Abstraction.border;

public class Robot implements Identifiable {

    private String id;
    private String model;

    public Robot (String model,String id){
        setId(id);
        setModel(model);
    }
    private void setId (String id){
        this.id = id;
    }
    private void setModel (String model){
        this.model = model;
    }
    public String getModel (){
        return model;
    }
    @Override
    public String getId()
    {
        return id;
    }
}
