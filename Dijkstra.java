import java.util.*;

/**
 * Dijkstra implementation using a custom Priority Queue
 */
public class Dijkstra {
    private final HashMap<String, ArrayList<Street>> intersections;
    private final PriorityIntersectionSelector queue;
    private final HashMap<String, LinkedList<String>> paths;
    private final HashMap<String, Integer> distances;

    /**
     * Dijkstra Constructor
     * @param intersections specifies the map (Graph) structure
     */
    public Dijkstra(HashMap<String, ArrayList<Street>> intersections) {
        this.intersections = intersections;
        this.queue = new PriorityIntersectionSelector();
        this.paths = new HashMap<>();
        this.distances = new HashMap<>();

        for (ArrayList<Street> streets : intersections.values()) {
            for (Street street : streets) {
                distances.put(street.getStartIntersection(), Integer.MAX_VALUE);
                distances.put(street.getEndIntersection(), Integer.MAX_VALUE);
            }
        }
    }

    /**
     * Traverses the map (Graph) starting from sourceIntersection and
     * calculates the shortest path to every other node, taking into
     * account the type of vehicle driven
     * @param sourceIntersection specifies the source node
     * @param vehicle specifies the type of vehicle driven
     */
    public void dijkstraPath(String sourceIntersection, Vehicle vehicle) {
        Set<String> processed = new HashSet<>();

        // start traversing the map from sourceIntersection
        distances.put(sourceIntersection, 0);
        paths.computeIfAbsent(sourceIntersection,
                k -> new LinkedList<>()).add(sourceIntersection);
        queue.push(sourceIntersection, 0);

        // continue traversing until there are no more nodes left to consider
        while (!queue.isEmpty()) {
            String currentIntersection = queue.pop();
            if (intersections.get(currentIntersection) != null) {

                // evaluate all streets originating from the current node
                for (Street street : intersections.get(currentIntersection)) {
                    String adjacentIntersection = street.getEndIntersection();
                    int drivingCost = calculateCost(street, vehicle);

                    if (!processed.contains(adjacentIntersection)) {
                        calculateRouteAndCostFromSource(currentIntersection,
                                adjacentIntersection, drivingCost);
                        queue.push(adjacentIntersection,
                                distances.get(adjacentIntersection));
                    }
                }
                processed.add(currentIntersection);
            }
        }
    }

    /**
     * Updates the costs and paths associated with the current and
     * adjacent nodes. If the driving cost is equal to Integer.MAX_VALUE,
     * the street is impassable
     * @param current specifies the current node considered in calculating
     *                the costs and paths
     * @param adjacent specifies an adjacent node of the current node
     * @param drivingCost specifies the cost of driving on the street
     *                    indicated by current and adjacent nodes
     */
    private void calculateRouteAndCostFromSource(String current,
                                    String adjacent, int drivingCost) {
        if (drivingCost != Integer.MAX_VALUE
                && distances.get(current) + drivingCost
                < distances.get(adjacent)) {
            distances.put(adjacent, distances.get(current) + drivingCost);
            LinkedList<String> pathToAdjIntersection;
            if (paths.get(current) != null) {
                pathToAdjIntersection = new LinkedList<>(paths.get(current));
            }
            else pathToAdjIntersection = new LinkedList<>();
            pathToAdjIntersection.add(adjacent);
            paths.put(adjacent, pathToAdjIntersection);
        } else if (distances.get(adjacent) == Integer.MAX_VALUE) {
            LinkedList<String> pathToAdjacentIntersection = new LinkedList<>();
            pathToAdjacentIntersection.add("null");
            paths.put(adjacent, pathToAdjacentIntersection);
        }
    }

    /**
     * @param street specifies the street considered for a path
     * @param vehicle specifies the vehicle that traverses the map (Graph)
     * @return Returns the (int) cost of driving the vehicle on this street
     */
    private int calculateCost(Street street, Vehicle vehicle) {
        int cost = 0;
        if (vehicle.size > street.getSizeLimit()) cost = Integer.MAX_VALUE;
        else {
            cost += vehicle.cost * street.getCost();
            if (street.getRestrictions() != null) {
                for (HashMap<Street.Restriction, Integer> restriction
                        : street.getRestrictions()) {
                    for (int restrictionCost :restriction.values() ) {
                        cost += restrictionCost;
                    }
                }
            }
        }
        return cost;
    }

    /**
     * @return Returns a (HashMap) table containing the paths from
     * a source to each node
     */
    public HashMap<String, LinkedList<String>> getPaths() {
        return paths;
    }

    /**
     * @param destination specifies the destination node
     * @return Returns a (LinkedList) list containing the nodes from
     * a source to the destination node
     */
    public LinkedList<String> pathTo(String destination) {
        return getPaths().get(destination);
    }

    /**
     * @return Returns a (HashMap) table containing the distances from
     * a source to each node
     */
    public HashMap<String, Integer> getDistances() {
        return distances;
    }

    /**
     * @param destination specifies the destination node
     * @return Returns the (int) distance from a source to the destination node
     */
    public int distanceTo(String destination) {
        return getDistances().get(destination);
    }
}
