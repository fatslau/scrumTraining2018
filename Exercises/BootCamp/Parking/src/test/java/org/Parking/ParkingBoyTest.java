package org.Parking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingBoyTest {
    /*
    * given: a parking boy with 2 lots
    * when: customer request to park
    * then: he can park in the 1st parking lot
    * */
    @Test
    public void testPark2Lots(){
        ParkingLot pl1 = new ParkingLot(1);
        ParkingLot pl2 = new ParkingLot(2);
        Car car = new Car("A");

        ParkingBoy he = new ParkingBoy(pl1);
        he.addParkingLot(pl2);
        assertTrue(he.parkCar(car));
        assertEquals(0,pl1.getAvailability());
    }

    /*
     * given: a parking boy with 1 parking lot is available and customer with a car
     * when: customer request to park his car and give us his car#
     * then: he can park the car
     * */
    @Test
    public void testPark1Lot(){
        ParkingLot pl = new ParkingLot(10);
        Car car = new Car("A");
        ParkingBoy he = new ParkingBoy(pl);
        assertTrue(he.parkCar(car));
        assertEquals(9,pl.getAvailability());
    }

    /*
     * given: a parking boy with 1 EMPTY parking lot and customer with a car
     * when: customer request to park his car and give us his car#
     * then: he CANNOT park the car
     * */
    @Test
    public void testParkFailEmptyLot(){
        ParkingLot pl = new ParkingLot(0);
        Car car = new Car("PV5080");
        ParkingBoy he = new ParkingBoy(pl);
        assertFalse(he.parkCar(car));
    }

    /*
     * given: a parking boy with 1 lot and a customer has parked a car
     * when: customer request to get back his car and give us his car#
     * then: return his car
     * */
    @Test
    public void testPickUp(){
        ParkingLot pl = new ParkingLot(10);
        Car car = new Car("PV5080");
        ParkingBoy he = new ParkingBoy(pl);
        he.parkCar(car);
        assertTrue(he.pickCar(car));
    }

    /*
     * given: a parking boy with 1 EMPTY lot and a customer has never parked a car
     * when: customer request to get back his car and give us his car#
     * then: show no car with the given car#
     * */
    @Test
    public void testPickUpFail(){
        ParkingLot pl = new ParkingLot(0);
        Car car1 = new Car("A");
        Car car2 = new Car("B");
        ParkingBoy he = new ParkingBoy(pl);
        he.parkCar(car1);
        assertFalse(he.pickCar(car2));
    }
/*
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        ArrayList emptyList = new ArrayList();
        Object o = emptyList.get(0);
    }
    */
}