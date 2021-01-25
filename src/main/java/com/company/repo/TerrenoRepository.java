package com.company.repo;

import com.company.model.Terreno;

import java.util.ArrayList;
import java.util.Objects;

public class TerrenoRepository {

    private ArrayList<Terreno> terrenosRepository;

    public TerrenoRepository(ArrayList<Terreno> terrenosRepository) {
        this.terrenosRepository = terrenosRepository;
    }

    public ArrayList<Terreno> getTerrenosRepository() {
        return terrenosRepository;
    }

    public void setTerrenosRepository(ArrayList<Terreno> terrenosRepository) {
        this.terrenosRepository = terrenosRepository;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TerrenoRepository that = (TerrenoRepository) o;
        return Objects.equals(terrenosRepository, that.terrenosRepository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(terrenosRepository);
    }
}
