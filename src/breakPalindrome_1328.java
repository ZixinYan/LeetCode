public class breakPalindrome_1328 {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()<=1) return "";
        char[] chars = palindrome.toCharArray();
        int mid = palindrome.length()/2;
        for(int i=0; i<mid; i++){
            if(chars[i] != 'a'){
                chars[i] = 'a';
                return new String(chars);
            }
        }

        chars[chars.length-1] = 'b';
        return new String(chars);

    }
}
