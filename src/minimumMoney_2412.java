import java.util.PriorityQueue;
// 计算最小，所以不需要计算赚钱的方案，所以把 cost < cashback 的方案排除掉
// 然后把亏钱的方案都加在一起
// 最后会有一部分，如果是盈利的话就需要加上cost满足这次交易的进行（只需要加上最小的就可以了）
//              如果全是亏损交易的话，因为亏钱的计算已经把他加进去了，但是这次执行其实只需要满足cost就可以了，所以需要把最后一次的cashback加回来

public class minimumMoney_2412 {
    public static long minimumMoney(int[][] transactions) {
        int res = 0;
        long count = 0;
        for(int tp[] : transactions){
            count += Math.max(tp[0] - tp[1], 0);
            res = Math.max(res, Math.min(tp[0], tp[1]));
        }
        return res + count;
    }

    public static void main(String[] args) {
        int [][] transactions = new int[][]{
                {2,1},
                {5,0},
                {4,2},
        };
        System.out.println(minimumMoney(transactions));
    }
}
