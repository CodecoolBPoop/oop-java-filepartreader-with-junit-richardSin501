import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public ArrayList wordsByABC() throws IOException {
        List<String> wordsList = getWordsFromFilePartReader();
        Collections.sort(wordsList);
        return new ArrayList(wordsList);
    }


    public ArrayList wordsContainingSubString(String subString) throws IOException {
        List<String> wordsList = getWordsFromFilePartReader();
        List<String> results = wordsList.stream()
            .filter(s -> s.contains(subString))
            .collect(Collectors.toList());
        return new ArrayList(results);
    }

    public ArrayList wordsArePalindrome() throws IOException {
        List<String> wordsList = getWordsFromFilePartReader();
        List<String> results = wordsList.stream()
            .filter(s -> s.equals(new StringBuilder(s).reverse().toString())) // isPalindrome
            .collect(Collectors.toList());
        return new ArrayList(results);

    }

    private List<String> getWordsFromFilePartReader() throws IOException {
        String[] words = filePartReader.readLines().split("\\W+");
        return Arrays.asList(words);
    }
}
