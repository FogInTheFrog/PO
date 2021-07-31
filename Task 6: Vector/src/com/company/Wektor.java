package com.company;

import java.util.ArrayList;

public class Wektor<T extends Algebraic<T>> {

    private final ArrayList<T> elements;

    public Wektor(ArrayList<T> elements) {
        this.elements = elements;
    }

    public T getElement(int i) {
        return elements.get(i);
    }

    public int getLength() {
        return elements.size();
    }

    private boolean isSameLength(Wektor<T> other){
        return other.getLength() == this.getLength();
    }

    public Wektor<T> add(Wektor<T> other) {
        if (!isSameLength(other))
            throw new Algebraic.RóżnaDługośćWektorów();
        ArrayList<T> newElements = new ArrayList<>();
        for (int i = 0; i < this.getLength(); i++) {
            T newElement = this.getElement(i).add(other.getElement(i));
            newElements.add(newElement);
        }

        return new Wektor<>(newElements);
    }

    public T multiply(Wektor<T> other) {
        if (!isSameLength(other))
            throw new Algebraic.RóżnaDługośćWektorów();
        T value = this.getElement(0).multiply(other.getElement(0));
        for (int i = 1; i < this.getLength(); i++) {
            value = value.add(this.getElement(i).multiply(other.getElement(i)));
        }
        return value;
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
