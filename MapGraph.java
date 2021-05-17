import java.util.ArrayList;
import java.util.HashMap;

/**
 * Abstract Map definition
 * Graph is internally represented as a table with entries
 * in the form of key-value pairs, where:
 * key = starting intersection,
 * value = list of streets originating from the starting intersection
 */
public abstract class MapGraph {
    protected int numberOfStreets;
    protected int numberOfIntersections;
    protected HashMap<String, ArrayList<Street>> intersections;

    /**
     * MapGraph Constructor
     * @param numberOfStreets specifies the number of edges
     *                        (streets) in the graph
     * @param numberOfIntersections specifies the number of nodes
     *                              (intersections) in the graph
     */
    protected MapGraph(int numberOfStreets, int numberOfIntersections) {
        this.numberOfStreets = numberOfStreets;
        this.numberOfIntersections = numberOfIntersections;
        this.intersections = new HashMap<>();
    }

    /**
     * Method adds an edge (street) to the internal representation of the graph
     * @param start specifies the starting intersection of the street
     * @param end specifies the ending intersection of the street
     * @param cost specifies the cost associated with driving on the street
     * @param size specifies the size limit of a vehicle driving on the street
     */
    protected abstract void addStreet(String start, String end,
                                      int cost, int size);

    /**
     * Adds a restriction to the street
     * @param type specifies the type of restriction
     * @param start specifies the starting intersection of the street
     * @param end specifies the ending intersection of the street
     * @param cost specifies the cost associated with the restriction
     */
    protected abstract void addRestriction(Street.Restriction type,
                                           String start, String end, int cost);

    /**
     * Finds the optimal path between the specified intersections
     * @param vehicle specifies the vehicle to be driven
     * @param start specifies the starting intersection of the path
     * @param end specifies the ending intersection of the path
     * @return Returns a (String) representation of the optimal path
     */
    protected abstract String drive(Vehicle vehicle, String start, String end);

    /**
     * @return Returns the (int) number of edges (streets) in the graph
     */
    protected int getNumberOfStreets() {
        return numberOfStreets;
    }

    /**
     * @param numberOfStreets specifies the number of edges
     *                        (streets) in the graph
     */
    protected void setNumberOfStreets(int numberOfStreets) {
        this.numberOfStreets = numberOfStreets;
    }

    /**
     * @return Returns the (int) number of nodes (intersections) in the graph
     */
    protected int getNumberOfIntersections() {
        return numberOfIntersections;
    }

    /**
     * @param numberOfIntersections specifies the number of nodes
     *                              (intersections) in the graph
     */
    protected void setNumberOfIntersections(int numberOfIntersections) {
        this.numberOfIntersections = numberOfIntersections;
    }
}
