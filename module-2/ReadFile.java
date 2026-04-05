/*
Xavier Grunitzky
Module 2.2 Assignment
4/5/26
This program will Read the file that was created in WriteFile program.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {

        // Try-with-resources automatically closes the file when finished
        try (BufferedReader br = new BufferedReader(new FileReader("xavierdatafile.dat"))) {

            String line; // This will store each line from the file

            // Read the file line-by-line until there are no more lines
            while ((line = br.readLine()) != null) {

                // Print each line to the console
                System.out.println(line);
            }

        } catch (IOException e) {
            // This runs if the file cannot be found or read
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }
}