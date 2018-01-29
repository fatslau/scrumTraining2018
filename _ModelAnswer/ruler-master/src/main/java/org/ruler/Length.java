package org.ruler;

import static org.ruler.Unit.FEET;
import static org.ruler.Unit.INCH;
import static org.ruler.Unit.MILE;
import static org.ruler.Unit.YARD;

class Length {
    private int value;
    private Unit unit;

    private Length(int value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    static Length mile(int value) {
        return new Length(value, MILE);
    }

    static Length yard(int value) {
        return new Length(value, YARD);
    }

    static Length feet(int value) {
        return new Length(value, FEET);
    }

    static Length inch(int value) {
        return new Length(value, INCH);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && value() == ((Length) obj).value();
    }

    private int value() {
        return this.value * this.unit.value();
    }

    Length plus(Length length) {
        return new Length(value() + length.value(), INCH);
    }
}
