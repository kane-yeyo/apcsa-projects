import java.util.Scanner; //reads keyboard input

public class WordGuesser { //creates class

    public static void main(String[] args) { //defines the main method

        String[] words = { //creates an array of possible 5-letter words
            "actor", "adult", "alarm", "album", "angel", "ankle", "arrow", "beard", "bench", "birth",
"blade", "blood", "board", "brain", "brand", "brick", "brush", "cabin", "cable", "candy",
"chest", "child", "china", "clock", "coach", "coast", "coral", "crash", "cream", "crime",
"cross", "crowd", "crown", "cycle", "delay", "depth", "devil", "doubt", "draft", "drama",
"drink", "earth", "enemy", "entry", "error", "event", "faith", "fault", "field", "fence",
"fiber", "flock", "floor", "flute", "force", "frame", "front", "fruit", "giant", "globe",
"ghost", "giant", "glory", "grain", "grant", "grass", "guard", "guest", "habit", "heart",
"honey", "hotel", "humor", "ideal", "image", "index", "input", "issue", "jelly", "joint",
"judge", "layer", "leave", "level", "limit", "local", "logic", "lunch", "major", "maple",
"match", "metal", "meter", "model", "money", "month", "moral", "motor", "music", "nurse",
"offer", "order", "owner", "paint", "panel", "party", "pasta", "peace", "penny", "phone",
"photo", "piano", "pilot", "pizza", "plane", "plate", "point", "pound", "power", "press",
"price", "prize", "proof", "proud", "queen", "radio", "ranch", "range", "ratio", "reply",
"river", "robot", "rough", "royal", "ruler", "scale", "scene", "scope", "score", "sense",
"serve", "shade", "shake", "shape", "shift", "shine", "shirt", "shock", "shoes", "shoot",
"skill", "skirt", "slope", "smoke", "snake", "space", "spare", "speak", "speed", "spend",
"spice", "split", "spoon", "sport", "squad", "stack", "staff", "stage", "stair", "stamp",
"stand", "stare", "start", "state", "steam", "steel", "stick", "still", "stock", "store",
"storm", "story", "strip", "style", "sugar", "swing", "sword", "taste", "teach", "teeth",
"theme", "thick", "thing", "think", "third", "thumb", "tiger", "title", "toast", "today",
"token", "topic", "total", "touch", "tower", "track", "trade", "trail", "train", "treat",
"trend", "trial", "tribe", "trick", "troop", "truck", "truly", "trust", "tulip", "uncle",
"union", "unity", "upper", "urban", "usual", "valid", "value", "video", "virus", "visit",
"vital", "vocal", "voice", "waste", "watch", "water", "wheel", "where", "which", "while",
"white", "whole", "woman", "world", "worry", "worth", "wound", "yacht", "youth", "zebra"
        };

        int index = (int)(Math.random() * words.length); //picks a random array index
        String answer = words[index]; //grabs the word at the random index

        Scanner input = new Scanner(System.in); //creates a scanner that reads the index

        System.out.println("Welcome to Word Guesser!");
        System.out.println("Guess the 5-letter word.");
        System.out.println("You have 6 attempts.");
        System.out.println();

        boolean guessed = false; //word is not guessed yet
        int attempt = 1; //attempts start at 1

        while (!guessed && attempt <= 6) { //keeps going until guessed or no attempts left
            //^-- boolean and logical operators
            System.out.print("Guess #" + attempt + ": "); //monitors attempt number
            String guess = input.nextLine().toLowerCase(); //makes all inputs lowercase

            if (guess.length() != 5) { //length cannot exceed 5 letters
                System.out.println("Please enter exactly 5 letters.");
            } else if (guess.equals(answer)) { //ends the loop if matched
                System.out.println("Correct! You won!");
                guessed = true;
            } else {
                attempt++; //increments attempts

                System.out.print("Result: ");

                for (int i = 0; i < 5; i++) {
                    String letter = guess.substring(i, i + 1);

                    if (letter.equals(answer.substring(i, i + 1))) {
                        System.out.print(letter + " "); //shows letter if right spot
                    } else if (answer.indexOf(letter) >= 0) {
                        System.out.print("* "); //shows star if wrong spot
                    } else {
                        System.out.print("_ "); //shows underscore if not in word
                    }
                }

                System.out.println();
                System.out.println("Letter = correct spot");
                System.out.println("* = in word but wrong spot"); //explains each symbol
                System.out.println("_ = not in word");
                System.out.println();
            }
        }

        if (!guessed) { //if the word remains unguessed, reveal the answer (loss)
            System.out.println("Out of guesses!");
            System.out.println("The word was: " + answer);
        }

        input.close(); //closes the scanner
    }
}