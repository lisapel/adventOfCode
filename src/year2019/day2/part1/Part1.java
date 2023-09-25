package year2019.day2.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part1 {

    void solution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/year2019/day2/part1/input"));
        String line;
        List<Integer> integerList = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] integerStrings = line.split(",");
            for (String integer : integerStrings) {
                integerList.add(Integer.parseInt(integer));
            }
        }
        integerList.set(1, 12);
        integerList.set(2, 2);

        int i = 0;
        while (i < integerList.size()) {
            int opcode = integerList.get(i);
            if (opcode == 1 || opcode == 2) {
                int operand1 = integerList.get(i + 1);
                int operand2 = integerList.get(i + 2);
                int resultIndex = integerList.get(i + 3);
                if (opcode == 1) {
                    integerList.set(resultIndex, integerList.get(operand1) + integerList.get(operand2));
                } else {
                    integerList.set(resultIndex, integerList.get(operand1) * integerList.get(operand2));
                }
                i += 4;
            } else if (opcode == 99) {
                System.out.println(integerList.get(0));
                break;
            }
        }


    }

    public static void main(String[] args) throws IOException {
        Part1 part1 = new Part1();
        part1.solution();
    }
}
