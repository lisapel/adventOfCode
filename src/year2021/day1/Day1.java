package year2021.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {
    int counter;
    final String file = "src/Year2021/Day1/input.txt";
    Scanner scanner;
    final List<Integer> arrayList = new ArrayList<>();

    public int part1 () throws FileNotFoundException {
        scanner = new Scanner(new File(file));
        counter=0;

        while (scanner.hasNextInt()){
           arrayList.add(scanner.nextInt());
        }
        for (int i =0 ;i<arrayList.size() -1;i++){
            if (arrayList.get(i) < arrayList.get(i+1)){
                counter++;
            }
        }
       return counter;
    }
    public int part2 () throws FileNotFoundException {
        scanner = new Scanner(new File(file));
        while (scanner.hasNextInt()){
            arrayList.add(scanner.nextInt());
        }
        for(int i =0;i<arrayList.size()-3;i++){
          if (arrayList.get(i)+arrayList.get(i+1)+arrayList.get(i+2)<
                  arrayList.get(i+1)+arrayList.get(i+2)+arrayList.get(i+3)){
              counter++;
          }
        }
        return counter;
    }

}
