public class Bicycle extends Vehicle {
    public Bicycle() {
        super(vehicleType.Moped, 1, 1);
    }

    /**
     * Bicycle Constructor
     * @param size specifies the size of the bicycle
     * @param cost specifies the cost of the bicycle
     */
    public Bicycle(int size, int cost) {
        super(vehicleType.Moped, size, cost);
    }

    /**
     * @return Returns the (String) representation of the bicycle
     */
    @Override
    public String toString() {
        return "Bicycle{" +
                "size=" + size +
                ", cost=" + cost +
                '}';
    }
}
