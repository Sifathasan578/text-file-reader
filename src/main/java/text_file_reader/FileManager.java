package text_file_reader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.List;

public class FileManager {
    private String filePathInput;
    private String filePathOutput;

    public FileManager(String filePathInput, String filePathOutput) {
        this.filePathInput = filePathInput;
        this.filePathOutput = filePathOutput;
    }

    public void fileReading(List<Operation> lst) {
        // Reading file using BufferedReader
        try(BufferedReader br = new BufferedReader(new FileReader(filePathInput))) {
            String line;
            while((line = br.readLine()) != null) {
                Operation op = parseLine(line);
                if(op != null) { // Validation, always check null at first
                    lst.add(op);
                }
            }
        }
        catch (IOException e) {
            System.out.println("Failed to read file: " + filePathInput);
        }
    }

    public void fileWriting(List<Operation> lst) {
        // Writer file using BufferedWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePathOutput))) { // Writing once! clear the file at the start and then append objects
            bw.write("[");
            bw.newLine();

            for(int i = 0; i < lst.size(); i++) {
                Operation op = lst.get(i);
                op.calculateOperation();

                bw.write("{ \"numOne\": " + op.getNumOne() + ", \"numTwo\": " + op.getNumTwo() + ", \"operator\": \"" + op.getOperator() + "\", \"result\": " + op.getResult() + " }");

                if(i != (lst.size() - 1)) {
                    bw.write(",");
                }

                bw.newLine();
            }

            bw.write("]");
        }
        catch (IOException e) {
            System.out.println("Failed to write file: " + filePathOutput);
        }
    }

    public void jsonToObject() {
        // Parsing JSON text to object using GSON
        try (BufferedReader br = new BufferedReader(new FileReader(filePathOutput))) {
            Gson gson = new Gson(); // JSON parser

            List<Operation> operations = gson.fromJson(
                    br,
                    new TypeToken<List<Operation>>() {}.getType());

            showObject(operations);
        }
        catch (com.google.gson.JsonSyntaxException e) {
            System.out.println("JSON format error: The JSON structure is malformed.");
            System.out.println("Details: " + e.getMessage());

        } catch (com.google.gson.JsonIOException e) {
            System.out.println("JSON I/O error while parsing JSON.");
            System.out.println("Details: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Failed to read JSON file: " + filePathOutput);
        }
    }

    public void showObject(List<Operation> operations) {
        for (Operation op : operations) {
            System.out.println(op.toString());
        }
    }

    public static Operation parseLine(String line) {
        if(line == null || line.trim().isEmpty()) {
            return null;
        }
        String[] parts = line.trim().split("\\s+");

        if(parts.length == 3) {
            if(!isNumeric(parts[0]) || !isNumeric(parts[2])) {
                System.out.println("Invalid number(s): " + line);
                return null;
            }

            double numOne = Double.parseDouble(parts[0]);
            double numTwo = Double.parseDouble(parts[2]);
            String operator = parts[1];

            if(!operatorValidation(operator)) {
                System.out.println("Invalid operator: " + operator);
                return null;
            }

            return new Operation(numOne, numTwo, operator);
        }

        System.out.println("Invalid format (expected: number operator number): " + line);
        return null;
    }

    public static boolean operatorValidation(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    public static boolean isNumeric(String num) {
        if(num == null) {
            return false;
        }
        try {
            Double.parseDouble(num);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
