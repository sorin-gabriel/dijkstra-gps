import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(new File("map.in"));
        FileWriter output = new FileWriter("map.out");

        // Initialize a new map
        WazeMap map = new WazeMap(s.nextInt(), s.nextInt());
        for (int i = 0; i < map.numberOfStreets; i++) {
            map.addStreet(s.next(), s.next(), s.nextInt(), s.nextInt());
        }

        // Parse all the events (driving requests, restrictions)
        while (s.hasNext()) {
            switch (s.next()) {
                case "drive" -> {
                    switch (s.next()) {
                        case "a" -> output.write(map.drive(new Car(),
                                s.next(), s.next()));
                        case "b" -> output.write(map.drive(new Bicycle(),
                                s.next(), s.next()));
                        case "c" -> output.write(map.drive(new Truck(),
                                s.next(), s.next()));
                        case "m" -> output.write(map.drive(new Motorcycle(),
                                s.next(), s.next()));
                    }
                }
                case "accident" -> map.addRestriction(
                        Street.Restriction.ACCIDENT, s.next(),
                        s.next(), s.nextInt());
                case "trafic" -> map.addRestriction(
                        Street.Restriction.TRAFFIC, s.next(),
                        s.next(), s.nextInt());
                case "blocaj" -> map.addRestriction(
                        Street.Restriction.JAM, s.next(),
                        s.next(), s.nextInt());
            }
        }
        s.close();
        output.close();
    }
}
