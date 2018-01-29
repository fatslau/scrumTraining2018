import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {
    /*
    * given: a parking lot capacity
    * when: customer request to park
    * then: show if slot still available
    * */
    @Test
    public void testAvailability(){
        ParkingLot parking = new ParkingLot(10);
        assertTrue(parking.isAvailable());
    }

    /*
     * given: a parking lot is available and customer with a car
     * when: customer request to park his car and give us his car#
     * then: he can park the car
     * */
    @Test
    public void testRental(){
        ParkingLot parking = new ParkingLot(10);
        Car car = new Car("A");
        assertTrue(parking.parkCar(car));
    }

    /*
     * given: a parking lot is NOT available and customer with a car
     * when: customer request to park his car and give us his car#
     * then: he CANNOT park the car
     * */
    @Test
    public void testRentalFail(){
        ParkingLot parking = new ParkingLot(0);
        Car car = new Car("PV5080");
        assertFalse(parking.parkCar(car));
    }

    /*
     * given: a customer has parked a car in our parkinglot
     * when: customer request to get back his car and give us his car#
     * then: return his car
     * */
    @Test
    public void testPickUp(){
        ParkingLot parking = new ParkingLot(10);
        Car car = new Car("PV5080");
        parking.parkCar(car);
        assertTrue(parking.canPickCar(car));
    }

    /*
     * given: a customer has never parked a car in our parkinglot
     * when: customer request to get back his car and give us his car#
     * then: show no car with the given car#
     * */
    @Test
    public void testPickUpFail(){
        ParkingLot parking = new ParkingLot(0);
        Car car1 = new Car("A");
        Car car2 = new Car("B");
        parking.parkCar(car1);
        assertFalse(parking.canPickCar(car2));
    }
}
