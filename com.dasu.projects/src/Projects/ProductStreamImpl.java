package Projects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductStreamImpl {
    public static void main(String[] args) {
        getProducts().stream()
                .filter((product) -> product.getSalary() > 1500).forEach(System.out::println);

    }
    private static List<Products> getProducts(){
        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(100 , "dasu" , 1500));
        productsList.add(new Products(101 , "sai" , 1600));
        productsList.add(new Products(102 , "ravi" , 1700));

        return productsList;
    }
}

class Products{
    private int id;
    private String name;

    public Products(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    private int salary;

}