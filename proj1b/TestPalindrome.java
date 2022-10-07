import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String test1 = "";
        String test2 = "a";
        String test3 = "noon";
        String test4 = "horse";
        assertTrue(palindrome.isPalindrome(test1));
        assertTrue(palindrome.isPalindrome(test2));
        assertTrue(palindrome.isPalindrome(test3));
        assertFalse(palindrome.isPalindrome(test4));
    }
//    Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome1(){
        String test1 = "";
        String test2 = "a";
        String test3 = "noon";
        String test4 = "horse";
        assertTrue(palindrome.isPalindrome(test1, cc));
        assertTrue(palindrome.isPalindrome(test2, cc));
        assertTrue(palindrome.isPalindrome(test3, cc));
        assertFalse(palindrome.isPalindrome(test4, cc));
    }

}
