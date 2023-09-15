package year2022.day7.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Part1 {

    /*
    cd x current directory -> to x directory
    cd .. current directory -> parent of current directory
    cd / current directory -> root directory
    ls lists all the items in current directory
    dir xyz current directory has a directory namned xyz
    123 abc current direcgtory has a file 'abc' with size 123
    * */

    public void solution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/year2022/day7/part1/part1"));
        String line;
        ArrayList<String> arrayList = new ArrayList<>();
        Map<String, List<Integer>> directoryTree = new HashMap<>();
        while ((line = bufferedReader.readLine()) != null) {
            arrayList.add(line);

        }
        for (int i = 0; i < 13; i++) {
            if (arrayList.get(i).contains("dir")) {
                String substring = arrayList.get(i).substring(4);
                directoryTree.put(substring, new ArrayList<>());
            }
        }
        System.out.println(directoryTree);

        for (int i = 13; i < 956; i++) {
            if (arrayList.get(i).contains("cd")) {
               String substring = arrayList.get(i).substring(5);
               if (directoryTree.containsKey(substring)){
                  //add values to integer-list for  key
                  // directoryTree.get(substring).add(arrayList.get(i)+2);
                   System.out.println(directoryTree);
               }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Part1 p = new Part1();
        p.solution();
    }
}
