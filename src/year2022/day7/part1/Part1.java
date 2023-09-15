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
                directoryTree.put(arrayList.get(i), new ArrayList<>());
            }
        }
        System.out.println(directoryTree);

        for (int i = 13; i < 957; i++) {
            if (arrayList.get(i).contains("cd")) {
                directoryTree.forEach((k, v) -> {
                    {

                    }
                });
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Part1 p = new Part1();
        p.solution();
    }
}
