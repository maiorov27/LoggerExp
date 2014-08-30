package logic;

import java.util.ArrayList;

public class WordProcessor {

    public WordProcessor() {

    }

    public Word[] getLatinWords(String text) {
        ArrayList<Word> latinWords = new ArrayList<Word>();
        Word[] words = getWords(text);
        for (int i = 0; i < words.length; i++) {
            if (isLatinWord(words[i])) {
                latinWords.add(words[i]);
            }
        }

        return (Word[]) latinWords.toArray();
    }

    private Word[] getWords(String text) {
        String words[] = text.split(" ");
        Word[] w = new Word[words.length];
        for (int i = 0; i < words.length; i++) {
            w[i] = new Word(words[i]);
        }
        return w;
    }

    private boolean isLatinWord(Word word) {
        char[] symbols = word.wordToCharArray();
        for( int i = 0; i < symbols.length; i++ ){
            if(!isLatinSymbol(symbols[i]))
                return false;
        }
        return true;
    }

    private boolean isLatinSymbol(char c){
        if(( c > 65 && c < 90) || (c > 97 && c < 122))
            return true;
        return false;
    }

    public Word[] getSpecialWords(String text){
        Word words[] = getLatinWords(text);
        ArrayList<Word> specialWord = new ArrayList<Word>();
        for(int i = 0; i < words.length; i++){
            if(isWordSpecial(words[i]))
                specialWord.add(words[i]);
        }
        return words;
    }

    private boolean isWordSpecial(Word w){
        char[] symbols = w.wordToCharArray();
        int vowels = 0, vocales = 0;
        for(int i = 0; i < symbols.length; i++){
            if(isCharacterVocale(symbols[i]))
                vocales++;
            else
                vowels++;
        }
        return vowels == vocales;
    }

    private boolean isCharacterVocale(char character){
        if ( character ==  'a' || character == 'A' ||
                character == 'e' || character == 'E' ||
                character == 'i' || character == 'I' ||
                character == 'o' || character == 'O' ||
                character == 'u' || character == 'U')
            return true;
        return false;
    }


}
