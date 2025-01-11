class Solution {
    public String largestGoodInteger(String num) {
        char temp = 'a';
        int flag = -1;
        char res = 'a';
        int count = 0;
        for(int i = 0;i < num.length();i++){
            if(num.charAt(i) == temp){
                count++;
            }else{
                count = 0;
                temp = num.charAt(i);
            }

            if(count == 2){
                if(Character.getNumericValue(temp) > flag){
                    flag = Character.getNumericValue(temp);
                    res = temp;
                }
            }
        }

        if(flag != -1){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ;j < 3;j++){
                sb.append(res);
            }
            return sb.toString();
            
        }

        return "";
    }
}
