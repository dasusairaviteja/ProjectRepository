package practice;

public class BackTracking {

    // o(n*n!)
    // n
    static void printPermutation(String str , String perm , int index){
        if(str.length() == 0){
            System.out.println(perm);
            return;


        }
        for (int i = 0; i < str.length(); i++) {
            char currentchar = str.charAt(i);
            String newstr = str.substring(0,i) + str.substring(i+1);
            printPermutation(newstr , perm + currentchar ,index+1);
        }
    }
    public static void main(String[] args) {
        String str = "DAS";
        printPermutation(str, "" , 0);
    }
}
