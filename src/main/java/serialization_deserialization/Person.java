package serialization_deserialization;

import java.io.Serializable;

/*A class must implement the Serializable interface to allow serialization.*/
public class Person implements Serializable { // I want to serialize this obj
    private static final long serialVersionUID = 1L; /*serialVersionUID is used to ensure that the class version matches during deserialization.*/

    String name;
    int age;
    transient String password; /*transient keyword can be used to skip fields from being serialized.*/

    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", password='" + password + "'}";
    }
}

