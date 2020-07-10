package Abstraction.collectionHierarchy;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        String[] tokens = sc.nextLine().split("\\s+");
        int removeOperations = Integer.parseInt(sc.nextLine());

        if (removeOperations > 100){
            return;
        }

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();


        int[][] addedItems = new int[3][tokens.length];

        for (int i = 0; i < tokens.length; i++) {

            addedItems[0][i] = addCollection.add(tokens[i]);
            addedItems[1][i] = addRemoveCollection.add(tokens[i]);
            addedItems[2][i] = myList.add(tokens[i]);
        }

        String[][] removedItems = new String[2][removeOperations];

        for (int i = 0; i < removeOperations; i++) {

            removedItems[0][i] = addRemoveCollection.remove();
            removedItems[1][i] = myList.remove();
        }


        printAddedItems(addedItems);
        printRemovedItems(removedItems);
    }
    private static void printAddedItems (int[][]addedItems){

        for (int[] row : addedItems) {
            for (int item : row) {

                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
    private static void printRemovedItems (String[][]removedItems){

        for (String[] row : removedItems) {
            for (String item : row) {

                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
