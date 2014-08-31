package logic;

public class Word {
    private final String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof Word))
            return false;
        if (o == this)
            return true;
        Word that = (Word) o;
        return that.word == this.word;
    }

    public int hashCode() {
        int result = 31 * 2 + word.hashCode();
        return result;
    }

    public String toString() {
        return word;
    }

    public char[] wordToCharArray() {
        return word.toCharArray();
    }

}
