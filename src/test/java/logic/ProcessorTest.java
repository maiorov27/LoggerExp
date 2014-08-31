package logic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProcessorTest {

    public static final String ANY_TEXT = "One onen";
    private Processor processor;
    @Mock
    WordsPrinter printer;
    @Mock
    FileWordsReader fileWordsReader;
    @Mock
    WordProcessor wordProcessor;

    @Before
    public void setUp() {
        processor = new Processor(fileWordsReader, wordProcessor, printer);
        when(fileWordsReader.readText()).thenReturn(ANY_TEXT);
        when(wordProcessor.getLatinWords(ANY_TEXT)).thenReturn(new Word[]{new Word("One"), new Word("onen")});
        when(wordProcessor.getSpecialWords(ANY_TEXT)).thenReturn(new Word[]{new Word("onen")});
    }

    @Test
    public void readsTextFromFileAnalyzeAndPrintsOutput() {
        processor.process();
        verify(printer).printWords(new Word[]{new Word("One"), new Word("onen")});
        verify(printer).printWords(new Word[]{new Word("onen")});
    }
}
