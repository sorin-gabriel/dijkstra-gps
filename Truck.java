public class Truck extends Vehicle {
    public Truck() {
        super(vehicleType.Autoutilitar, 3, 6);
    }

    /**
     * Truck Constructor
     * @param size specifies the size of the truck
     * @param cost specifies the cost of the truck
     */
    public Truck(int size, int cost) {
        super(vehicleType.Autoutilitar, size, cost);
    }

    /**
     * @return Returns the (String) representation of the truck
     */
    @Override
    public String toString() {
        return "Truck{" +
                "size=" + size +
                ", cost=" + cost +
                '}';
    }
}
