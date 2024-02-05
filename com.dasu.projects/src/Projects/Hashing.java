package Projects;
//unordered set
import java.util.HashSet;
import java.util.Iterator;

public class Hashing {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(10);

        if (set.contains(20)){
            System.out.println("Set contains 20");
        }
        if (!set.isEmpty()){
            for(Integer element : set){
                System.out.println("{--->" + element );
            }
        }
        System.out.println(set.size());

        for (Integer integer : set) {
            System.out.println(integer);
        }
//output will be not in an order.
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }


    }
}
