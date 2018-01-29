package org.Parking;

import java.util.Comparator;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(ParkingLot pl) {
        super(pl);
    }

    public boolean parkCar(Car car){
        try{
            return getSmartParkingLot().parkCar(car);
        }catch(Exception e ) {
            return false;
        }
    }

    public ParkingLot getSmartParkingLot(){
//        return super.parkingLots.stream().max(Comparator.comparing(x->x.getAvailability())).get();
        try {
            ParkingLot result = super.parkingLots.stream().max(Comparator.comparing(x->x.getAvailability())).get();
            return (result.getAvailability()==0?null:result);
        }catch(Exception e){
            return null;
        }
    }
}
