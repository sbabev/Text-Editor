import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TextEditor {

    public String swapTwoRows(int firstRow, int secondRow, Reader input) throws IOException {
        if (firstRow < 0 || secondRow < 0 || input == null) {
            throw new IllegalArgumentException("Arguments must be positive");
        }

        ArrayList<String> listOfRows = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(input);
            listOfRows = (ArrayList<String>) reader.lines().collect(Collectors.toList());
            Collections.swap(listOfRows, firstRow, secondRow);
            reader.close();
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Rows out of bounds");
        }
        String updatedDate = String.join("\n", listOfRows);
        writeToFile(updatedDate);
        return updatedDate;
    }

    public String swapTwoWords(int firstRow, int indexOfFirstWord, int secondRow, int indexOfSecondWord, Reader input) throws IOException {
        if (firstRow < 0 || secondRow < 0 || indexOfFirstWord < 0 || indexOfSecondWord < 0 || input == null) {
            throw new IllegalArgumentException("Arguments must be positive");
        }
        ArrayList<String> listOfRows = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(input);
            listOfRows = (ArrayList<String>) reader.lines().collect(Collectors.toList());
            reader.close();
            if (firstRow != secondRow) {

                    String first = listOfRows.get(firstRow);
                    String[] wordsFirst = first.split("\\s+");
                    String second = listOfRows.get(secondRow);
                    String[] wordsSecond = second.split("\\s+");

                    first = first.replaceAll(wordsFirst[indexOfFirstWord], wordsSecond[indexOfSecondWord]);
                    second = second.replaceAll(wordsSecond[indexOfSecondWord], wordsFirst[indexOfFirstWord]);
                    listOfRows.set(firstRow, first);
                    listOfRows.set(secondRow, second);
                } else {
                String first = listOfRows.get(firstRow);
                String[] wordsFirst = first.split("\\s+");
                Collections.swap(Arrays.asList(wordsFirst), indexOfFirstWord, indexOfSecondWord);
                first = String.join(" ", wordsFirst);
                listOfRows.set(firstRow, first);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Out of bounds arguments");
        }
        String updatedDate = String.join("\n", listOfRows);
        writeToFile(updatedDate);
        return updatedDate;
    }

    public static void writeToFile(String data) throws IOException {
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }
        FileWriter writeToFile = new FileWriter(("filename.txt"), false);
        writeToFile.write(data);
        writeToFile.flush();
        writeToFile.close();
    }
}