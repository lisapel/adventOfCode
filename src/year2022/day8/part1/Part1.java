package year2022.day8.part1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        for (int i = 0; i < integerList.size(); i++) {
            for (int z = integerList.size() - 1; z >= 0; z--) {
                int b = integerList.get(i).stream().toList().subList(z, 99).stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
                visibleCheckEast(integerList.get(i).get(z), z, b);
            }
        }

        for (int i = 0; i < integerList.size(); i++) {
            for (int y = 0; y < integerList.size(); y++) {
                int a = integerList.get(i).stream().toList().subList(0, y).stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
                visibleCheckWest(integerList.get(i).get(y), y, a);
            }
        }


        //all outer-rows are visible
        // the highest trees on each column/row are visible
        // build checkers for east, west
        // build checkers for north, south
    }

    public boolean visibleCheckWest(int x, int xPos, int max) {
        if (xPos == 0) {
            return true;
        } else return x >= max;
    }

    public boolean visibleCheckEast(int x, int xPos, int max) {
        if (xPos == 99) {
            return true;
        } else return x >= max;
    }


    public static void main(String[] args) throws IOException {
        Part1 part1 = new Part1();
        part1.solution();
    }
}
