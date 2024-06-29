package com.FormaGeometrica;

class Retangulo implements FormaGeometrica {

    public int a;
    public int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }


    @Override
    public String calcularArea() {
        return "Área: " + (a*b);
    }
}
