#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
FILE* f = fopen ("ElfCalories.txt", "rb");

int total_calories = 0;

int size = 10; 
char* line;

int temp_calories = 0;

while(getline(&line, &size, f) != EOF) {
 if(atoi(line) != 0) {
  temp_calories += atoi(line);
 } else {
  if(temp_calories > total_calories) {
   total_calories = temp_calories;
   temp_calories = 0;
  } else {
   temp_calories = 0;
  }
 }
}
 return 0;
}