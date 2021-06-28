package PM;

import java.util.Random;

public class Output {
    private int dashCount = 100, gapNewLineCount = 2, defaultColWidth = 30;
    private char lineChar = '.';


    public void printUpDownBoundary(int cols) {
        System.out.print('+');
        for (int i = 0; i < cols; i++) {
            for (int j = 1; j < defaultColWidth-1; j++) {
                System.out.print('.');
            }
            System.out.print('+');
        }
        System.out.println();
    }

    public void printTitles(String... titles) {
        printUpDownBoundary(titles.length);
        int i;
        for (i = 0; i < titles.length - 1; i++)
            printValueInTable(titles[i]);
        printLastValueInTable(titles[i]);
        printUpDownBoundary(titles.length);
    }

    public <T>void printValues(T... values) {
        int i;
        for (i = 0; i < values.length - 1; i++)
            printValueInTable(values[i]);
        printLastValueInTable(values[i]);
        printUpDownBoundary(values.length);
    }

    public <T>void printValuesWithoutLowerBoundary(T... values) {
        int i;
        for (i = 0; i < values.length - 1; i++)
            printValueInTable(values[i]);
        printLastValueInTable(values[i]);
    }

    public <T> void printValueInTable(T value) {
        String leftAlignFormat = "| %-" + (defaultColWidth - 4) + "s ";
        if (value != null)
            System.out.format(leftAlignFormat, value);
        else
            System.out.format(leftAlignFormat, "null");
    }

    public <T> void printLastValueInTable(T value) {
        String leftAlignFormat = "| %-" + (defaultColWidth - 4) + "s |";
        if (value != null)
            System.out.format(leftAlignFormat, value);
        else
            System.out.format(leftAlignFormat, "null");
        System.out.println();
    }





    public Output() {
//        displayHorizontalLine();
    }

    public void displayHorizontalLine() {
        for (int i = 0; i < dashCount; i++) {
            System.out.print(lineChar);
        }
        System.out.println();
    }

    public void addGap() {
        for (int i = 0; i < gapNewLineCount; i++) {
            System.out.println();
        }
    }

    public void displayNewLine() {
        System.out.println();
    }

    public void displayText(String text) {
        System.out.print(text);
    }

    public void displayTextWithNewLine(String text) {
        System.out.println(text);
    }

    public void printInstructions() {
        System.out.println("Type \"home\" and press enter to go home from any state.\nType \"back\" and press enter to go back one state.");
    }
}
