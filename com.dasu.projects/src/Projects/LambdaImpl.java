package Projects;

public class LambdaImpl{
public static void main(String[] args) {
    Shape Rectangle = () -> System.out.println("rectangle : draw() method1");
//        Rectangle.draw();
//        Rectangle.draw();
    Shape circle = ()-> System.out.println("Implementing circle menthod");
    circle.draw();
    Shape.lines();

//    print(Rectangle);
}
}
interface Shape{
    void draw();

    static void lines() {
        System.out.println("i am good");
    }

}
//public static void print(Shape shape){
//    shape.draw();
//}
class Rectangle implements Shape{


    @Override
    public void draw() {
        System.out.println("rectangle : draw() method");

    }
}
