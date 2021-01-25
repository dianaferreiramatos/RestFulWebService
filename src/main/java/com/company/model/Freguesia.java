package com.company.model;

import com.company.exception.FreguesiaExistenteException;
import com.company.repo.FreguesiasRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Freguesia {

    private String name;
    private String nomeAutarquia;
    private FreguesiasRepository freguesiasRepository;

    private static String DEFAULT_NAME = "sem nome";
    private static String DEFAULT_NOME_AUTAR = "sem autarquia";
    private static FreguesiasRepository DEFAULT_FREG_REPO = new FreguesiasRepository(new ArrayList<Freguesia>(0));



    public Freguesia() {
        this.nomeAutarquia = DEFAULT_NOME_AUTAR;
        this.name = DEFAULT_NAME;
        this.freguesiasRepository = DEFAULT_FREG_REPO;
    }

    public Freguesia(String name, String autarquia) throws IOException{
        try {
            setName(name);
            setAutarquia(autarquia);

            //ao criar uma freguesia adiciona automaticamente ao repositorio
            if (!checkIfFreguesiaExistsInRepository(this))
                freguesiasRepository.addFreguesiaToRepository(this);
        }catch (Exception e){
            throw new FreguesiaExistenteException("Freguesa já existe na autarquia definida!");
        }
    }

    public String getName() {
        return name;
    }

    public String getAutarquia() {
        return nomeAutarquia;
    }

    public FreguesiasRepository getFreguesiasRepository() {
        return freguesiasRepository;
    }

    public boolean setName(String name) {
        if(name == null || name.length() < 3){
            return false;
        }
        for(int i=0;i<name.length();i++){
            if(name.charAt(i) >= '0' && name.charAt(i) <= '9')
                return false;
        }
        this.name = name;
        return true;
    }

    public boolean checkIfFreguesiaExistsInRepository(Freguesia freguesia){
        if(name == null || name.length() < 3){
            throw new IllegalArgumentException("Name is not valid!");
        }
            for(int i=0;i<name.length();i++){
                if(name.charAt(i) >= '0' && name.charAt(i) <= '9')
                    throw new IllegalArgumentException("Name is not valid!");
            }
                for (Freguesia freg : freguesiasRepository.getFreguesiasRepository()) {
                    if(freg.getAutarquia().equals(freguesia.getAutarquia()) && freg.equals(freguesia)){
                        return true;
                    };
            }
                return false;
        }

    public void setAutarquia(String autarquia) {
        this.nomeAutarquia = autarquia;
    }

    public void setFreguesiasRepository(FreguesiasRepository freguesiasRepository) {
        this.freguesiasRepository = freguesiasRepository;
    }

    @Override
    public String toString() {
        return "Freguesia{" +
                "name='" + name + '\'' +
                ", nomeAutarquia='" + nomeAutarquia + '\'' +
                ", freguesiasRepository=" + freguesiasRepository +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Freguesia freguesia = (Freguesia) o;
        return Objects.equals(name, freguesia.name) &&
                Objects.equals(nomeAutarquia, freguesia.nomeAutarquia) &&
                Objects.equals(freguesiasRepository, freguesia.freguesiasRepository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nomeAutarquia, freguesiasRepository);
    }
}
