package com.company;

public class AlgebraicInteger implements Algebraic<AlgebraicInteger> {
    Integer value;

    public AlgebraicInteger(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public AlgebraicInteger add(AlgebraicInteger other) {
        return new AlgebraicInteger(this.value + other.getValue());
    }

    @Override
    public AlgebraicInteger multiply(AlgebraicInteger other) {
        return new AlgebraicInteger(this.value * other.getValue());
    }

    @Override
    public String toString() {
        return "AlgebraicInteger{" +
                "value=" + value +
                '}';
    }
}