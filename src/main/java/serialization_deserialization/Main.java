package serialization_deserialization;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Sifat", 26, "1234sifu");

        // Serialize object to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(person);
            System.out.println("Serialization Done");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize obj from a file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Deserialized person: " + deserializedPerson);
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*✅ Notice that the password field is null because it was marked transient.*/
    }
}
