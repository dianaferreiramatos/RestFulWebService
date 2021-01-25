package com.company.model;

import com.company.exception.NumeroFuncionarioInvalidoException;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Funcionario")
@Table
public class Funcionario extends Pessoa implements Serializable {

    @Id // e o identificador de funcionario na tabela
    @Column(name = "numero_Funcionario") //definicao do nome da coluna na tabela
    private int numeroFuncionario;
    @Column // nome da coluna na tabela e o msm do atributo
    private String cargo;


    public Funcionario(int numeroFuncionario) {
        this.numeroFuncionario = numeroFuncionario;
    }

    public Funcionario(long nif, String nome, Data nascimento, int numeroFuncionario) {
        super(nif, nome, nascimento);
        setNumeroFuncionario(numeroFuncionario);
    }

    public Funcionario(long nif, String nome, Data nascimento, ArrayList<Terreno> listaTerrenos, int numeroFuncionario) {
        super(nif, nome, nascimento, listaTerrenos);
        setNumeroFuncionario(numeroFuncionario);
    }

    public Funcionario(Pessoa pessoa, int numeroFuncionario) {
        super(pessoa);
        setNumeroFuncionario(numeroFuncionario);
    }

    public Funcionario(Funcionario funcionario) {
        super(funcionario.getNif(), funcionario.getNome(), funcionario.getNascimento());
        setNumeroFuncionario(funcionario.getNumeroFuncionario());
        this.cargo = funcionario.getCargo();
    }

    public int getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setNumeroFuncionario(int numeroFuncionario) throws NumeroFuncionarioInvalidoException {
        if (numeroFuncionario > 0) {
            this.numeroFuncionario = numeroFuncionario;
        } else {
            throw new NumeroFuncionarioInvalidoException(numeroFuncionario + ": N´umero inv´alido");
        }
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


}
