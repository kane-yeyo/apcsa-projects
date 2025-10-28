package piglatin;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Book {
    private String title;
    private ArrayList<String> text = new ArrayList<String>();

    Book() {
        // Empty book - no code needed here.
    }

    // Helper to debug code
    // Prints out a range of lines from a book
    public void printlines(int start, int length) {
        System.out.println("Lines " + start + " to " + (start + length) + " of book: " + title);
        for (int i = start; i < start + length; i++) {
            if (i < text.size()) {
                System.out.println(i + ": " + text.get(i));
            } else {
                System.out.println(i + ": line not in book.");
            }
        }
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getLine(int lineNumber) {
        return text.get(lineNumber);
    }

    int getLineCount() {
        return text.size();
    }

    void appendLine(String line) {
        text.add(line);
    }

    public void readFromString(String title, String string) {
        this.title = title;
        text.clear();
        Scanner input = new Scanner(string);
        while (input.hasNextLine()) {
            text.add(input.nextLine());
        }
        input.close();
    }

    public void readFromUrl(String title, String url) {
        // load a book from a URL.
        this.title = title;

          try (Scanner input = new Scanner(URI.create("https://www.gutenberg.org/cache/epub/77133/pg77133.txt").toURL().openStream())) {
            while (input.hasNextLine()) {
                text.add(input.nextLine());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void writeToFile(String name) {
        // TODO: Add code here to write the contents of the book to a file.
        // Must write to file using provided name.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name))) {
            for (String line : text) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
