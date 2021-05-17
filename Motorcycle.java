public class Motorcycle extends Vehicle {
    public Motorcycle() {
        super(vehicleType.Moped, 1, 2);
    }

    /**
     * Motorcycle Constructor
     * @param size specifies the size of the motorcycle
     * @param cost specifies the cost of the motorcycle
     */
    public Motorcycle(int size, int cost) {
        super(vehicleType.Moped, size, cost);
    }

    /**
     * @return Returns the (String) representation of the motorcycle
     */
    @Override
    public String toString() {
        return "Motorcycle{" +
                "size=" + size +
                ", cost=" + cost +
                '}';
    }
}
