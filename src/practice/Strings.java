package practice;

public class Strings {
    public static void main(String[] args) {
//         StringBuilder sb = new StringBuilder("DASUSAIRAVITEJA");
//         sb.charAt(3);
//         System.out.println(sb);
//         sb.setCharAt(0 , 'y');
//         System.out.println(sb);
//         sb.insert( 0 , 'A');
//        System.out.println(sb);
//        sb.delete( 0 , 'A');
//        System.out.println(sb);
//        sb.append( 1);
//        System.out.println(sb);
        StringBuilder sb = new StringBuilder("HELLO");
        for (int i = 0; i < sb.length()/2; i++) {
            int front = i;
            int back = sb.length() - 1 - i ;

            char frontChar = sb.charAt(front);
            char backChar = sb.charAt(back);

            sb.setCharAt(front , backChar );
            sb.setCharAt(back , frontChar );

        }
        System.out.println(sb);
    }

}
