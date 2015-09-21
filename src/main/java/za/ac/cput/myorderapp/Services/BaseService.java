package za.ac.cput.myorderapp.Services;

import za.ac.cput.myorderapp.Domain.Base;

import java.util.List;

/**
 * Created by Andies on 2015-05-20.
 */
public interface BaseService {
    public List<Base> findAll();

    public Base findById(Long id);

    public Base save(Base entity);

    public Base update(Base entity);

    public void delete(Base entity);
}
