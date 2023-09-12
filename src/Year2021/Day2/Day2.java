package Year2021.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {

    int depth;
    final String file = "src/Year2021/Day2/input.txt";
    Scanner scanner;
    int horizontal;

    int aim;


    public int part1() throws FileNotFoundException {
        scanner = new Scanner(new File(file));

        while (scanner.hasNextLine()){
            String a = scanner.next();
            if (a.startsWith("f")){
                horizontal += scanner.nextInt();
            }else if(a.startsWith("u")){
                depth -= scanner.nextInt();
            }else{
                depth += scanner.nextInt();
            }
        }
        return horizontal*depth;
    }
    public int part2 () throws FileNotFoundException {
        scanner = new Scanner(new File(file));

        while (scanner.hasNextLine()){
            String a = scanner.next();
            int b = scanner.nextInt();
            if (a.startsWith("f")){
                horizontal += b;
                if (aim!=0){
                    depth = depth + (aim*b);
                }
            }else if(a.startsWith("u")){
                aim -= b;
            }else{
                aim += b;
            }

        }
        return depth*horizontal;
    }

    public static void main(String[] args) throws FileNotFoundException {
       int answer1= new Day2().part1();
       System.out.println(answer1);
       int answer2 = new Day2().part2();
       System.out.println(answer2);
    }
}
