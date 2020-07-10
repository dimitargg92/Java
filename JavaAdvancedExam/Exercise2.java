import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Exercise2 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int n = Integer.parseInt(sc.nextLine());



        int row = 0;
        int col = 0;

        List<List<String>> matrix = new ArrayList<>();


        for (int i = 0; i < n; i++) {

            matrix.add(new ArrayList<>());

            String input = sc.nextLine();

            for (int j = 0; j < input.length(); j++) {

                if (input.charAt(j) == 'S') {

                    row = i;
                    col = j;
                }
                matrix.get(i).add(String.valueOf(input.charAt(j)));
            }
        }

        int foodQuantity = 0;

        boolean isGameOver = false;


        while (foodQuantity < 10){


            String command = sc.nextLine();

            switch (command){

                case "up":
                    if (checkUpMovement(row - 1)){

                       matrix.get(row).set(col,".");
                        row--;
                    }else {
                        matrix.get(row).set(col,".");
                        isGameOver = true;
                    }
                    break;
                case"down":
                    if (checkDownMovement(matrix,row + 1)){

                        matrix.get(row).set(col,".");
                        row++;
                    }else {
                        matrix.get(row).set(col,".");
                        isGameOver = true;
                    }
                    break;
                case"left":
                    if (checkLeftMovement(col - 1)){

                        matrix.get(row).set(col,".");
                        col--;
                    }else {
                        matrix.get(row).set(col,".");
                        isGameOver = true;
                    }
                    break;
                case"right":
                    if (checkRightMovement(matrix,row,col + 1)){

                        matrix.get(row).set(col,".");
                        col++;
                    }else {
                        matrix.get(row).set(col,".");
                        isGameOver = true;
                    }
                    break;
            }


            if (isGameOver){
                System.out.println("Game over!");
                System.out.println("Food eaten: " + foodQuantity);
                printMatrix(matrix);
                return;
            }

            String cell = matrix.get(row).get(col);

            switch (cell){

                case"*":
                    foodQuantity++;
                    matrix.get(row).set(col,"S");
                    break;

                case"B":
                    matrix.get(row).set(col,".");

                    int[]burrow = getBurrow(matrix);
                    int burrowRow = burrow[0];
                    int burrowCol = burrow[1];

                    matrix.get(burrowRow).set(burrowCol,"S");

                    row = burrowRow;
                    col = burrowCol;
                    break;

                default:
                    matrix.get(row).set(col,"S");
                    break;
            }
        }


        System.out.println("You won! You fed the snake.");
        System.out.println("Food eaten: " + foodQuantity);
        printMatrix(matrix);


    }
    private static void printMatrix(List<List<String>>matrix){

        for (List<String> row : matrix) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
    private static int[] getBurrow (List<List<String>>matrix){

        int[] burrow = new int[2];

        for (int i = 0; i < matrix.size(); i++) {

            for (int j = 0; j < matrix.get(i).size(); j++) {

                if (matrix.get(i).get(j).equals("B")){

                    burrow[0] = i;
                    burrow[1] = j;
                    break;
                }
            }
        }
        return burrow;
    }
    private static boolean checkUpMovement (int row){
        return row >= 0;
    }
    private static boolean checkDownMovement (List<List<String>>matrix,int row){
        return row < matrix.size();
    }
    private static boolean checkLeftMovement (int col){
        return col >= 0;
    }
    private static boolean checkRightMovement (List<List<String>>matrix,int row,int col){
        return col < matrix.get(row).size();
    }
}
