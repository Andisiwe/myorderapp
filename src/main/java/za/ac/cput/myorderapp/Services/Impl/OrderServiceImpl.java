package za.ac.cput.myorderapp.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.myorderapp.Domain.Orders;
import za.ac.cput.myorderapp.Repository.OrderRepository;
import za.ac.cput.myorderapp.Services.OrderService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-05-20.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository repository;

    @Override
    public List<Orders> findAll() {
        List<Orders> allOrders = new ArrayList<>();

        Iterable<Orders> orders = repository.findAll();
        for (Orders order : orders){
            allOrders.add(order);
        }

        return allOrders;
    }

    @Override
    public Orders findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Orders save(Orders entity) {
        return repository.save(entity);
    }

    @Override
    public Orders update(Orders entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Orders entity) {
        repository.delete(entity);
    }
}
