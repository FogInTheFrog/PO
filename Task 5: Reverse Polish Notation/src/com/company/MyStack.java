package com.company;

public class MyStack implements IStack {
    private int[] stos = new int[100];
    private int rozmiar = 0;

    public MyStack() {
    }

    public boolean pusty() {
        return rozmiar == 0;
    }

    public void wstaw(int x) throws PełnyStos {
        if (rozmiar == 100) throw new PełnyStos();
        else {
            stos[rozmiar] = x;
            rozmiar++;
        }
    }

    public int pobierz() throws PustyStos {
        if (rozmiar == 0) throw new PustyStos();
        else {
            rozmiar--;
            return stos[rozmiar];
        }
    }
}