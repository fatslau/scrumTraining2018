package org.DistanceUnit;

public class Yard extends Length {
    public Yard(int number){
        super(number);
    }

    @Override
    int length() {
        return 1*length;
    }
}
