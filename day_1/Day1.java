package day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        //Part One
        Scanner sc = new Scanner(new File("day_1/day_one.txt"));
        ArrayList<Integer> coors = new ArrayList<>();
        int counter = 0;

        while (sc.hasNextInt()) {
            coors.add(sc.nextInt());
        }

        for (int i = 0; i < coors.size() - 1; i++) {
            if (coors.get(i) < coors.get(i + 1)) {
                counter++;
            }
        }
        System.out.println("There are " + counter + " measurements that larger than the previous measurement.");

        //Part Two
        Scanner sc2 = new Scanner(new File("day_1/day_one_p2.txt"));
        ArrayList<Integer> coors2 = new ArrayList<>();
        int counter2 = 0;
        while (sc2.hasNextInt()) {
            coors2.add(sc2.nextInt());
        }

        for (int i = 0; i < coors2.size() - 3; i++) {
            if (coors2.get(i) + coors2.get(i + 1) + coors2.get(i + 2) < coors2.get(i + 1) + coors2.get(i + 2) + coors2.get(i + 3)) {
                counter2++;
            }
        }
        System.out.println("\nThere are " + counter2 + " measurements that larger than the previous measurement.");
    }
}