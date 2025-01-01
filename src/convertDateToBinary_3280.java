// 简单题简单做系列，给定一个日期字符串，格式为"YYYY-MM-DD"，将其转换为二进制格式，返回转换后的字符串。
// java自己就有这个转换的方法，所以也没啥难度乐
// 时间复杂度为O(1)，空间复杂度为O(1)。
// https://leetcode.com/problems/convert-date-to-binary/discuss/1009806/Java-1-liner

public class convertDateToBinary_3280 {
    public String convertDateToBinary(String date) {
        String[] dateArray = date.split("-");
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);
        String yearBinary = Integer.toBinaryString(year);
        String monthBinary = Integer.toBinaryString(month);
        String dayBinary = Integer.toBinaryString(day);
        return yearBinary + "-" + monthBinary + "-" + dayBinary;
    }

    public static void main(String[] args) {
        convertDateToBinary_3280 cdtb = new convertDateToBinary_3280();
        String date = "2021-10-01";
        System.out.println(cdtb.convertDateToBinary(date));
    }
}
