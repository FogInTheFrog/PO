package com.company;

public interface Algebraic<T> {
    class RóżnaDługośćWektorów extends RuntimeException{}

    T add(T other);
    T multiply(T other);
}
