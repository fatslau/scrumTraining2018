package org.Parking;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmartParkingBoyTest {
    //  get parking lots with greatest availability
    @Test
    public void testGetGreatestSpaceParkingLot(){
        ParkingLot pl1 = new ParkingLot(1);
        ParkingLot pl2 = new ParkingLot(2);
        SmartParkingBoy he = new SmartParkingBoy(pl1);
        he.addParkingLot(pl2);
        assertEquals(pl2,he.getSmartParkingLot());
    }

    /*
     * given: a parking boy with 2 EMPTY lots
     * when: customer request to park
     * then: NO car can be parked
     * */
    @Test
    public void test2EmptyParkingLot(){
        ParkingLot pl1 = new ParkingLot(0);
        ParkingLot pl2 = new ParkingLot(0);
        SmartParkingBoy he = new SmartParkingBoy(pl1);
        he.addParkingLot(pl2);
        assertEquals(null,he.getSmartParkingLot());
    }

    /*
     * given: a parking boy with 2 lots
     * when: customer request to park and all are full
     * then: NO car can be parked
     * */
    @Test
    public void test2FullParkingLot(){
        ParkingLot pl1 = new ParkingLot(1);
        ParkingLot pl2 = new ParkingLot(1);
        Car car1 = new Car("A");
        Car car2 = new Car("B");
        SmartParkingBoy he = new SmartParkingBoy(pl1);
        he.addParkingLot(pl2);
        he.parkCar(car1);
        he.parkCar(car2);
        assertEquals(null,he.getSmartParkingLot());
    }

    /*
     * given: a parking boy with 2 lots
     * when: customer request to park
     * then: the car will be parked to the parking lot with the greatest availability
     * */
    @Test
    public void testSmartPark(){
        ParkingLot pl1 = new ParkingLot(0);
        ParkingLot pl2 = new ParkingLot(1);
        Car car = new Car("A");
        SmartParkingBoy he = new SmartParkingBoy(pl1);
        he.addParkingLot(pl2);
        assertEquals(pl2,he.getSmartParkingLot());
        assertTrue(he.parkCar(car));
        assertEquals(null,he.getSmartParkingLot());
    }

    /*
     * given: a parking boy with 1 lot and a customer has parked a car
     * when: customer request to get back his car and give us his car#
     * then: return his car
     * */
    @Test
    public void testPickUp1Lot(){
        ParkingLot pl = new ParkingLot(10);
        Car car = new Car("PV5080");
        SmartParkingBoy he = new SmartParkingBoy(pl);
        he.parkCar(car);
        assertEquals(9,pl.getAvailability());
        assertTrue(he.pickCar(car));
        assertEquals(10,pl.getAvailability());
    }

    /*
     * given: a parking boy with 2 lots and a customer has parked a car
     * when: customer request to get back his car and give us his car#
     * then: return his car
     * */
    @Test
    public void testPickUp2Lots(){
        ParkingLot pl = new ParkingLot(10);
        ParkingLot pl2 = new ParkingLot(5);
        Car car = new Car("PV5080");
        SmartParkingBoy he = new SmartParkingBoy(pl);
        he.addParkingLot(pl2);
        he.parkCar(car);
        assertEquals(9,pl.getAvailability());
        assertEquals(5,pl2.getAvailability());
        assertTrue(he.pickCar(car));
        assertEquals(10,pl.getAvailability());
        assertEquals(5,pl2.getAvailability());
    }

    /*
     * given: a parking boy with 1 EMPTY lot and a customer has never parked a car
     * when: customer request to get back his car and give us his car#
     * then: show no car with the given car#
     * */
    @Test
    public void testPickUpEmptyLotFail(){
        ParkingLot pl = new ParkingLot(0);
        Car car1 = new Car("A");
        Car car2 = new Car("B");
        SmartParkingBoy he = new SmartParkingBoy(pl);
        he.parkCar(car1);
        assertFalse(he.pickCar(car2));
    }

    /*
     * given: a parking boy with 1 FULL lot and a customer has never parked a car
     * when: customer request to get back his car and give us his car#
     * then: show no car with the given car#
     * */
    @Test
    public void testPickUpFail(){
        ParkingLot pl = new ParkingLot(1);
        Car car1 = new Car("A");
        Car car2 = new Car("B");
        SmartParkingBoy he = new SmartParkingBoy(pl);
        he.parkCar(car1);
        assertEquals(0,pl.getAvailability());
        he.parkCar(car2);
        assertFalse(he.pickCar(car2));
    }



}
