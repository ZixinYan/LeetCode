import java.util.Arrays;

// 采用二维数组来存储每个队伍在每个位置的得票数，然后按照得票数排序，最后返回排序后的队伍。
// 时间复杂度为O(nlogn)，空间复杂度为O(26*n)。
// https://leetcode.com/problems/rank-teams-by-votes/discuss/524854/Java-Solution

public class rankTeams_1366 {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        int[][] rank = new int[26][n + 1];
        for (int i = 0; i < 26; i++) {
            rank[i][n] = i;
        }
        for (String vote : votes) {
            for (int i = 0; i < n; i++) {
                rank[vote.charAt(i) - 'A'][i]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(rank, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) {
                    return b[i] - a[i];
                }
            }
            return a[n] - b[n];
        });
        for (int i = 0; i < n; i++) {
            sb.append((char) (rank[i][n] + 'A'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        rankTeams_1366 rt = new rankTeams_1366();
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        System.out.println(rt.rankTeams(votes));
    }
}