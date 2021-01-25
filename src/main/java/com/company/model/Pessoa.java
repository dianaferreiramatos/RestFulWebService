package com.company.model;

import com.company.exception.NifInvalidoException;
import com.company.exception.NomePessoaInvalidoException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

//preciso de implementar Serializable para conseguir fazer GET a pessoas
public class Pessoa implements Serializable {
    private long nif;
    private String nome;
    private Data nascimento;
    private ArrayList<Terreno> listaTerrenos;

    public Pessoa() {
    }

    public Pessoa(long nif, String nome, Data nascimento) {
        setNif(nif);
        setNome(nome);
        this.nascimento = new Data(nascimento);
    }

    public Pessoa(long nif, String nome, Data nascimento, ArrayList<Terreno> listaTerrenos) {
        this.nif = nif;
        this.nome = nome;
        this.nascimento = nascimento;
        this.listaTerrenos = listaTerrenos;
    }

    public Pessoa(Pessoa pessoa) {
        setNif(pessoa.nif);
        setNome(pessoa.nome);
        this.nascimento = new Data(pessoa.nascimento);
    }

    public long getNif() {
        return nif;
    }

    public String getNome() {
        return nome;
    }

    public Data getNascimento() {
        Data data = new Data(nascimento);
        return data;
    }

    public void setNif(long nif) throws NifInvalidoException {
        if (nif >= 100000000 && nif <= 999999999) {
            this.nif = nif;
        } else {
            throw new NifInvalidoException(nif + ": NIF inválido");
        }
    }

    public void setNome(String nome) throws NomePessoaInvalidoException {
        if (eNomeValido(nome)) {
            this.nome = nome;
        } else {
            throw new NomePessoaInvalidoException(nome + ": Nome inválido");
        }
    }

    public void setNascimento(Data nascimento) {
        this.nascimento = nascimento;
    }

    private boolean eNomeValido(String nome) {
        if (nome == null) {
            return false;
        }
        if (nome.length() < 3) {
            return false;
        }
        for (int i = 0; i < nome.length(); i++) {
            if (nome.charAt(i) >= '0' && nome.charAt(i) <= '9')
                return false;
        }
        return true;
    }

    public ArrayList<Terreno> getListaTerrenos() {
        return listaTerrenos;
    }

    public void setListaTerrenos(ArrayList<Terreno> listaTerrenos) {
        this.listaTerrenos = listaTerrenos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return nif == pessoa.nif &&
                Objects.equals(nome, pessoa.nome) &&
                Objects.equals(nascimento, pessoa.nascimento) &&
                Objects.equals(listaTerrenos, pessoa.listaTerrenos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, nome, nascimento, listaTerrenos);
    }



}