#include <iostream>
#include <sstream>
#include <fstream>
#include <filesystem>

// 6 of win
// 3 for draw

// 2 for papper
// 1 for rock
// 3 for scissor

int get_points_standard(char a) {
 if(a == 'X') {
  return 1;
 } else if(a == 'Y') {
  return 2;
 } else if(a == 'Z') {
  return 3;
 }
 return 0;
}

//Y = papper, X = rock, Z = siccor MY

// A = rock, B = papper, C == siccors OPPONENT
int main() {
    std::ifstream infile("score.txt");
    std::string line;
    int total_points = 0;
    while ((std::getline(infile, line))) {
        std::cout << line << std::endl;
        std::cout << total_points << std::endl;
        //Draw
        if(line[0] == 'A' && line[2] == 'X' ||
           line[0] == 'B' && line[2] == 'Y' ||
           line[0] == 'C' && line[2] == 'Z') {
          total_points += get_points_standard(line[2]);
          total_points += 3;
        } else if(line[0] == 'A') {
         //Opponent rock
         if(line[2] == 'Y') {
          total_points += get_points_standard(line[2]);
          total_points += 6;
         } else {
          total_points += get_points_standard(line[2]);
         }
        } else if(line[0] == 'B') {
          if(line[2] == 'Z') {
          total_points += get_points_standard(line[2]);
          total_points += 6;
         } else {
          total_points += get_points_standard(line[2]);
         }
        } else if(line[0] == 'C') {
          if(line[2] == 'X') {
          total_points += get_points_standard(line[2]);
          total_points += 6;
         } else {
          total_points += get_points_standard(line[2]);
         }
        }
    }
    std::cout << total_points << std::endl;
    return 0;
}