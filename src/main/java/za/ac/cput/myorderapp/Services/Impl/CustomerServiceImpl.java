package za.ac.cput.myorderapp.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.myorderapp.Domain.Customer;
import za.ac.cput.myorderapp.Repository.CustomerRepository;
import za.ac.cput.myorderapp.Services.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-05-20.
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        List<Customer> allCustomers = new ArrayList<>();

        Iterable<Customer> customers = repository.findAll();
        for (Customer customer : customers){
            allCustomers.add(customer);
        }

        return allCustomers;
    }

    @Override
    public Customer findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Customer save(Customer entity) {
        return repository.save(entity);
    }

    @Override
    public Customer update(Customer entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Customer entity) {
        repository.delete(entity);
    }
}
