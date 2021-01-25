package com.company.model;

import java.util.Objects;

public class Terreno {

    public static enum Forma {
        CIRCULO, QUADRADO, TRIANGULO
    };

    private float area;
    private Forma forma;

    public Terreno(float area, Forma forma) {
        this.area = area;
        this.forma = forma;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public Forma getForma() {
        return forma;
    }

    public void setForma(Forma forma) {
        this.forma = forma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Terreno terreno = (Terreno) o;
        return Float.compare(terreno.area, area) == 0 &&
                forma == terreno.forma;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, forma);
    }
}
