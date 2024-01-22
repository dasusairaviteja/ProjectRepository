package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class products{
    private int id;
    private String name;
    private int price;

    

    public products(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
public class StreamApi {
    public static void main(String[] args) {
    
        List<products> list = new ArrayList<>();
//
//        for (products product : getproducts()) {
//            if (product.getPrice() > 2500){
//                list.add(product);
//            }
//                  }
//        for(products printprdts : list){
//            System.out.println(printprdts);
//        }

        List<products> list2 =getproducts().stream().filter((products) -> products.getPrice()> 2500).collect(Collectors.toList());
        list2.forEach(System.out::print);
        System.out.println(list2);

//        getproducts().stream().filter((products) -> products.getPrice() > = 3500);
    }
    public static List<products> getproducts(){
        List<products> listOfItems = new ArrayList<>();
        listOfItems.add(new products(1 , "laptop" , 2500));
        listOfItems.add(new products(2 , "ps5" , 4500));
        listOfItems.add(new products(3 , "gamestation" , 3500));

        return listOfItems;
    }
}
