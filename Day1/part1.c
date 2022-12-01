#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
FILE* f = fopen ("ElfCalories.txt", "rb");

int total_calories = 0;
int elf_id = 1;

int size = 10; 
char* line = (char*)malloc(size);

int temp_calories = 0;
int temp_elf_id = 1;

while(getline(&line, &size, f) != EOF) {
 if(atoi(line) != 0) {
  temp_calories += atoi(line);
 } else {
  if(temp_calories > total_calories) {
   total_calories = temp_calories;
   temp_calories = 0;
   elf_id = temp_elf_id++;
  } else {
   temp_calories = 0;
   temp_elf_id++;
  }
 }
}
 return 0;
}