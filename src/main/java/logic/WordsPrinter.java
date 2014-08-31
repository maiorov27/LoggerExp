package logic;

public class WordsPrinter {

    public void printWords(Word[] words){
        for(int i = 0; i < words.length; i++){
            System.out.println("#"+ i + ". " +words[i] + " ");
        }
    }
}
