package year2022.day5.part2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crates2 {
    public static void main(String[] args) {
        int lines = 0;
        int quantity = 0;
        int from = 0;
        int to = 0;
        List<List<Character>> stacks = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            List<Character> deque = new ArrayList<>();
            stacks.add(deque);
        }
        try (BufferedReader bufferedReader = new BufferedReader
                (new FileReader("C:\\Users\\lisap\\IdeaProjects\\AdventOfCode\\src\\Year2022\\Day5\\CratesFile"))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                if (lines < 8) {
                    int index = 0;
                    for (int i = 1; i < line.length(); i += 4) {
                        if (line.charAt(i) != ' ') {
                            stacks.get(index).add(line.charAt(i));
                        }
                        index++;
                        if (index > 8) {
                            index = 0;
                        }
                    }
                } else if (lines > 9) {
                    int counter = 0;
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {

                        switch (counter) {
                            case 0 -> quantity = Integer.parseInt(matcher.group());
                            case 1 -> from = Integer.parseInt(matcher.group());
                            case 2 -> to = Integer.parseInt(matcher.group());
                        }
                        counter++;
                    }

                    ArrayList<Character>characters = new ArrayList<>();
                    for (int x = 0; x < quantity; x++) {
                            characters.add(stacks.get(from-1).get(0));
                            stacks.get(from-1).remove(0);
                    }
                    stacks.get(to-1).addAll(0,characters);
                }
                line = bufferedReader.readLine();
                lines++;
            }
            StringBuilder result = new StringBuilder();
            for (List<Character> stack : stacks) {
                result.append(stack.get(0));
            }
            System.out.println(result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
