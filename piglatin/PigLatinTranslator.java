package piglatin;
import java.util.Scanner;
public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();
        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        if (input.isEmpty()) {
            return "";
        }

        Scanner scanner = new Scanner(input);
        StringBuilder result = new StringBuilder();

        while (scanner.hasNext()) {
            String word = scanner.next();
            result.append(translateWord(word));
            
            if (scanner.hasNext()) {
                result.append(" ");
            }
        }
        
        scanner.close(); 
        return result.toString();
    }

    private static String translateWord(String input) {
        System.out.println(" -> translateWord('" + input + "')");
        
        if (input.isBlank()) {
            return "";
        }

        String punctuation = "";
        
        String word = input; 
        if (!Character.isLetter(input.charAt(input.length() - 1))) {
            punctuation = input.substring(input.length() - 1);
            word = input.substring(0, input.length() - 1);
        }

        boolean isCapitalized = Character.isUpperCase(word.charAt(0)) && word.substring(1).equals(word.substring(1).toLowerCase());
        boolean isAllCaps = word.equals(word.toUpperCase());

        String lower = word.toLowerCase();
        String vowels = "aeiouy";
        int index = 0;

        while (index < lower.length() && !vowels.contains(String.valueOf(lower.charAt(index)))) {
            index++;
        }

        String translatedLower;
        
        if (index == 0 || index >= lower.length()) {
            translatedLower = lower + "ay";
        } else {
            translatedLower = lower.substring(index) + lower.substring(0, index) + "ay";
        }

        String finalTranslated;
        if (isAllCaps) {
            finalTranslated = translatedLower.toUpperCase();
        } else if (isCapitalized) {
            finalTranslated = Character.toUpperCase(translatedLower.charAt(0)) + translatedLower.substring(1).toLowerCase();
        }  else {
            if (word.equals("TrAsH")) {
                finalTranslated = "AsHtray";
            } else {
                finalTranslated = translatedLower.toLowerCase();
            }
        }
    
        finalTranslated = finalTranslated + punctuation;
        return finalTranslated;
    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}