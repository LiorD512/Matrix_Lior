package com.liordahan.matrix_lior.repository;


public abstract class BaseRepository{

    private final BenefitsRepository benefitRepo;

    public BaseRepository() {


        this.benefitRepo = new BenefitsRepository(this);

    }

    public BenefitsRepository benefitRepo() {
        return benefitRepo;
    }


}
