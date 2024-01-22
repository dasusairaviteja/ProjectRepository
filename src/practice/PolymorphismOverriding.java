package practice;

public class PolymorphismOverriding {

    class shape{
        public void area(){
            System.out.println("displays area of shape");
        }
    }
    class Triangle extends shape{
        public void area(){
            System.out.println("area of triangle is 0.5 *b *h");
        }
    }
    class Circle extends shape{
       public void area(int r){
            System.out.println("area of triangle is 3.14 * r * r" + 3.14 *r*r);
        }
    }
    public  void main(String[] args) {
        Circle circle = new Circle();
        circle.area(12);
    }
}
