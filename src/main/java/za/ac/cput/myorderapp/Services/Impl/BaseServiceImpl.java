package za.ac.cput.myorderapp.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.myorderapp.Domain.Base;
import za.ac.cput.myorderapp.Repository.BaseRepository;
import za.ac.cput.myorderapp.Services.BaseService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-05-20.
 */
@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    BaseRepository repository;

    @Override
    public List<Base> findAll() {
        List<Base> allBases = new ArrayList<>();
        Iterable<Base> bases = repository.findAll();
        for (Base base : bases) {
            allBases.add(base);
        }

        return allBases;
    }

    public BaseServiceImpl() {
        super();
    }

    @Override
    public Base findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Base save(Base entity) {
        return repository.save(entity);
    }

    @Override
    public Base update(Base entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Base entity) {
        repository.delete(entity);
    }
}
