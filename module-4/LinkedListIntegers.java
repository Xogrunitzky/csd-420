/*
    Xavier Grunitzky
    Module Assignment 4.2
    4/12/26
    This program stores 50,000 integers in a LinkedList and test the time to traverse the list using an
    iterator vs. using the get(index) method.

 */
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListIntegers {

    public static void main(String[] args) {

        testList(50000);
        testList(500000);
    }

    public static void testList(int size) {

        LinkedList<Integer> list = new LinkedList<>();

        // Fill list
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // -------------------------
        // ITERATOR TEST
        // -------------------------
        long startIterator = System.currentTimeMillis();

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }

        long endIterator = System.currentTimeMillis();

        // -------------------------
        // GET(INDEX) TEST
        // -------------------------
        long startGet = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        long endGet = System.currentTimeMillis();

        // -------------------------
        // RESULTS
        //With the 50000 integer size the iterator time is 2ms and get(index time is 970ms
        // so the Iterator is faster than get(index).

        //With the 500000 integer size iterator time is 8ms and get(index) time is 98953 ms, iterator is still
        // fast and get(index) time is way longer.
        // -------------------------
        System.out.println("\nList size: " + size);

        System.out.println("Iterator time: " + (endIterator - startIterator) + " ms");
        System.out.println("get(index) time: " + (endGet - startGet) + " ms");
    }
}
