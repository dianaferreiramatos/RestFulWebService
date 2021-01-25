package com.company.dto;

import com.company.model.Freguesia;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "freguesias")
public class ListaFreguesiasDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "freguesias")
    private ArrayList<Freguesia> listaFreguesias;

    public ListaFreguesiasDTO() {
    }

    public ArrayList<Freguesia> getListaFreguesias() {
        return listaFreguesias;
    }

    public void setListaFreguesias(ArrayList<Freguesia> listaFreguesias) {
        this.listaFreguesias = listaFreguesias;
    }


}
