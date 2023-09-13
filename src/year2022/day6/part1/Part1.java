package year2022.day6.part1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Part1 {

    public void solution() throws IOException {
        int index =0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/year2022/day6/part1/part1"));
        String lines;
        List<Character> characters = new ArrayList<>();
        while ((lines = bufferedReader.readLine()) != null) {
            for (char c : lines.toCharArray()) {
                characters.add(c);
                index++;
                if (characters.size() == 4) {
                    if (characters.stream().distinct().count() == 4) {
                        System.out.println(characters);
                        System.out.println(index);
                        break;
                    } else {
                        characters.remove(0);
                    }
                }
            }

        }



    }

    public static void main(String[] args) throws IOException {
        Part1 part1 = new Part1();
        part1.solution();
    }
}
