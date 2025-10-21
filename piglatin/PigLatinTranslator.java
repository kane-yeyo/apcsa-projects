package piglatin;

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
        
        if (input.isEmpty()) {
            return input;
        }

        String vowels = "aeiouyAEIOUY";
        if (vowels.contains(input.substring(0,1))) {
            return input + "ay";
        }

        int index = 0;
        while (index < input.length() && !vowels.contains(String.valueOf(input.charAt(index)))) {
            index++;
        }

        if (index == 0 || index >= input.length()) {
            return input + "ay";
        }

        String consonantsBeforeVowels = input.substring(0, index);
        String rest = input.substring(index);

        return rest + consonantsBeforeVowels + "ay";
    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
