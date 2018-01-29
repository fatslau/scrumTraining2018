package org.DistanceUnit;

public class Inch extends Length{
    public Inch(int number){
        super(number);
    }

    @Override
    int length() {
        return 1760*length;
    }
}
