package Day2;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Day2 {
    public static void main(String[] args) throws IOException {
        //Part One
        BufferedReader reader = new BufferedReader(new FileReader("Day2/day_two.txt"));

        ArrayList<Coordinates> coordinates = new ArrayList<>();

        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            String direction = parts[0];
            int amount = Integer.parseInt(parts[1]);

            Coordinates coor = new Coordinates(direction, amount);
            coordinates.add(coor);
        }
        reader.close();

        AtomicInteger depth = new AtomicInteger();
        AtomicInteger horizontal = new AtomicInteger();

        coordinates.forEach(coor -> {
            if (Objects.equals(coor.getDirection(), "down")) {
                depth.addAndGet(coor.getAmount());
            } else if (Objects.equals(coor.getDirection(), "up")) {
                depth.addAndGet(-coor.getAmount());
            } else {
                horizontal.addAndGet(coor.getAmount());
            }
        });

        int result = depth.get() * horizontal.get();
        System.out.println("Submarine coordinates: " + "\n-> Horizontal: " + horizontal + "\n-> Depth: " + depth + "\n\nEnd result: " + result);

        //Part Two
        AtomicInteger horizontal2 = new AtomicInteger();
        AtomicInteger aim = new AtomicInteger();
        AtomicInteger currentHorizontal = new AtomicInteger();
        AtomicInteger position = new AtomicInteger();

        coordinates.forEach(coor -> {
            if (Objects.equals(coor.getDirection(), "down")) {
                aim.addAndGet(coor.getAmount());
            } else if (Objects.equals(coor.getDirection(), "up")) {
                aim.addAndGet(-coor.getAmount());
            } else {
                currentHorizontal.set(coor.getAmount());
                horizontal2.addAndGet(coor.getAmount());

                position.set(position.get() + (aim.get() * currentHorizontal.get()));
            }
        });

        int result2 = position.get() * horizontal2.get();
        System.out.println("\nSubmarine coordinates: " + "\n-> Horizontal: " + horizontal2 + "\n-> Depth: " + position + "\n\nEnd result: " + result2);
    }
}