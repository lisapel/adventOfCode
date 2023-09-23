package year2018.day2.part1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Part1 {

    void solution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/year2018/day2/part1/input"));
        String line;
        int twoTimes=0;
        int threeTimes=0;

        while ((line = bufferedReader.readLine())!=null){
            Map<Character, Integer> letterCount = new HashMap<>();

            for (char c : line.toCharArray()) {
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            }

            boolean foundTwo = false;
            boolean foundThree = false;

            for (int count : letterCount.values()) {
                if (count == 2 && !foundTwo) {
                    twoTimes++;
                    foundTwo = true;
                } else if (count == 3 && !foundThree) {
                    threeTimes++;
                    foundThree = true;
                }
            }
        }

        int checksum = twoTimes * threeTimes;
        System.out.println("Checksum: " + checksum);
    }









    public static void main(String[] args) throws IOException {
        Part1 part1 = new Part1();
        part1.solution();
    }
}
