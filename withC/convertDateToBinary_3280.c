void intToBinary(unsigned int n, char* binaryStr) {
    int index = 0;
    if (n == 0) {
        binaryStr[index++] = '0';
    } else {
        for (int i = 31; i >= 0; i--) {
            if ((n & (1U << i)) != 0 || index > 0) {
                binaryStr[index++] = (n & (1U << i)) ? '1' : '0';
            }
        }
    }
    binaryStr[index] = '\0';  
}

const char* convertDateToBinary(const char* date) {
    int year, month, day;
    static char result[100];
    char binaryYear[33], binaryMonth[33], binaryDay[33];
    sscanf(date, "%d-%d-%d", &year, &month, &day);
    intToBinary((unsigned int)year, binaryYear);
    intToBinary((unsigned int)month, binaryMonth);
    intToBinary((unsigned int)day, binaryDay);
    sprintf(result, "%s-%s-%s", binaryYear, binaryMonth, binaryDay);
    return result;
}
