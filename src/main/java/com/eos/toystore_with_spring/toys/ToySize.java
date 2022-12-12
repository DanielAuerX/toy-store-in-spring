package com.eos.toystore_with_spring.toys;

public enum ToySize {
    XS(1),
    S(2),
    M(4),
    L(8),
    XL(16);

    public final int value;

    ToySize(int value) {
        this.value = value;
    }
}
