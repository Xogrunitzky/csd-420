/*
    Xavier Grunitzky
    Module Assignment 3.2
    4/12/26
    This program stores 50 random integers from the range of 1-20 and prints a new array without the
    duplicate integers from the last array.
 */
import java.util.ArrayList;
import java.util.Random;

public class ArrayListRandom {

    public static void main(String[] args) {
        Random rand = new Random();

        // Original ArrayList with 50 random values (1–20)
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            int value = rand.nextInt(20) + 1;
            list.add(value);
        }

        System.out.println("Original List:");
        System.out.println(list);

        ArrayList<Integer> noDuplicates = removeDuplicates(list);

        System.out.println("\nWithout Duplicates:");
        System.out.println(noDuplicates);
    }

    // Generic method to remove duplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();

        for (E item : list) {
            if (!result.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }
}
