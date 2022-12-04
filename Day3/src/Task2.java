import java.io.*;
import java.util.ArrayList;

public class Task2 {


    // Priority a through z have priorities 1 through 26.
    // Priority A through Z have priorities 27 through 52.

    /**
     * 1. take length of one row / 2 - got two items
     * 2. Start to scan the both components if they have same letter.
     *
     *
     *
     *
     * */



    public static void main(String args[]) {
        try
        {
            File file=new File("/Users/antonbjornehall/Desktop/Advent calender/Day3/src/info.txt");    //creates a new file instance
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
            String line;

            String comp1 = null, comp2 = null;
            //Lower case -96
            //Upper case Assci - 64 + 26
            int sum = 0;
            boolean found = false;
            while((line=br.readLine())!=null)
            {
                char[] r1 = line.toCharArray();
                char[] r2 = (br.readLine()).toCharArray();
                char[] r3 = (br.readLine()).toCharArray();

                for(char c : r1) {
                    for(char v : r2) {
                        for(char x : r3) {
                            if(c == v && v == x) {
                                int value = c;
                                if(value >= 97 && value <= 122) {
                                    //Lower case
                                    sum += (value - 96);
                                    found = true;
                                    break;
                                } else if (value >= 65 && value <= 90) {
                                    //Upper case
                                    sum += ((value - 64) + 26);
                                    found = true;
                                    break;
                                }
                            }
                        }
                        if(found) {
                            break;
                        }
                    }
                    if(found) {
                        found = false;
                        break;
                    }
                }

            }
            System.out.println(sum);
            fr.close();    //closes the stream and release the resources
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
