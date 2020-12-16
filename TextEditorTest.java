import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

public class TextEditorTest {
    private static final TextEditor editor = new TextEditor();
    private static final String data = "Ivan is very beautiful.\nStoyan is piece of shit.\n\nVlado is SAP guru.";

    @Test
    public void testSwapTwoRows() throws IOException {
        String expected = "\nStoyan is piece of shit.\nIvan is very beautiful.\nVlado is SAP guru.";
        String actual = editor.swapTwoRows(2, 0, new StringReader(data));

        assertEquals(expected, actual);
    }

    @Test
    public void testSwapTwoWordsOnDifferentRows() throws IOException {
        String expected = "Stoyan is very beautiful.\nIvan is piece of shit.\n\nVlado is SAP guru.";
        String actual = editor.swapTwoWords(0, 0, 1, 0, new StringReader(data));

        assertEquals(expected, actual);
    }

    @Test
    public void testSwapTwoWordsOnSameRows() throws IOException {
        String expected = "very is Ivan beautiful.\nStoyan is piece of shit.\n\nVlado is SAP guru.";
        String actual = editor.swapTwoWords(0, 0, 0, 2, new StringReader(data));

        assertEquals(expected, actual);
    }
}