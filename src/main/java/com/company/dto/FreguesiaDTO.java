package com.company.dto;

import com.company.model.Terreno;
import com.company.repo.FreguesiasRepository;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JsonPropertyOrder({"", "nome", "autarquia"})
@JacksonXmlRootElement(localName = "freguesia")
public class FreguesiaDTO {

    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "nome_autarquia")
    private String nomeAutarquia;
    @JacksonXmlProperty(localName = "lista_freguesias")
    private ListaFreguesiasDTO listaFreguesiasDTO;


    public FreguesiaDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
