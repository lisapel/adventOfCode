package Year2022.Day1;

import java.io.*;
import java.util.Scanner;

public class ElfCalories {
    void readAndPrintOnFile(){
        String file ="src/Day1/Calories.txt";
        readFile(file);

    }

    public static void readFile(String file) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            int res = 0;
            while ((line = bufferedReader.readLine())!=null){
                if (line.length()>1) {
                    int lineInt = Integer.parseInt(line);
                    res = res + lineInt;
                }else if (line.length()==0){
                    try(FileWriter fileWriter = new FileWriter("res.txt",true)){
                        fileWriter.write(res + "\n");
                        res=0;

                    }

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    int biggestValue() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("res.txt"));
        int big = scanner.nextInt();
        while (scanner.hasNextInt()){
            int num = scanner.nextInt();
            if (num>big){
                big=num;
            }

        }
        return big;

    }




    public static void main(String[] args) throws IOException {
        ElfCalories elfCalories = new ElfCalories();
        elfCalories.readAndPrintOnFile();
        int biggest = elfCalories.biggestValue();
        System.out.println(biggest);
    }}


