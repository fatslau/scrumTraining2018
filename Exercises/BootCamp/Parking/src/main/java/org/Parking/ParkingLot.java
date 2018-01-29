package org.Parking;
import java.util.HashMap;

public class ParkingLot implements ParkingAgent {
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

    public boolean canPickCar(Car car){
        return (cars.get(car.getPlateNumber()) != null);
    }

    @Override
    public boolean parkCar(Car car) {
        if (occupiedSpace +1 <= this.capacity) {
            this.occupiedSpace++;
            cars.put(car.getPlateNumber(),this.occupiedSpace);
            return true;
        }
        return false;
    }

    @Override
    public boolean pickCar(Car car){
//        if (!canPickCar(car))return false;
//        else return (cars.remove(car.getPlateNumber())!=null);
        return (cars.remove(car.getPlateNumber()))!=null  && decrementSpace();
    }

    private boolean decrementSpace(){
        occupiedSpace--; return true;
    }

    public int getAvailability() {
        return capacity-occupiedSpace;
    }
}
