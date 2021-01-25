package com.company.model;

import com.company.exception.ElementoNaoExistenteException;
import com.company.exception.NifDuplicadoException;
import com.company.exception.NumeroFuncionarioDuplicadoException;

import java.io.Serializable;
import java.util.ArrayList;

public class Autarquia implements Serializable {
    private String nome;
    private ArrayList<Pessoa> pessoas;
    private ArrayList<Freguesia> listaFreguesias;

    public Autarquia(String nome) {
        this.nome = nome;
    }

    public Autarquia(String nome, ArrayList<Pessoa> pessoas) {
        this.nome = nome;
        this.pessoas = new ArrayList<Pessoa>();
    }

    public Autarquia(String nome, ArrayList<Pessoa> pessoas, ArrayList<Freguesia> listaFreguesias) {
        this.nome = nome;
        this.pessoas = new ArrayList<Pessoa>();
        this.listaFreguesias = listaFreguesias;
    }

    public ArrayList<Pessoa> getAllPessoas() {
        Pessoa pessoa;
        ArrayList<Pessoa> lista = new ArrayList<>();
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (!(pessoa instanceof Funcionario)) {
                Pessoa copiaPessoa = new Pessoa(pessoa);
                lista.add(copiaPessoa);
            } else {
                Funcionario funcionarioFuncionario = new Funcionario((Funcionario) pessoa);
                lista.add(funcionarioFuncionario);
            }
        }
        return lista;
    }

    //////////////////////////////////////////////////
    public ArrayList<Pessoa> getPessoas() {
        Pessoa pessoa;
        ArrayList<Pessoa> lista = new ArrayList<>();
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (!(pessoa instanceof Funcionario)) {
                Pessoa copia = new Pessoa(pessoa);
                lista.add(copia);
            }
        }
        return lista;
    }

    public void addPessoa(Pessoa pessoa) throws NifDuplicadoException {
        Pessoa p = getPessoaByNif(pessoa.getNif());
        if (p == null) {
            this.pessoas.add(pessoa);
        } else {
            throw new NifDuplicadoException(p.getNif() + ": NIF j´a existe");
        }
    }

    public Pessoa getPessoa(long nif) {
        return getPessoaByNif(nif);
    }

    public void removePessoa(long nif) throws ElementoNaoExistenteException {
        Pessoa pessoa = null;
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa.getNif() == nif) {
                if (!(pessoa instanceof Funcionario)) {
                    this.pessoas.remove(i);
                    return;
                } else {
                    throw new ElementoNaoExistenteException(nif + ": N~ao ´euma pessoa, ´eum funcion´ario");
                }
            }
        }
        throw new ElementoNaoExistenteException(nif + ": N~ao existe essa pessoa");
    }

    public void updatePessoa(long nif, Pessoa p) throws ElementoNaoExistenteException {
        Pessoa pessoa = null;
        boolean updated = false;
        for (int i = 0; i < this.pessoas.size() && !updated; i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa.getNif() == nif) {
                pessoa = p;
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(nif + ": N~ao existe essa pessoa");
        }
    }

    private Pessoa getPessoaByNif(long nif) {
        Pessoa pessoa = null;
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa.getNif() == nif) {
                Pessoa copia = new Pessoa(pessoa);
                return copia;
            }
        }
        return null;
    }

    ///////////////////////////////////////////////
// Funcionarios
    public ArrayList<Funcionario> getFuncionarios() {
        Pessoa pessoa;
        ArrayList<Funcionario> lista = new ArrayList<>();
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa instanceof Funcionario) {
                Funcionario copia = new Funcionario((Funcionario) pessoa);
                lista.add(copia);
            }
        }
        return lista;
    }

    public void addFuncionario(Funcionario funcionario) throws NumeroFuncionarioDuplicadoException,
            NifDuplicadoException {
        Pessoa p = getPessoaByNif(funcionario.getNif());
        if (p == null) {
            Funcionario f = getFuncionarioByNr(funcionario.getNumeroFuncionario());
            if (f == null) {
                addPessoa(funcionario);
            } else {
                throw new NumeroFuncionarioDuplicadoException(f.getNumeroFuncionario() + ": Número de funcionário já existe");
            }
        } else {
            throw new NifDuplicadoException(p.getNif() + ": NIF j´a existe");
        }
    }

    public Funcionario getFuncionario(int nr) {
        Funcionario funcionario = getFuncionarioByNr(nr);
        if (funcionario != null) {
            Funcionario copia = new Funcionario(funcionario);
            return copia;
        }
        return null;
    }

    public void removeFuncionario(int nr) throws ElementoNaoExistenteException {
        Pessoa pessoa = null;
        Funcionario funcionario = null;
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa instanceof Funcionario) {
                if (pessoa instanceof Funcionario) {
                    funcionario = (Funcionario) pessoa;
                    if (funcionario.getNumeroFuncionario() == nr) {
                        this.pessoas.remove(i);
                        return;
                    }
                }
            }
        }
        throw new ElementoNaoExistenteException(nr + ": Nãoo existe esse funcionario");
    }

    public void updateFuncionario(int nr, Funcionario f) throws ElementoNaoExistenteException {
        boolean updated = false;
        Pessoa pessoa = null;
        Funcionario funcionario = null;
        for (int i = 0; i < this.pessoas.size() && !updated; i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa instanceof Funcionario) {
                funcionario = (Funcionario) pessoa;
                if (funcionario.getNumeroFuncionario() == nr) {
                    funcionario = f;
                    updated = true;
                }
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(nr + ": N~ao existe esse funcionario");
        }
    }

    private Funcionario getFuncionarioByNr(int nr) {
        Pessoa pessoa = null;
        Funcionario funcionario = null;
        for (int i = 0; i < this.pessoas.size(); i++) {
            pessoa = this.pessoas.get(i);
            if (pessoa instanceof Funcionario) {
                funcionario = (Funcionario) pessoa;
                if (funcionario.getNumeroFuncionario() == nr) {
                    return funcionario;
                }
            }
        }
        return null;
    }

    private boolean checkIfFreguesiaPertenceAutarquia(Freguesia freguesia){
        boolean exists = false;
        if(freguesia != null){
            for (Freguesia freg: listaFreguesias) {
                if (freg.equals(freguesia)){
                    exists = true;
                    return exists;
                }
            }
        }
        return exists;
    }

    private boolean addFreguesia(Freguesia freguesia){
        boolean exists = false;
        if(!this.nome.equals(freguesia.getAutarquia())){
            return exists;
        }
        if (checkIfFreguesiaPertenceAutarquia(freguesia))
            return exists;
        else{
            exists = true;
            this.listaFreguesias.add(freguesia);
        }
        return exists;
    }

    private boolean removeFreguesia(Freguesia freguesia){
        boolean exists = false;
        if(!this.nome.equals(freguesia.getAutarquia())){
            return exists;
        }
        if (checkIfFreguesiaPertenceAutarquia(freguesia))
            exists = true;
            this.listaFreguesias.remove(freguesia);
            return exists;
    }
}
