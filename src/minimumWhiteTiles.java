public class minimumWhiteTiles_2209 {
        static final int INF = 0x3f3f3f3f;

        public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
            int n = floor.length();
            // 第一项记录已经计算到的地砖位置，第二项记录使用过的地毯数量
            int[][] d = new int[n + 1][numCarpets + 1];
            // init
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= numCarpets; j++) {
                    d[i][j] = INF;
                }
            }
            // 没有地砖的时候一定可以被覆盖，赋值为0
            for (int j = 0; j <= numCarpets; j++) {
                d[0][j] = 0;
            }
            // 遍历数组，赋值没有地毯覆盖的情况下每个位置里白色地砖的数量
            for (int i = 1; i <= n; i++) {
                d[i][0] = d[i - 1][0] + (floor.charAt(i - 1) == '1' ? 1 : 0);
            }
            // 计算重叠子问题，在当前位置放地毯能不能减少白色覆盖
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= numCarpets; j++) {
                    // 首先计算当前状态白色地砖数量
                    d[i][j] = d[i - 1][j] + (floor.charAt(i - 1) == '1' ? 1 : 0);
                    // 计算当前位置放地毯后的白色砖块
                    // 首先读取没放当前地毯的时候剩余白色数量，然后比较与当前状态剩余白色数量，更新当前状态
                    d[i][j] = Math.min(d[i][j], d[Math.max(0, i - carpetLen)][j - 1]);
                }
            }
            // 结果为遍历到最后的大小
            return d[n][numCarpets];
        }
}
