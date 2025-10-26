package piglatin;
import java.util.Scanner;
public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";

        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        result = translateWord(input);

        return result;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");
        
        if (input.isBlank()) {
            return "";
        }

        String punctuation = "";
        if (!Character.isLetter(input.charAt(input.length() - 1))) {
            punctuation = input.substring(input.length() - 1);
            input = input.substring(0, input.length() - 1);
        }

        boolean isCapitalized = Character.isUpperCase(input.charAt(0));
        boolean isAllCaps = input.equals(input.toUpperCase());

        String lower = input.toLowerCase();

        String vowels = "aeiouyAEIOUY";
        int index = 0;
        while (index < input.length() && !vowels.contains(String.valueOf(input.charAt(index)))) {
            index++;
        }

         String translatedLower;
         if (index == 0) {
            translatedLower = lower + "ay";
        } else if (index >= lower.length()) {
            translatedLower = lower + "ay";
        } else {
            translatedLower = lower.substring(index) + lower.substring(0, index) + "ay";
        }

        if (vowels.contains(lower.substring(0,1))) {
            String base = lower + "ay";
            if (isAllCaps) {
                base = base.toUpperCase();
            } else if (isCapitalized) {
                base = input.substring(0,1).toUpperCase() + input.substring(1) + "ay";
            } else {
                base = base.toLowerCase();
            }
            return base + punctuation;
        }


        if (index == 0 || index >= input.length()) {
            String base = lower + "ay";
            if (isAllCaps) {
                base = base.toUpperCase();
            } else if (isCapitalized) {
                base = input.substring(0,1).toUpperCase() + input.substring(1) + "ay";
            } else {
                base = base.toLowerCase();
            }
            return base + punctuation;
        }

        String consonantsBeforeVowels = lower.substring(0, index);
        String rest = lower.substring(index);
        String finalLower = rest + consonantsBeforeVowels + "ay";

        String finalTranslated;
        if (isAllCaps) {
            finalTranslated = finalLower.toUpperCase();
        } else if (isCapitalized) {
            finalTranslated = Character.toUpperCase(finalLower.charAt(0)) + finalLower.substring(1).toLowerCase();
        } else {
            finalTranslated = finalLower.toLowerCase();
        }

        finalTranslated = finalTranslated + punctuation;
        return finalTranslated;
    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
