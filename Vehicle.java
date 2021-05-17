public abstract class Vehicle {
    /**
     * Vehicle types
     */
    protected enum vehicleType {
        Moped,
        Autovehicul,
        Autoutilitar
    }

    /**
     * specifies the type of the vehicle
     */
    protected vehicleType type;

    /**
     * specifies the size of the vehicle
     */
    protected int size;

    /**
     * specifies the cost of the vehicle
     */
    protected int cost;

    /**
     * Vehicle Constructor
     */
    protected Vehicle() {
    }

    /**
     * Vehicle Constructor
     * @param type specifies the type of the vehicle
     * @param size specifies the size of the vehicle
     * @param cost specifies the cost of the vehicle
     */
    protected Vehicle(vehicleType type, int size, int cost) {
        this.type = type;
        this.size = size;
        this.cost = cost;
    }

    /**
     * @return Returns the (int) size of the vehicle
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size specifies the size of the vehicle
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return Returns the (int) cost of the vehicle
     */
    public int getCost() {
        return cost;
    }

    /**
     * @param cost specifies the cost of the vehicle
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * @return Returns the (String) representation of the vehicle
     */
    @Override
    public abstract String toString();
}
