import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Task1 {
    public static void main(String[] args) throws IOException {

        // list that holds strings of a file
        List<String> listOfStrings = new ArrayList<String>();
        BufferedReader bf = new BufferedReader(new FileReader("/Users/antonbjornehall/Desktop/Advent calender/Day5/src/info.txt"));
        String line = bf.readLine();
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
        bf.close();

        // storing the data in arraylist to array
        String[] array = listOfStrings.toArray(new String[0]);

        //Create a list with stacks.
        ArrayList<Stack<Character>> stackArrayList = new ArrayList<>();

        stackArrayList.add(new Stack<Character>());
        stackArrayList.add(new Stack<Character>());
        stackArrayList.add(new Stack<Character>());
        stackArrayList.add(new Stack<Character>());
        stackArrayList.add(new Stack<Character>());
        stackArrayList.add(new Stack<Character>());
        stackArrayList.add(new Stack<Character>());
        stackArrayList.add(new Stack<Character>());
        stackArrayList.add(new Stack<Character>());

        int index = 0;
        for (int i = 7; i >= 0; i--) {
            char t[] = array[i].toCharArray();
            for(int z = 1; z <= t.length; z += 4) {
                if(!(t[z] == ' ')) {
                    stackArrayList.get(index).add(t[z]);
                }
                index++;
                if(z == (t.length - 1)) {
                    break;
                }
            }
            index = 0;
        }

        int move = 5, from = 12, to = 17;
        for(int i = 10; i < array.length; i++) {
            String t = extractInt(array[i]);
            String tt[] = t.split(" ");

            ArrayList<Integer> integerList = new ArrayList<>();

            for (int z = 1; z < 4; z++) {
                integerList.add(Integer.parseInt(tt[z]));
            }
            move(integerList, stackArrayList);
        }
        for(int i = 0; i < 9; i++) {
            System.out.println(stackArrayList.get(i).pop());
        }

    }


    static void move(ArrayList<Integer> list, ArrayList<Stack<Character>> stackArrayList) {
        int from = list.get(1) - 1;
        int to = list.get(2) - 1;
        int count = list.get(0);
        ArrayList<Character> t = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            t.add(stackArrayList.get(from).pop());
        }

        for(int i = t.size() - 1; i >= 0; i--) {
            stackArrayList.get(to).add(t.get(i));
        }

    }

    // Function to return the modified string
    static String extractInt(String str)
    {
        // Replacing every non-digit number
        // with a space(" ")
        str = str.replaceAll("[^0-9]", " "); // regular expression

        // Replace all the consecutive white
        // spaces with a single space
        str = str.replaceAll(" +", " ");

        if (str.equals(""))
            return "-1";

        return str;
    }
}

