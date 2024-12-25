#include <stdio.h>
#include <stdlib.h>

struct state {
    int apple;
    int date;
    struct state* nextPtr;
};

typedef struct state state;

void swapValues(state* a, state* b) {
    int tempApple = a->apple;
    int tempDate = a->date;
    a->apple = b->apple;
    a->date = b->date;
    b->apple = tempApple;
    b->date = tempDate;
}

state* compare(state* storage, int i) {
    state* dummyHead = (state*)malloc(sizeof(state));
    dummyHead->nextPtr = storage;
    state* temp = dummyHead;

    while (temp->nextPtr != NULL && temp->nextPtr->nextPtr != NULL) {
        if (temp->nextPtr->date < i || temp->nextPtr->apple == 0) {
            state* toDelete = temp->nextPtr;
            temp->nextPtr = temp->nextPtr->nextPtr;
            free(toDelete); 
        }
        else if (temp->nextPtr->date > temp->nextPtr->nextPtr->date) {
            swapValues(temp->nextPtr, temp->nextPtr->nextPtr);
            temp = temp->nextPtr; 
        }
        else {
            temp = temp->nextPtr;
        }
    }

    state* newHead = dummyHead->nextPtr;
    free(dummyHead);
    return newHead;
}

int eatenApples(int* apples, int applesSize, int* days, int daysSize) {
    int ans = 0;
    state* storage = NULL;
    for (int i = 0; i < applesSize || storage->apple != 0; i++) {
        if (apples[i] > 0) {
            state* st = (state*)malloc(sizeof(state));
            st->apple = apples[i];
            st->date = days[i] + i;
            st->nextPtr = NULL;
            if (storage == NULL) {
                storage = st;
            }
            else {
                state* temp = storage;
                while (temp->nextPtr != NULL) {
                    temp = temp->nextPtr;
                }
                temp->nextPtr = st;
            }
        }
        storage = compare(storage, i);

        if (storage != NULL && storage->apple > 0) {
            storage->apple--;
            ans++;  
        }
    }

    return ans;
}

int main() {
    int apples[] = { 3, 0, 0, 0, 0, 2 };
    int days[] = { 3, 0, 0, 0, 0, 2 };
    printf("%d\n", eatenApples(apples, 6, days, 6)); 
    return 0;
}
