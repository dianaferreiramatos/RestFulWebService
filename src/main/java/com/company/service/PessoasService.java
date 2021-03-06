package com.company.service;

import com.company.dto.TerrenoDTO;
import com.company.model.Terreno;
import com.company.repo.Dados;
import com.company.dto.ListaPessoaDTO;
import com.company.dto.Mapper;
import com.company.dto.PessoaDTO;
import com.company.exception.ConversaoException;
import com.company.model.Autarquia;
import com.company.model.Pessoa;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


public class PessoasService {
    public static ListaPessoaDTO getPessoas() {
        ListaPessoaDTO listaPessoaDTO = null;
        Autarquia autarquia = Dados.carregarDados();
        ArrayList<Pessoa> pessoas = autarquia.getAllPessoas();
        //transformar lista de pessoas em pessoasDTO
        listaPessoaDTO = Mapper.listPessoa2PessoaDTO(pessoas);
        return listaPessoaDTO;
    }


    public static PessoaDTO getPessoa(long nif) {
        Autarquia autarquia = Dados.carregarDados();
        Pessoa pessoa = autarquia.getPessoa(nif);
        if (pessoa == null) {
            return null;
        }
        PessoaDTO pessoaDTO = Mapper.pessoa2PessoaDTO(pessoa);
        if (pessoaDTO != null) {
            return pessoaDTO;
        } else {
            throw new ConversaoException("PessoaDTO");
        }
    }


    public static void addPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = Mapper.pessoaDTO2Pessoa(pessoaDTO);
        if (pessoa != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.addPessoa(pessoa);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("PessoaDTO");
        }
    }


    public static void updatePessoa(long nif, PessoaDTO pessoaDTO) {
        Pessoa pessoa = Mapper.pessoaDTO2Pessoa(pessoaDTO);
        if (pessoa != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.updatePessoa(nif, pessoa);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("PessoaDTO");
        }
    }


    public static void removePessoa(long nif) {
        Autarquia autarquia = Dados.carregarDados();
        autarquia.removePessoa(nif);
        Dados.guardarDados(autarquia);
    }

    public static void addterreno(TerrenoDTO terrenoDTO){
        Terreno terreno1 = Mapper.terrenoDTO2terreno();
        
    }
}