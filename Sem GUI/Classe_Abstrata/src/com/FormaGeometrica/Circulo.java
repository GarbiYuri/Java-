package com.FormaGeometrica;

class Circulo implements FormaGeometrica{
    public Double a;

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    @Override
    public String calcularArea() {
        return "Área: "  + (2*3.14*a);
    }
}
