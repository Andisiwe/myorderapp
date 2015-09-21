package za.ac.cput.myorderapp.Repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.myorderapp.Domain.Topping;

/**
 * Created by Andies on 2015-05-14.
 */
public interface ToppingRepository extends CrudRepository<Topping, Long> {
}
