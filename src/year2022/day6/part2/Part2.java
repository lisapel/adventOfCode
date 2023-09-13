package year2022.day6.part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

    public void solution() throws IOException {
        int index =0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/year2022/day6/part2/part2"));
        String lines;
        List<Character> characters = new ArrayList<>();
        while ((lines = bufferedReader.readLine()) != null) {
            for (char c : lines.toCharArray()) {
                characters.add(c);
                index++;
                if (characters.size() == 14) {
                    if (characters.stream().distinct().count() == 14) {
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
        Part2 part1 = new Part2();
        part1.solution();
    }
}
