import java.util.Scanner;

public class VeeRecursive {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a height for your Vee >> ");
        int height = input.nextInt();

        drawVee(0, height, 0, 2 * height);
    }

    // Recursive method to draw all lines
    public static void drawVee(int currentLine, int totalLines, int spacesBefore, int spacesBetween) {
        if (currentLine == totalLines) {
            return; // Base case: all lines printed
        }

        // Print one line recursively:
        // total characters = spacesBefore + 1 (V) + spacesBetween + 1 (V)
        int totalChars = spacesBefore + 1 + spacesBetween + 1;
        printLine(0, totalChars, spacesBefore, spacesBetween);

        System.out.println(); // move to next line

        // Recursive call for next line
        drawVee(currentLine + 1, totalLines, spacesBefore + 1, spacesBetween - 2);
    }

    // Recursive method to print a line character by character
    // currentPos: current position in the line
    // totalChars: total chars in the line
    // spacesBefore: how many spaces before first V
    // spacesBetween: how many spaces between Vs
    public static void printLine(int currentPos, int totalChars, int spacesBefore, int spacesBetween) {
        if (currentPos == totalChars) {
            return; // base case: done printing line
        }

        if (currentPos < spacesBefore) {
            // print space before first V
            System.out.print(" ");
        } else if (currentPos == spacesBefore) {
            // print first V
            System.out.print("V");
        } else if (currentPos > spacesBefore && currentPos < spacesBefore + 1 + spacesBetween) {
            // spaces between the two Vs
            System.out.print(" ");
        } else if (currentPos == spacesBefore + 1 + spacesBetween) {
            // print second V
            System.out.print("V");
        }
        // else no other chars expected, but logically covered by totalChars

        // recurse to print next character
        printLine(currentPos + 1, totalChars, spacesBefore, spacesBetween);
    }
}
