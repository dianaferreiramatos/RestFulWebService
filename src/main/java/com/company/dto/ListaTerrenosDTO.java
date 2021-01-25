package com.company.dto;

import com.company.model.Terreno;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;


@JacksonXmlRootElement(localName = "terrenos")
public class ListaTerrenosDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "terrenos")
    private ArrayList<Terreno> listaTerrenos;

    public ListaTerrenosDTO() {
    }

    public ArrayList<Terreno> getListaTerrenos() {
        return listaTerrenos;
    }

    public void setListaTerrenos(ArrayList<Terreno> listaTerrenos) {
        this.listaTerrenos = listaTerrenos;
    }



}
