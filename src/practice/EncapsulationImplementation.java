package practice;

import org.w3c.dom.ls.LSOutput;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class EncapsulationImplementation {

    private int id;
    private String name;

    public int getId() {
        return id;
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

    public int getAge(int age) {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    void display(){
        System.out.println("i am dasu");
    }


    public static void main(String[] args) {
        EncapsulationImplementation ei = new EncapsulationImplementation();
        System.out.println(ei.getAge(10));
        ei.display();

    }
}
