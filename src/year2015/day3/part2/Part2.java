package year2015.day3.part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

    void solution() throws IOException {
        List<Character>characters = readFile();
        List<String> positions = new ArrayList<>();

        int xSanta = 0;
        int ySanta = 0;
        int xRobo = 0;
        int yRobo = 0;
        boolean roboTurn = false;
        String position;

        positions.add("0:0");
        for (char c: characters){
            if(roboTurn){
                switch (c){
                    case '^'->xRobo++;
                    case 'v'->xRobo--;
                    case '>'->yRobo++;
                    case '<'->yRobo--;
                }
                position=xRobo+":"+yRobo;
            }else{
                switch (c){
                    case '^'->xSanta++;
                    case 'v'->xSanta--;
                    case '>'->ySanta++;
                    case '<'->ySanta--;
                }
                position=xSanta+":"+ySanta;
            }
            if (!positions.contains(position)){
                positions.add(position);
            }
            roboTurn=!roboTurn;
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
        Part2 part2 = new Part2();
        part2.solution();
    }
}
