package text_file_reader;

import java.io.*;

public class FileIO {
    public static void main(String[] args) throws IOException {
        /*// Reading file with FileReader, Inefficient
        try (FileReader reader = new FileReader("D:/Backend - Java/Projects/module-8-exception-handling-file-i_o/src/main/java/file_io_serialization/input.txt")) { // try with resource, autoclosable, It automatically closes the FileReader after the try block finishes — even if an exception occurs.
            int ch;
            while((ch = reader.read()) != -1)  {
                System.out.print((char) ch);
            }
            System.out.println();
        }
        catch (IOException e) { // checked exception
            System.out.println("Error while reading file. Message: " + e.getMessage()); // ?
            e.printStackTrace(); // prints the full details of the error to the console.
        }*/

        /*// Writing with FileWriter, Inefficient
        String filePath = "D:/Backend - Java/Projects/module-8-exception-handling-file-i_o/src/main/java/file_io_serialization/output.txt";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Hello, World!\n");
            writer.write("This is written using FileWriter.\n");
            writer.write("FileWriter handles characters and stores them in text files.");
        }
        catch (IOException e) {
            System.out.println("Error while writing file. Message: " + e.getMessage()); // e.getMessage:
            e.printStackTrace();
        }*/

        /*// Reading with InputStream and creating copy using OutputStream
        // It copies a file (here, an image input.jpg) from one location (sourcePath) to another (destinationPath) using byte streams (FileInputStream and FileOutputStream).
        String sourcePath = "D:/Backend - Java/Projects/module-8-exception-handling-file-i_o/src/main/java/file_io_serialization/input.jpg";
        String destinationPath = "D:/Backend - Java/Projects/module-8-exception-handling-file-i_o/src/main/java/file_io_serialization/output.jpg";

        try(FileInputStream fis = new FileInputStream(sourcePath);
            FileOutputStream fos = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[1024]; // read 1KB chunks, 1kb = 1024 bytes
            int bytesRead;

            while((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead); // write what exactly was read
            }

            System.out.println("Image copied successfully!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/

        /*File file = new File("example.txt");

        if(file.createNewFile()) {
            System.out.println("File created");
        }
        else {
            System.out.println("File already exists");
        }

        File dir = new File("myFolder");
        dir.mkdir();

        File dirs = new File("parent/child/grandchild");
        dirs.mkdirs();   // creates all missing folders


        String content = Files.readString(Paths.get("example.txt"));
        System.out.println(content);

        Files.writeString(Paths.get("example.txt"), "New content here...");

        Files.writeString(Paths.get("example.txt"), "\nAppending new line...", StandardOpenOption.APPEND);


        File newFile = new File("example.txt");
        newFile.delete();

        File newDir = new File("myFolder");
        newDir.delete();   // Only works if folder is empty*/

        /*// Example of creating a file using Files.createNewFile() (NIO)
        Path path = Paths.get("src/main/resources/newFile.txt"); // full path ney
        try {
            Path createdFilePath = Files.createFile(path);
            System.out.println("File created. Path: " + createdFilePath);
        }
        catch (FileAlreadyExistsException e) {
            System.out.println("File already exists!");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        /*// file creation using traditional way using io,  Example of creating a file using File class
        String path = "src/main/resources/newFile.txt";
        File file = new File(path);

        try {
            boolean isFileCreationSuccessful = file.createNewFile(); // boolean return hoy

            if(!isFileCreationSuccessful) {
                System.out.println("File already exists");
            }
            else {
                System.out.println("File created. Path: " + path);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        /*// file creation using fos
        String fileNameWithPath = "src/main/resources/newFile.txt";
        String content = "Hello, FileOutputStream\n";

        try(FileOutputStream fos = new FileOutputStream(fileNameWithPath, true)) { // try with resource, true means last e append korbe
            byte[] data = content.getBytes();
            fos.write(data);
            System.out.println("File saved: " + fileNameWithPath);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found or  permission denied");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        /*// Read using scanner:
        System.out.println("Reading file with scanner");
        System.out.println();

        try {
            File file = new File("src/main/resources/newFile.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
        }*/

        // Read using bufferReader
        System.out.println("Reading file with bufferedReader");
        System.out.println();

        try (BufferedReader br =  new BufferedReader(new FileReader("src/main/resources/newFile.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        /*// Read using filereader
        System.out.println("Reading file with filereader");
        System.out.println();

        try (FileReader fr =  new FileReader("src/main/resources/newFile.txt")) {
            int ch;
            while((ch = fr.read()) != -1) {
                System.out.println((char) ch);
            }
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }*/

        /*// Read using New IO:
        System.out.println("Reading file using NIO");
        System.out.println();

        Path path  = Path.of("src/main/resources/newFile.txt");
        try {
            List<String> allLines = Files.readAllLines(path);
            allLines.forEach(System.out::println);
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }*/

        /*// Write using FOS
        String data = "Hello, FileOutputStream!";

        try (FileOutputStream fos = new FileOutputStream("src/main/resources/newFile.txt")) {
            fos.write(data.getBytes());
            System.out.println("Data written using FileOutputStream.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/

        /*// Write using FOS
        String data = "Hello, FileWriter!";

        try (FileWriter writer = new FileWriter("src/main/resources/newFile.txt")) {
            writer.write(data);
            System.out.println("Data written using FileWriter.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/

        /*// Write using NIO
        String data = "Hello, NIO Files!";
        Path path = Path.of("src/main/resources/newFile.txt");

        try {
            Files.write(path, data.getBytes());
            System.out.println("Data written using Files.write()");
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/

        // Delete see by myself! Later
    }
}
