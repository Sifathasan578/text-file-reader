package text_file_reader;

public class ParseText {
    public static void main(String[] args) {

        /*String line = "12 + 5";
        String[] parts = line.split(" ");

        int n1 = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int n2 = Integer.parseInt(parts[2]);

        System.out.println(n1);
        System.out.println(operator);
        System.out.println(n2);*/

        String line = "8 + 7";
        System.out.println(parseLine(line).toString());
    }

    public static Operation parseLine(String line) {
        String[] parts = line.trim().split("\\s+");
        int n1 = Integer.parseInt(parts[0]);
        String op = parts[1];
        int n2 = Integer.parseInt(parts[2]);

        return new Operation(n1, n2, op);
    }
}
