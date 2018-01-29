package org.DistanceUnit;

public abstract class Length {
    protected int length;

    public Length(int number) {
        length = number;
    }

//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }

    abstract int length();

    @Override
    public boolean equals(Object obj) {
//        return true;
//        return length == ((Length)obj).length;
        return length() == ((Length)obj).length();
    }
}
