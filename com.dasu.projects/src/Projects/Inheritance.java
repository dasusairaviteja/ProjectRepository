package Projects;

public class Inheritance {
    public static void main(String[] args) {
        Dog d= new Dog();
        d.bark();
    }
}

class Animal{
    void state(){
        System.out.println("I belong to animal category");
    }
}

class Dog extends Animal{
    void bark(){
        System.out.println("I bark");
    }
}





