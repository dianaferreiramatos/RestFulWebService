package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"numeroFuncionario", "cargo"})
@JacksonXmlRootElement(localName = "funcionario")

public class FuncionarioDTO extends PessoaDTO{

    //descreve como e que a informacao deve ser transformada para o formato XML - serializacao
    @JacksonXmlProperty(localName = "numero")
    private int numeroFuncionario;
    @JacksonXmlProperty(localName = "cargo")
    private String cargo;


    public FuncionarioDTO() {
        super();
    }
    public int getNumeroFuncionario() {
        return numeroFuncionario;
    }
    public void setNumeroFuncionario(int numeroFuncionario) {
        this.numeroFuncionario = numeroFuncionario;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}