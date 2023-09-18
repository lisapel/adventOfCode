package year2022.day8.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Part1 {
    public void solution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/year2022/day8/part1/part1"));
        List<List<Integer>> integerList = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            List<Integer> integers = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                integers.add(Integer.parseInt(String.valueOf(line.charAt(i))));
            }
            integerList.add(integers);
        }
        List<List<Integer>> transformedList = transportMatrix(integerList);

        for (int i = 0; i < integerList.size(); i++) {
            for (int z = integerList.size() - 1; z >= 0; z--) {
                int b = integerList.get(i).stream().toList().subList(z, 99).stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
                visibleCheckEastAndSouth(integerList.get(i).get(z), z, b);
            }
        }

        for (int i = 0; i < integerList.size(); i++) {
            for (int y = 0; y < integerList.size(); y++) {
                int a = integerList.get(i).stream().toList().subList(0, y).stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
                visibleCheckWestAndNorth(integerList.get(i).get(y), y, a);
            }
        }
        for (int i = 0; i < transformedList.size(); i++) {
            for (int y = 0; y < transformedList.size(); y++) {
                int a = transformedList.get(i).stream().toList().subList(0, y).stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
                visibleCheckWestAndNorth(transformedList.get(i).get(y), y, a);
            }
        }
        for (int i=0;i<transformedList.size();i++){
            for (int z=transformedList.size()-1;z>=0;z--){
                int b = integerList.get(i).stream().toList().subList(z, 99).stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
                System.out.println(visibleCheckEastAndSouth(integerList.get(i).get(z), z, b));

            }
        }

    }


    public boolean visibleCheckWestAndNorth(int x, int xPos, int max) {
        if (xPos == 0) {
            return true;
        } else return x >= max;
    }

    public boolean visibleCheckEastAndSouth(int x, int xPos, int max) {
        if (xPos == 99) {
            return true;
        } else return x >= max;
    }

    public List<List<Integer>> transportMatrix(List<List<Integer>> integerList) {
        int numRows = integerList.get(0).size();
        int numCols = integerList.size();
        List<List<Integer>> transposed = new ArrayList<>(numRows);

        for (int row = 0; row < numRows; row++) {
            List<Integer> newRow = new ArrayList<>(numCols);
            for (List<Integer> list : integerList) {
                newRow.add(list.get(row));
            }
            transposed.add(newRow);
        }
        return transposed;
    }


    public static void main(String[] args) throws IOException {
        Part1 part1 = new Part1();
        part1.solution();
    }

}
