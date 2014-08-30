package logic;

import java.io.FileNotFoundException;

public class Processor {

    public static final String SOURCE_FILE = "source.txt";

    public void process(){
        FileWordsReader fileWordsReader = null;
        try {
            fileWordsReader = new FileWordsReader(SOURCE_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String s = fileWordsReader.readText();
        WordProcessor wordProcessor =  new WordProcessor();


    }

}
