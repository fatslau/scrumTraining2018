package org.Parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingBoy implements ParkingAgent {
    protected List<ParkingLot> parkingLots = new ArrayList<ParkingLot>() ;

    public ParkingBoy(ParkingLot pl) {
        addParkingLot(pl);
    }

    public void addParkingLot(ParkingLot pl){
        parkingLots.add(pl);
    }

    @Override
    public boolean parkCar(Car car) {
        for(ParkingLot pl: parkingLots){
            return pl.parkCar(car);
        }
        return false;
    }

    @Override
    public boolean pickCar(Car car) {
//        ParkingLot pl = parkingLots.stream().filter(p -> p.canPickCar(car)).collect(Collectors.toList()).get(0);
//        return pl.pickCar(car);
        try {
            ParkingLot pl = parkingLots.stream().filter(p -> p.canPickCar(car)).collect(Collectors.toList()).get(0);
            Optional<ParkingLot> lpl = parkingLots.stream().filter(p -> p.canPickCar(car)).ifPresent();
//                    .collect(Collectors.toList());
            return pl.pickCar(car);
        }catch(IndexOutOfBoundsException e){
            return false;
        }
    }
}
