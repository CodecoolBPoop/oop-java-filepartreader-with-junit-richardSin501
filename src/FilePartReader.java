import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;


    public FilePartReader() {
        filePath = null;
        fromLine = -1;
        toLine = -1;
    }

    public void setup(String filePath, int fromLine, int toLine) {
        if (fromLine > toLine)
            throw new IllegalArgumentException("\"fromLine\" can't be higher than \"toLine\"");

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String readToString() throws IOException {
        List<String> stringList = this.readToList();
        return String.join("\n", stringList);
    }

    public List<String> readToList() throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }

    public String readLines() throws IOException {
        List<String> lines = this.readToList();
        if (toLine > lines.size())
            throw new IndexOutOfBoundsException("toLine can't be higher than the file's linecount");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = fromLine - 1; i < toLine; i++) {
            stringBuilder.append(lines.get(i)).append("\n");
        }

        return stringBuilder.toString();
    }


}
