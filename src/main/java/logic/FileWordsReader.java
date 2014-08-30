package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileWordsReader implements WordsReader {
    private String fileName;
    private BufferedReader reader;

    public FileWordsReader(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        reader = new BufferedReader(new FileReader(fileName));
    }

    @Override
    public String readText() {
        StringBuffer buffer = new StringBuffer();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
