import java.util.Arrays;

public class Allocator_2502 {
    int[] MEMORY_TABLE;
    public Allocator_2502(int n) {
        MEMORY_TABLE = new int[n];
        Arrays.fill(MEMORY_TABLE, 0);
    }

    public int allocate(int size, int mID) {
        int count = 0;
        for(int i = 0; i < MEMORY_TABLE.length; i++){
            if(MEMORY_TABLE[i] != 0){
                count = 0;
            }else {
                ++count;
                if (size == count) {
                    for (int j = i - count + 1; j <= i; j++) {
                        MEMORY_TABLE[j] = mID;
                    }
                    return i - count + 1;
                }
            }
        }
        return -1;
    }

    public int freeMemory(int mID) {
        int count = 0;
        for(int i = 0; i < MEMORY_TABLE.length; i++){
            if(MEMORY_TABLE[i] == mID){
                MEMORY_TABLE[i] = 0;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Allocator_2502 allocator = new Allocator_2502(10);
        System.out.println(allocator.allocate(1, 1));
        System.out.println(allocator.allocate(1, 2));
        System.out.println(allocator.allocate(1, 3));
        System.out.println(allocator.freeMemory(2));
        System.out.println(allocator.allocate(3, 4));
        System.out.println(allocator.allocate(1, 1));
        System.out.println(allocator.allocate(1, 1));
        System.out.println(allocator.freeMemory(1));
        System.out.println(allocator.allocate(10, 2));
        System.out.println(allocator.freeMemory(7));
    }
}
