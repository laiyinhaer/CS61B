public class Palindrome {
    /** return a Deque where the characters appear in the same order as in the String. */
    public Deque<Character> wordToDeque(String word){
        Deque<Character> res = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++){
            Character alp = word.charAt(i);
            res.addLast(alp);
        }
        return res;
    }

    public boolean isPalindrome(String word){
        Deque<Character> deque = this.wordToDeque(word);
        while(!deque.isEmpty()) {
            if(deque.size() == 1) {return true;}
            if(deque.removeFirst() != deque.removeLast()) {return false;}
        }

        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> deque = this.wordToDeque(word);

        while(!deque.isEmpty()) {
            if(deque.size() == 1) {return true;}
            char comp1 = deque.removeFirst();
            char comp2 = deque.removeLast();
            if(!cc.equalChars(comp1, comp2)) {return false;}
        }
        return true;
    }
}
