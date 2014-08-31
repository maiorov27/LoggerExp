package logic;

import java.io.FileNotFoundException;

public class Processor {

    public static final String SOURCE_FILE = "source.txt";
    private FileWordsReader fileWordsReader;
    private WordProcessor wordsProcessor;
    private WordsPrinter printer;
    public Processor(FileWordsReader fileWordsReader, WordProcessor wordsProcessor, WordsPrinter printer) {
        this.fileWordsReader = fileWordsReader;
        this.wordsProcessor = wordsProcessor;
        this.printer = printer;
    }

    public void process(){
        String text = fileWordsReader.readText();
        Word[] latinWords = wordsProcessor.getLatinWords(text);
        Word[] specialWords = wordsProcessor.getSpecialWords(text);
        printer.printWords(latinWords);
        printer.printWords(specialWords);
    }

}
