package year2015.day3.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part1 {
    int x = 0;
    int y = 0;
    List<Character> characters = new ArrayList<>();

    public void solution() throws IOException {
        characters = readFile();

        List<String> positions = new ArrayList<>();
        positions.add("0:0");

        for (char c : characters) {
            switch (c) {
                case '^' -> y++;
                case 'v' -> y--;
                case '>' -> x++;
                case '<' -> x--;
            }
            String position = x + ":" + y;
            if (!positions.contains(position)) {
                positions.add(position);
            }


        }
        System.out.println(positions.size());
    }


    public List<Character> readFile() throws IOException {
        List<Character> characters = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/year2015/day3/part1/input"));
        String line = bufferedReader.readLine();
        for (char s : line.toCharArray()) {
            characters.add(s);
        }
        return characters;
    }


    public static void main(String[] args) throws IOException {
        Part1 part1 = new Part1();
        part1.solution();

    }
}


