package za.ac.cput.myorderapp.Services;

import za.ac.cput.myorderapp.Domain.Customer;

import java.util.List;

/**
 * Created by Andies on 2015-05-20.
 */
public interface CustomerService {
    List<Customer> findAll();

    public Customer findById(Long id);

    public Customer save(Customer entity);

    public Customer update(Customer entity);

    public void delete(Customer entity);
}
