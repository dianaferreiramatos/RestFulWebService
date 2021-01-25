package com.company.dto;

import com.company.model.Terreno;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//ordem dos atributos
@JsonPropertyOrder({"nif", "nome", "nascimento"})
@JacksonXmlRootElement(localName = "pessoa")

public class PessoaDTO {

//Jackson é uma framework que me permite serializar e nao ter de usar o serializable
    //com o serializable nao controlo tanto os dados, com o jackson sim, entre outras coisas

    @JacksonXmlProperty(localName = "nif")
    private long nif;
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "data_nascimento")
    private DataDTO nascimento;
    @JacksonXmlProperty(localName = "terreno")
    private ListaTerrenosDTO listaTerrenosDTO;

    public PessoaDTO() {
    }

    public long getNif() {
        return nif;
    }

    public void setNif(long nif) {
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public ListaTerrenosDTO getListaTerrenosDTO() {
        return listaTerrenosDTO;
    }

    public void setListaTerrenosDTO(ListaTerrenosDTO listaTerrenosDTO) {
        this.listaTerrenosDTO = listaTerrenosDTO;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public DataDTO getNascimento() {
        return nascimento;
    }

    public void setNascimento(DataDTO nascimento) {
        this.nascimento = nascimento;
    }
}