import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualsChars(){
        Character char1 = 'x';
        Character char2 = 'y';
        Character char3 = 'x';
        assertTrue(offByOne.equalChars(char1, char3));
        assertFalse(offByOne.equalChars(char1,char2));
    }


    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. *
}
