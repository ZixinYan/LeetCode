public class evenOddBit_2595 {
    /* 直接实现
    public int[] evenOddBit(int n) {
        int even = 0;
        int odd = 0;
        String binary = toBinary(n);
        for(int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) == '1') {
                if(i%2 == 0) {
                    even++;
                }else{
                    odd++;
                }
            }
        }
        return new int[]{even, odd};
    }

    public static String toBinary(int n){
        StringBuilder s = new StringBuilder();
        while (n > 0) {
            int remainder = n % 2;
            s.insert(0, remainder);
            n /= 2;
        }

        return s.reverse().toString();
    }

     */

    // 位运算
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        int i = 0;
        while (n > 0) {
            res[i] += n & 1;
            n >>= 1;
            i ^= 1;
        }
        return res;
    }

}
