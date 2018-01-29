package org.ruler;

public enum Unit {
    INCH(1),
    FEET(12 * INCH.value),
    YARD(3 * FEET.value),
    MILE(1760 * YARD.value);

    private int value;

    Unit(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
