import java.util.ArrayList;
import java.util.HashMap;

/**
 * Street definition
 */
public class Street {
    private final String startIntersection;
    private final String endIntersection;
    private final int cost;
    private final int sizeLimit;

    /**
     * Restriction types
     */
    public enum Restriction {
        SPEED_LIMIT,
        SIZE_LIMIT,
        ACCIDENT,
        TRAFFIC,
        JAM
    }

    private ArrayList<HashMap<Restriction, Integer>> restrictions;

    /**
     * Street Constructor
     * @param startIntersection specifies the starting intersection of
     *                          the street
     * @param endIntersection specifies the ending intersection of the street
     * @param cost specifies the cost associated with driving on the street
     * @param sizeLimit specifies the size limit of a vehicle driving
     *                  on the street
     */
    public Street(String startIntersection, String endIntersection,
                  int cost, int sizeLimit) {
        this.startIntersection = startIntersection;
        this.endIntersection = endIntersection;
        this.cost = cost;
        this.sizeLimit = sizeLimit;
    }

    /**
     * Adds a restriction to the street
     * @param type specifies the type of restriction
     * @param cost specifies the cost associated with the restriction
     */
    public void addRestriction(Restriction type, int cost) {
        if (restrictions == null) restrictions = new ArrayList<>();
        HashMap<Restriction, Integer> restriction = new HashMap<>();
        restriction.put(type, cost);
        restrictions.add(restriction);
    }

    /**
     * @return Returns the (String) representation of the street
     */
    @Override
    public String toString() {
        return "Street{" +
                "startIntersection='" + startIntersection + '\'' +
                ", endIntersection='" + endIntersection + '\'' +
                ", cost=" + cost +
                ", sizeLimit=" + sizeLimit +
                ", restrictions=" + restrictions +
                '}';
    }

    /**
     * @return Returns the (String) name of the starting intersection
     */
    public String getStartIntersection() {
        return startIntersection;
    }

    /**
     * @return Returns the (String) name of the ending intersection
     */
    public String getEndIntersection() {
        return endIntersection;
    }

    /**
     * @return Returns the (int) cost associated with driving on the street
     */
    public int getCost() {
        return cost;
    }

    /**
     * @return Returns the (int) size limit of a vehicle driving on the street
     */
    public int getSizeLimit() {
        return sizeLimit;
    }

    /**
     * @return Returns an (ArrayList) array of restrictions and their
     * respective cost
     */
    public ArrayList<HashMap<Restriction, Integer>> getRestrictions() {
        return restrictions;
    }
}
