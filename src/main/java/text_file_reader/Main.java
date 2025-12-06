package text_file_reader;
/*
* Author: Imrul Hasan Sifat
* */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Operation> lst = new ArrayList<>();

        String filePathInput = "src/main/resources/input.txt";
        String filePathOutput = "src/main/resources/output.txt";

        FileManager fileManager = new FileManager(filePathInput, filePathOutput);
        fileManager.fileReading(lst);

        fileManager.fileWriting(lst);

        fileManager.jsonToObject();
    }
}