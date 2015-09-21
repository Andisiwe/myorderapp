package za.ac.cput.myorderapp.Services;

import za.ac.cput.myorderapp.Domain.Orders;

import java.util.List;

/**
 * Created by Andies on 2015-05-20.
 */
public interface OrderService {
    public List<Orders> findAll();

    public Orders findById(Long id);

    public Orders save(Orders entity);

    public Orders update(Orders entity);

    public void delete(Orders entity);
}
