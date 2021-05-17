public class Car extends Vehicle {
    public Car() {
        super(vehicleType.Autovehicul, 2, 4);
    }

    /**
     * Car Constructor
     * @param size specifies the size of the car
     * @param cost specifies the cost of the car
     */
    public Car(int size, int cost) {
        super(vehicleType.Autovehicul, size, cost);
    }

    /**
     * @return Returns the (String) representation of the car
     */
    @Override
    public String toString() {
        return "Car{" +
                "size=" + size +
                ", cost=" + cost +
                '}';
    }
}
