package file_writing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/random.txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("Hello, world!");
            bw.newLine();
            bw.write("This is written using BufferedWriter.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
