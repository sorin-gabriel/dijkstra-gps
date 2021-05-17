import java.util.ArrayList;

public class WazeMap extends MapGraph {
    /**
     * WazeMap Constructor
     * @param numberOfStreets specifies the number of streets
     * @param numberOfIntersections specifies the number of intersections
     */
    public WazeMap(int numberOfStreets, int numberOfIntersections) {
        super(numberOfStreets, numberOfIntersections);
    }

    @Override
    public void addStreet(String start, String end, int cost, int size) {
        intersections.computeIfAbsent(start,
                k -> new ArrayList<>()).add(new Street(start, end, cost, size));
    }

    @Override
    public void addRestriction(Street.Restriction type,
                               String start, String end, int cost) {
        for (Street street : intersections.get(start)) {
            if (street.getEndIntersection().equals(end)) {
                street.addRestriction(type, cost);
            }
        }
    }

    @Override
    public String drive(Vehicle vehicle, String start, String end) {
        Dijkstra pathfinder = new Dijkstra(intersections);
        pathfinder.dijkstraPath(start, vehicle);
        String result = new String();

        if (pathfinder.pathTo(end) == null
                || pathfinder.pathTo(end).get(0).equals("null")
                || pathfinder.distanceTo(end) == Integer.MAX_VALUE) {
            result = start + " " + end + " " + "null" + "\n";
        } else {
            for (String intersection : pathfinder.pathTo(end)) {
                result += intersection + " ";
            }
            result += pathfinder.distanceTo(end) + "\n";
        }
        return result;
    }
}
