package com.company;

public interface IStack {

    class PełnyStos extends Exception {
    }

    class PustyStos extends Exception {
    }

    boolean pusty();

    void wstaw(int x) throws PełnyStos;

    int pobierz() throws PustyStos;
}
