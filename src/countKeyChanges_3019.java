public class countKeyChanges_3019 {
    public int countKeyChanges(String s) {
        int res = 0;
        String temp = s.toLowerCase();
        for(int i = 1;i < s.length();i++){
            if(s.charAt(i) != s.charAt(i - 1)){
                res++;
            }
        }
        return res;
    }
}
