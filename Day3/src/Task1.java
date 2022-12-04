import java.io.*;
import java.util.ArrayList;

public class Task1 {


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
                char[] ch = line.toCharArray();
                int length = line.length() / 2;
                comp1 = comp1.copyValueOf(ch, 0, length);
                comp2 = comp2.copyValueOf(ch, length, length);
                for(char c : comp1.toCharArray()) {
                    for(char v : comp2.toCharArray()) {
                        if(c == v) {
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
