#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void swap(int* xp, int* yp);
void bubbleSort(int arr[], int n);

int main() {
FILE* f = fopen ("ElfCalories.txt", "rb");
int size = 10;
char* line = (char*)malloc(size);

int temp_calories = 0;
int top_three[3] = {0};

while(getline(&line, &size, f) != EOF) {
 if(atoi(line) != 0) {
  temp_calories += atoi(line);
 } else {
  if(top_three[0] == 0) {
   top_three[0] = temp_calories;
   temp_calories = 0;
  } else if(top_three[1] == 0) {
    top_three[1] = temp_calories;
    temp_calories = 0;
  } else if(top_three[2] == 0) {
    top_three[2] = temp_calories;
    temp_calories = 0;
  } else {
   for(int i = 0; i < 3; i++) {
    if(temp_calories > top_three[i]) {
     top_three[i] = temp_calories;
     temp_calories = 0;
     break;
    }
   }
   temp_calories = 0;
  }
   bubbleSort(top_three, 3);
 }
}
int total = 0;
 for(int i = 0; i < 3; i++) {
  total += top_three[i];
 }
 return 0;
}

void swap(int* xp, int* yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}
// A function to implement bubble sort
void bubbleSort(int arr[], int n)
{
    int i, j;
    for (i = 0; i < n - 1; i++)
 
        // Last i elements are already in place
        for (j = 0; j < n - i - 1; j++)
            if (arr[j] > arr[j + 1])
                swap(&arr[j], &arr[j + 1]);
}

