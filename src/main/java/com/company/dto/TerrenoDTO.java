package com.company.dto;

import com.company.model.Terreno;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"", "forma", "area"})
@JacksonXmlRootElement(localName = "terreno")
public class TerrenoDTO {

    @JacksonXmlProperty(localName = "area")
    private float area;
    @JacksonXmlProperty(localName = "forma")
    private Terreno.Forma forma;

    public TerrenoDTO() {
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public Terreno.Forma getForma() {
        return forma;
    }

    public void setForma(Terreno.Forma forma) {
        this.forma = forma;
    }
}
