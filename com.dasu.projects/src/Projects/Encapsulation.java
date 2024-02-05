package Projects;

public class Encapsulation {
    private int id;
    private String name;
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Encapsulation() {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Encapsulation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        Encapsulation encapsulation = new Encapsulation();
        encapsulation.setAge(100);
        encapsulation.setId(1);
        encapsulation.setName("DASU");
        System.out.println("my id number is " + encapsulation.getId());
        System.out.println("my age is " + encapsulation.getAge());
        System.out.println("my name is " + encapsulation.getName());



    }
}
