public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        Deque<Character> list = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            list.addLast(word.charAt(i));
        }
        return list;
    }

    public boolean isPalindrome(String word){
        Deque<Character> dq = wordToDeque(word);
        return isPalindrome(dq);
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        int length = word.length();
        for (int i=0; i< length/2; i++){
            if (!cc.equalChars(word.charAt(i), word.charAt(length - i - 1))){
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(Deque<Character> dq){
        if (dq.isEmpty()||dq.size()==1){
            return true;
        }
        if (dq.removeFirst() != dq.removeLast()){
            return false;
        }

        return isPalindrome(dq);
    }
}
