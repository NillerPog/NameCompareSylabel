import java.util.Scanner;

public class Syllbel {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Write a name");
        String name = in.next();
        String syllabel = "AEIOUYaeiouy";
        int numberOfSyl = 0;

        for (
                int i = 0; i < name.length(); i++) {
            char compare = name.charAt(i);
            for (int j = 0; j < syllabel.length(); j++) {
                if (compare == syllabel.charAt(j)) {
                    numberOfSyl++;
                }
            }
        }
        System.out.println("There are " + numberOfSyl + " syllabels in the word " + name);
    }
}


