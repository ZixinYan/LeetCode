// 简单题简单做了
// 时间复杂度O(n^2)，空间复杂度O(1)
// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/discuss/1009806/Java-Simple-Brute-Force
public class isSubstringPresent_3083 {
    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    public boolean isSubstringPresent(String s) {
        String s2 = reverse(s);
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == (s.charAt(i+1))) {
                return true;
            }else{
                for(int j= 0; j < s.length()-1;j++){
                    if(s.substring(i,i+2).equals(s2.substring(j,j+2))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        isSubstringPresent_3083 isp = new isSubstringPresent_3083();
        System.out.println(isp.isSubstringPresent("leafbcaef" ));

    }
}
