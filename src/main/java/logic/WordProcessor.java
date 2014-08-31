package logic;


import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class WordProcessor {
    private static final Logger logger = Logger.getLogger(WordProcessor.class);

    public WordProcessor() {
        System.out.println(WordProcessor.class);
    }

    public Word[] getLatinWords(String text) {
        logger.info("Start getting lating words from text...");
        ArrayList<Word> latinWords = new ArrayList<Word>();
        Word[] words = getWords(text);
        for (int i = 0; i < words.length; i++) {
            if (isLatinWord(words[i])) {
                latinWords.add(words[i]);
            }
        }
        logger.info("Words have been found sucessfully. There were" + latinWords.size() + "latin words");
        Word[] filteredWords = new Word[latinWords.size()];
        latinWords.toArray(filteredWords);

        return filteredWords;
    }

    private Word[] getWords(String text) {
        String words[] = text.split("\\s+");
        logger.info("text was split to the words. There is " + words.length + " words.");
        Word[] w = new Word[words.length];
        for (int i = 0; i < words.length; i++) {
            w[i] = new Word(words[i]);
        }
        return w;
    }

    private boolean isLatinWord(Word word) {
        char[] symbols = word.wordToCharArray();
        for (int i = 0; i < symbols.length; i++) {
            if (!isLatinSymbol(symbols[i]))
                return false;
        }
        return true;
    }

    private boolean isLatinSymbol(char c) {
        if ((c > 65 && c < 90) || (c > 97 && c < 122))
            return true;
        return false;
    }

    public Word[] getSpecialWords(String text) {
        logger.info("Finding special words is started...");
        Word words[] = getLatinWords(text);
        ArrayList<Word> specialWord = new ArrayList<Word>();
        for (int i = 0; i < words.length; i++) {
            if (isWordSpecial(words[i]))
                specialWord.add(words[i]);
        }
        Word[] filteredWords = new Word[specialWord.size()];
        specialWord.toArray(filteredWords);
        logger.info("text was split to the words. There is " + filteredWords.length + " special words.");
        return filteredWords;
    }

    private boolean isWordSpecial(Word w) {
        char[] symbols = w.wordToCharArray();
        int vowels = 0, vocales = 0;
        for (int i = 0; i < symbols.length; i++) {
            if (isCharacterVocale(symbols[i]))
                vocales++;
            else
                vowels++;
        }
        return vowels == vocales;
    }

    private boolean isCharacterVocale(char character) {
        if (character == 'a' || character == 'A' ||
                character == 'e' || character == 'E' ||
                character == 'i' || character == 'I' ||
                character == 'o' || character == 'O' ||
                character == 'u' || character == 'U')
            return true;
        return false;
    }


}
