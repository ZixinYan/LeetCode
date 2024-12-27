#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h> 

bool isSubstringPresent(char* s) {
    bool visit[26][26] = { false };
    for (int i = 1; i < strlen(s); i++) {
        int x = s[i - 1] - 'a'; 
        int y = s[i] - 'a'; 

        visit[x][y] = true; 
        if (visit[y][x]) {  
            return true;  
        }
    }
    return false;  
}

int main() {
    char str[100] = "abcd";
    if (isSubstringPresent(str)) {
        printf("true\n");
    }
    else {
        printf("false\n");
    }
    return 0;
}
