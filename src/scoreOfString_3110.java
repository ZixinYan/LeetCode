class Solution {
    public int scoreOfString(String s){
        int n = s.length();
        int res = 0;
        int left = Character.codePointAt(s, 0);
        for(int i = 1;i < n;i++){
            if(Character.codePointAt(s, i) >= left){
                res += Character.codePointAt(s, i) - left;
            }else{
                res += left - Character.codePointAt(s, i);
            }
            left = Character.codePointAt(s, i);
        }
        return res;
    }
}