package com.liordahan.matrix_lior.repository;


public class EntityRepository {

    private BaseRepository repository;

    EntityRepository(BaseRepository mainRepository) {
        this.repository = mainRepository;
    }

    protected BaseRepository getMainRepository() {
        return repository;
    }

}
