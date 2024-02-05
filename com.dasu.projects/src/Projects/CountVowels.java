package Projects;

public class CountVowels {
    public static void main(String[] args) {
        String name = "dasusairaviteja";
        char[] characters = name.toCharArray();
        int count =0;
        for (char character : characters) {
            if(character == 'a' || character == 'e'||character == 'i'||character == 'o'||character == 'u' ){
                System.out.println(character);
                count++;
            }
        }
        System.out.println("Number of vowels is "+ count);
}
    }
