package org.DistanceUnit;

public class Mile extends Length{
    public Mile(int number){
        super(number);
    }

    @Override
    int length() {
        return 1760*length;
    }

}
