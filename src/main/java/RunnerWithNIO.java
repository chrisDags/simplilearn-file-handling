import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Writing, Appending, and Reading from files USING NIO
 */


public class RunnerWithNIO {

    private final static String FILE_PATH = "src\\main\\resources\\myFile_UsingNIO.txt";
    private final static String APPEND_FILE_PATH = "src\\main\\resources\\AppendToMe!.txt";

    private final static String APPEND_ME = "This String has been appended to the file using NIO.";

    public static void main(String[] args) {

        RunnerWithNIO runnerWithNIO = new RunnerWithNIO();

        List<String> namesList = new ArrayList<>(Arrays.asList(
                "Chris D'Agostino", "Johnny Silverhand", "Bas", "Batman"));

        runnerWithNIO.writeNamesToFile(namesList);
        runnerWithNIO.appendToFile(APPEND_ME);
        runnerWithNIO.readFromFile();
    }


    private void writeNamesToFile(List<String> namesList) {
        try {
            Files.write(Paths.get(FILE_PATH), namesList, Charset.defaultCharset());
            System.out.println("List has been written to file at: " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {
        try {
            List<String> fileContent = Files.readAllLines(Paths.get(FILE_PATH), Charset.defaultCharset());
            System.out.println("\nReading from file at: " + FILE_PATH);
            for (String elem : fileContent) {
                System.out.println(elem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void appendToFile(String strToAppend){
        try {
            Files.write(Paths.get(APPEND_FILE_PATH), strToAppend.getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(APPEND_FILE_PATH), "\n".getBytes(), StandardOpenOption.APPEND);
            System.out.println("String appended to file at: " + APPEND_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
