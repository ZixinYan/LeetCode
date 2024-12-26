#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>
int cmp(const void* a, const void* b) {
    return *(int*)b - *(int*)a;
}
int minimumCost(int m, int n, int* horizontalCut, int horizontalCutSize, int* verticalCut, int verticalCutSize) {
    int h = 1, s = 1;
    qsort(horizontalCut, horizontalCutSize, sizeof(int), cmp);
    qsort(verticalCut, verticalCutSize, sizeof(int), cmp);
    int sum = 0, l = 0, r = 0;
    while (l < horizontalCutSize && r < verticalCutSize) {
        if (horizontalCut[l] >= verticalCut[r]) {
            sum += horizontalCut[l] * s;
            h++;
            l++;
        }
        else if (horizontalCut[l] < verticalCut[r]) {
            sum += verticalCut[r] * h;
            s++;
            r++;
        }
    }
    while (l < horizontalCutSize) {
        sum += horizontalCut[l] * s;
        h++;
        l++;
    }
    while (r < verticalCutSize) {
        sum += verticalCut[r] * h;
        s++;
        r++;
    }
    return sum;
}

int main() {
    int horizontalCut[] = { 1,3 };
    int verticalCut[] = { 5 };
    int m = 3, n = 2;
    int cost = minimumCost(m, n, horizontalCut, 2, verticalCut, 1);

    // 输出结果
    printf("Minimum cost: %d\n", cost);

    return 0;
}
