import java.util.HashMap;

public class ParkingLot {
    private int capacity;
    private int occupiedSpace;
    private HashMap<String,Integer> cars;

    ParkingLot(int cap){
        this.capacity = cap;
        this.occupiedSpace = 0;
        this.cars = new HashMap<>();
    }

    public boolean isAvailable() {
       return capacity - occupiedSpace > 0;
    }

    public boolean parkCar(Car car) {
        if (occupiedSpace +1 <= this.capacity) {
            this.occupiedSpace++;
            cars.put(car.getPlateNumber(),this.occupiedSpace);
            return true;
        }
        return false;
    }

    public boolean canPickCar(Car car){
        return (cars.get(car.getPlateNumber()) != null);

    }
}
