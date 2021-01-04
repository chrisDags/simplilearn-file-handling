
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
    DESCRIPTION

    Project Objective: As a developer, write a program to read, write, and append to a file.
 */

/*
    Writing, Appending, and Reading from files WITHOUT USING NIO
 */

public class Runner {

    private final static String FILE_PATH = "src\\main\\resources\\myFile_WithoutNIO.txt";
    private final static String APPEND_FILE_PATH = "src\\main\\resources\\AppendToMe!.txt";

    private final static String APPEND_ME = "This String has been appended to the file without using NIO.";

    public static void main(String[] args) {

        List<String> namesList = new ArrayList<>(Arrays.asList("Wolverine", "SpiderMan", "Venom", "Solid Snake"));

        writeToFile(namesList);
        System.out.println("List has been written to file at: " + FILE_PATH);

        appendToFile(APPEND_ME);
        System.out.println("String has been appended to file at: " + APPEND_FILE_PATH);

        readFromFile();
    }

    private static void writeToFile(List<String> listToWrite) {

        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH));

            for (String elem : listToWrite) {
                bufferedWriter.write(elem);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void appendToFile(String strToAppend) {

        BufferedWriter bufferedWriter = null;
        try {

            bufferedWriter = new BufferedWriter(new FileWriter(APPEND_FILE_PATH, true));
            bufferedWriter.write(strToAppend + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void readFromFile() {

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(FILE_PATH));

            String lineFromFile;
            System.out.println("\nReading from file at: " + FILE_PATH);

            while ((lineFromFile = bufferedReader.readLine()) != null)
                System.out.println(lineFromFile);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
