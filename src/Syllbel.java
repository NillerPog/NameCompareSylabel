import java.util.Scanner;

public class Syllbel {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Write a name");
        String word = in.next();
        String vowel = "AEIOUYaeiouy";
        String vowelNoE = "AIOUYaiouy";
        int sylableCount = 0, vowelCount = 0, vowelCountDelayed;
        boolean check;

        for (int i = 0; i < word.length(); i++) {       //Goes through each letter of the word
            char compare = word.charAt(i);              //creates a char of the letter in the string of word at the position of for loop
            check = false;                              //resetting the check for use with each letter
            for (int j = 0; j < vowel.length(); j++) {
               if(compare == vowel.charAt(j)) {         //this compares the letter with each vowel in the english alphabet
                   check = true;
                   break;
               }
            }

            vowelCountDelayed = vowelCount;         //Delayed vowel count is set to the current vowelCount before it is updated

            if (check) {
                vowelCount++;       //vowel count is now bigger than the delay, unless there were no vowel last time, then the delay is bigger
            } else vowelCount = 0;

            if (vowelCountDelayed > vowelCount) {       //sylableCount only increase when the vowel is not detected last, making vowel count 0 and the delay 0 or higher
                sylableCount++;                         //this does mean the last letter is not evaluated, and must be checked in a final for loop, which also checks for e/E
            }

            //Determines the last character of name, if it is 'e' or 'E' it will either count it or not, depending if the previous letter was a vowel.
            if(i == word.length()-1 && vowelCountDelayed == 0){             //if the word ends in 'E' or 'e' with no vowels preceding it
                for (int j = 0; j < vowelNoE.length(); j++) {
                    if (vowelNoE.charAt(j) == word.charAt(i)){
                        sylableCount++;
                    }
                }
            } else if(i == word.length()-1 && vowelCountDelayed != 0){      //if the word ends in multiple vowels
                for (int j = 0; j < vowel.length(); j++) {
                    if (vowel.charAt(j) == word.charAt(i)){
                        sylableCount++;
                    }
                }
            }
            //System.out.println(check + " " + number +  " " + number2);
        }
        System.out.println("There are " + sylableCount + " syllabels in the word " + word); //print out result after initial for loop
    }
}


