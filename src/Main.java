import java.io.IOException;

public class Main {

    public static void main(String args[]) {
        FilePartReader filePartReader = new FilePartReader();

        filePartReader.setup("res/test_text.txt", 2, 7);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        try {
            System.out.println(
                filePartReader.readLines()
            );
            System.out.println(fileWordAnalyzer.wordsByABC());
            System.out.println(fileWordAnalyzer.wordsContainingSubString("ine"));
            System.out.println(fileWordAnalyzer.wordsArePalindrome());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
