package year2022.day8.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Part1 {
    List<List<Integer>> integerList = new ArrayList<>();

    public void solution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/year2022/day8/part1/part1"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            List<Integer> integers = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                integers.add(Integer.parseInt(String.valueOf(line.charAt(i))));
            }
            integerList.add(integers);
        }
        int counter=0;
        for (int col = 0; col<integerList.size();col++){ //column
            for (int row=0; row<integerList.get(col).size();row++){ //row
                if (isVisible(col,row)){
                    counter++;
                }

            }

        }
        System.out.println(counter);

    }
    public boolean isVisible(int col, int row){
        if (visibleWest(col,row)){
            return true;
        }else if(visibleEast(col,row)){
            return true;
        }else if (visibleSouth(col,row)){
            return true;
        } else return visibleNorth(col, row);
    }

    public boolean visibleWest(int col, int row){
        if (col==0){
            return true;
        }
        for (int i= col -1; i>=0;i--){
            if (integerList.get(row).get(i)>=integerList.get(row).get(col)){
                return false;
            }
        }
        return true;
    }

    public boolean visibleEast(int col, int row){
        if (col==98){
            return true;
        }
        for (int i=col+1;i<=98;i++){
            if (integerList.get(row).get(i)>=integerList.get(row).get(col)){
                return false;
            }
        }
        return true;
    }
    public boolean visibleNorth(int col, int row){
        if (row==0){
            return true;
        }
        for (int i=row-1;i>=0;i--){
            if (integerList.get(col).get(i)>=integerList.get(col).get(row)){
                return false;
            }
        }
        return true;
    }
    public boolean visibleSouth(int col, int row){
        if (row==98){
            return true;
        }
        for (int i=row+1;i<=98;i++){
            if(integerList.get(col).get(i)<=integerList.get(col).get(row)){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) throws IOException {
        Part1 part1 = new Part1();
        part1.solution();
    }
}
