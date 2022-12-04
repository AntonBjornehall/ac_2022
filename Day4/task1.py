import array


def lowest_number(number_row):
 arr = []
 for x in range(number_row[0], number_row[1] + 1):
  arr.append(x)
 return arr


def pair_or_not(arr1, arr2):
 if len(arr1) > len(arr2):
  if all(x in arr1 for x in arr2):
   return 1
 else:
  if all(x in arr2 for x in arr1):
   return 1
 return 0



def main():
 file = open('task.txt', 'r')
 count = 0
 while True:
  full_ass = file.readline()
  full_ass.replace('-',',')
  if not full_ass:
   break

  one_ass = full_ass.split(',')
   
  first_ass_numbers = one_ass[0].split('-')
  seconde_ass_numbers = one_ass[1].split('-')
   
  f_a_n = [int(numeric_string) for numeric_string in first_ass_numbers]
  s_a_n = [int(numeric_stringg) for numeric_stringg in seconde_ass_numbers]

  arr1 = lowest_number(f_a_n)
  arr2 = lowest_number(s_a_n)

  count += pair_or_not(arr1, arr2)
  print(count)

if __name__=='__main__':
 main()