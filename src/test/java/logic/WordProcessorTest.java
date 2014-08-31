package logic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WordProcessorTest {

    private WordProcessor wordProcessor;

    @Before
    public void setUp(){
        wordProcessor = new WordProcessor();
    }

    @Test
    public void splitTextIntoWordsDelimiterIsSpace(){
        Word[] words = wordProcessor.getLatinWords("First Second Third");
        assertThat(words.length, is(3));
        assertThat(words[0].toString(), is("First"));
        assertThat(words[1].toString(), is("Second"));
        assertThat(words[2].toString(), is("Third"));

    }

    @Test
    public void cutsOffNonLatinWords(){
        Word[] words  = wordProcessor.getLatinWords("First Second Third  Пять six");
        assertThat(words.length, is(4));
        assertThat(words[0].toString(), is("First"));
        assertThat(words[1].toString(), is("Second"));
        assertThat(words[2].toString(), is("Third"));
        assertThat(words[3].toString(), is("six"));
    }

    @Test
    public void giveSpecialsWords(){
        Word[] words = wordProcessor.getSpecialWords("First Second Third  Пять six seve");
        assertThat(words.length, is(1));
        assertThat(words[0].toString(), is("seve"));
    }
}
