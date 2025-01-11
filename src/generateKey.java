public class generateKey {
    public static int generateKey(int num1, int num2, int num3) {
        String strNum1 = String.format("%04d", num1);
        String strNum2 = String.format("%04d", num2);
        String strNum3 = String.format("%04d", num3);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int digit1 = Character.getNumericValue(strNum1.charAt(i));
            int digit2 = Character.getNumericValue(strNum2.charAt(i));
            int digit3 = Character.getNumericValue(strNum3.charAt(i));
            result.append(Math.min(digit1, Math.min(digit2, digit3)));
        }
        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 10;
        int num3 = 1000;
        String strNum1 = String.format("%04d", num1);
        String strNum2 = String.format("%04d", num2);
        String strNum3 = String.format("%04d", num3);

        System.out.println("num1" + strNum1);
        System.out.println("num2" + strNum2);
        System.out.println("num3" + strNum3);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int digit1 = Character.getNumericValue(strNum1.charAt(i));
            int digit2 = Character.getNumericValue(strNum2.charAt(i));
            int digit3 = Character.getNumericValue(strNum3.charAt(i));
            result.append(Math.min(digit1, Math.min(digit2, digit3)));
        }
        System.out.println(Integer.parseInt(result.toString()));
    }
}
