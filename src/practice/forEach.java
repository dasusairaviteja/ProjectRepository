package practice;

import java.util.*;

public class forEach {
    public static void main(String[] args) {

        List<Person> list = new ArrayList<Person>();
        list.add(new Person(100 , "dasu"));
        list.add(new Person(101 , "sai"));
        list.add(new Person(102 , "ravi"));

        list.forEach((Person) -> System.out.println(Person.getName()));


    }
}
class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}