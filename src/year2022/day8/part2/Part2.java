package year2022.day8.part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
    final List<List<Integer>> integerList = new ArrayList<>();
    final List<Integer> values = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Part2 part2 = new Part2();
        part2.solution();
    }

    public void solution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/year2022/day8/part2/part2"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            List<Integer> integers = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                integers.add(Integer.parseInt(String.valueOf(line.charAt(i))));
            }
            integerList.add(integers);
        }
        for (int row = 0; row < integerList.size(); row++) { //row
            for (int col = 0; col < integerList.get(row).size(); col++) { //col
                values.add(countTrees(col, row));
            }
        }
        int max = values.stream().sorted().toList().get(values.size() - 1);
        System.out.println(max);

    }

    public int countTrees(int col, int row) {
        return visibleEast(col, row) * visibleNorth(col, row) * visibleWest(col, row) * visibleSouth(col, row);
    }

    public int visibleWest(int col, int row) {
        int count = 0;
        for (int i = col - 1; i >= 0; i--) {
            if (integerList.get(row).get(i) >= integerList.get(row).get(col)) {
                count++;
                return count;
            } else {
                count++;
            }

        }
        return count;
    }

    public int visibleEast(int col, int row) {
        int count = 0;
        for (int i = col + 1; i <= 98; i++) {
            if (integerList.get(row).get(i) >= integerList.get(row).get(col)) {
                count++;
                return count;
            } else {
                count++;
            }

        }
        return count;
    }


    public int visibleNorth(int col, int row) {
        int count = 0;
        for (int i = row - 1; i >= 0; i--) {
            if (integerList.get(i).get(col) >= integerList.get(row).get(col)) {
                count++;
                return count;
            } else {
                count++;
            }

        }
        return count;
    }


    public int visibleSouth(int col, int row) {
        int count = 0;
        for (int i = row + 1; i <= 98; i++) {
            if (integerList.get(i).get(col) >= integerList.get(row).get(col)) {
                count++;
                return count;
            } else {
                count++;
            }

        }
        return count;
    }

}




