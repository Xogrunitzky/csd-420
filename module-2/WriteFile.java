/*
Xavier Grunitzky
Module 2.2 Assignment
4/5/26
This program will create a file or use existing file and append the random integers and double value data to that file.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WriteFile {
    public static void main(String[] args) {

        Random rand = new Random();

        int[] numbers = new int[5];
        double[] values = new double[5];

        // Fill arrays with random values
        for (int i = 0; i < 5; i++) {
            numbers[i] = rand.nextInt(100) + 1; // random int 1-100
            values[i] = rand.nextDouble() * 100; // random double 0-100
        }

        // Write data to file (append mode)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("xavierdatafile.dat", true))) {

            bw.write("Integers: ");
            for (int n : numbers) {
                bw.write(n + " ");
            }
            bw.newLine();

            bw.write("Doubles: ");
            for (double d : values) {
                bw.write(String.format("%.2f ", d));
            }
            bw.newLine();

            bw.write("--------------------------------");
            bw.newLine();

            System.out.println("Data written successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }
}
