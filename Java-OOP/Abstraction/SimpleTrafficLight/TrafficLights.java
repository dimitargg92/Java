package enums;
public class TrafficLights {

    Lights color;

    public void change(){

        switch (color){

            case RED: color = Lights.GREEN;
            break;

            case YELLOW: color = Lights.RED;
            break;

            case GREEN: color = Lights.YELLOW;
            break;
        }
    }
}
