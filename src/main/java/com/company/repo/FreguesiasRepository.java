package com.company.repo;

import com.company.model.Freguesia;

import java.util.ArrayList;

public class FreguesiasRepository {

    private ArrayList<Freguesia> freguesiasRepository;

    public FreguesiasRepository(ArrayList<Freguesia> freguesiasRepository) {
        this.freguesiasRepository = freguesiasRepository;
    }

    public FreguesiasRepository() {
        this.freguesiasRepository = freguesiasRepository;
    }

    public ArrayList<Freguesia> getFreguesiasRepository() {
        return freguesiasRepository;
    }

    public void setFreguesiasRepository(ArrayList<Freguesia> freguesiasRepository) {
        this.freguesiasRepository = freguesiasRepository;
    }

    public boolean addFreguesiaToRepository(Freguesia freguesia){
        if(freguesia != null && !freguesiasRepository.contains(freguesia)) {
            freguesiasRepository.add(freguesia);
            return true;
        }else
            return false;
    }

    public void showAllFreguesias(){
        System.out.println(freguesiasRepository);
    }

    public boolean removeFreguesiaFromRepository(Freguesia freguesia){
        if(freguesia != null && freguesiasRepository.contains(freguesia)) {
            freguesiasRepository.remove(freguesia);
            return true;
        }else
            return false;
    }

}
