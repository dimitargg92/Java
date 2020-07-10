import java.util.*;

public class Exercise1 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int daturaBombs = 0;
        int cherryBombs = 0;
        int smokeDecoyBomb = 0;


        Map<String,Integer> bombs = new TreeMap<>(){{

            put("Datura Bombs",0);
            put("Cherry Bombs",0);
            put("Smoke Decoy Bombs",0);

        }};


        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt).forEach(bombEffects::offer);


        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt).forEach(bombCasing::push);


        boolean isPouchFull = false;


        while (!bombEffects.isEmpty() && !bombCasing.isEmpty()){

            int combinedSum = bombEffects.peekFirst() + bombCasing.peek();

            switch (combinedSum){

                case 40:
                    bombCasing.pollFirst();
                    bombEffects.pop();
                    bombs.put("Datura Bombs",bombs.get("Datura Bombs") + 1);
                    daturaBombs++;
                    break;

                case 60:
                    bombCasing.pollFirst();
                    bombEffects.pop();
                    bombs.put("Cherry Bombs",bombs.get("Cherry Bombs") + 1);
                    cherryBombs++;
                    break;

                case 120:
                    bombCasing.pollFirst();
                    bombEffects.pop();
                    bombs.put("Smoke Decoy Bombs",bombs.get("Smoke Decoy Bombs") + 1);
                    smokeDecoyBomb++;
                    break;

                default:

                    bombCasing.push(bombCasing.pop() - 5);
                    break;
            }

            if (daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBomb >= 3){
                isPouchFull = true;
                break;
            }
        }

        if (isPouchFull){

            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {

            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        System.out.print("Bomb Effects: ");

        if (bombEffects.isEmpty()){

            System.out.println("empty");
        }else {

            System.out.println(bombEffects.toString().replaceAll("[\\[\\]]",""));
        }

        System.out.print("Bomb Casings: ");

        if (bombCasing.isEmpty()){

            System.out.println("empty");
        }else {

            System.out.println(bombCasing.toString().replaceAll("[\\[\\]]",""));
        }

        bombs.forEach((bomb,value)-> System.out.printf("%s: %d%n",bomb,value));
        
    }
}
