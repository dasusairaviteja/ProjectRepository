package practice;


interface Animal{
    void sound();

    default void legs() {
    }
}

class Dog implements Animal{

    @Override
    public void sound() {
        System.out.println("i am going to BARK and BARK");
    }

    @Override
    public void legs() {
        Animal.super.legs();
        System.out.println("Dog has 4 legs");
    }
}

class Hen implements Animal{

    public void sound() {
        System.out.println("i am hen,kuchrukoku");
    }

    @Override
    public void legs() {
        Animal.super.legs();
        System.out.println("i have 2 legs to walk");
    }
}
public class DefaultAndStaticMethods {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.legs();
    }
}


