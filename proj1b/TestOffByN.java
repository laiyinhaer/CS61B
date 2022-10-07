import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offBy5 = new OffByN(5);
    @Test
    public void testEqualChars(){

        char char1 = 'a';
        char char2 = 'f';
        char char3 = 'h';

        assertTrue(offBy5.equalChars(char1, char2));
        assertTrue(offBy5.equalChars(char2, char1));
        assertFalse(offBy5.equalChars(char2, char3));
     }

}
