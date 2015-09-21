package za.ac.cput.myorderapp.Repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.myorderapp.Domain.Base;

/**
 * Created by Andies on 2015-05-14.
 */
public interface BaseRepository extends CrudRepository<Base, Long> {
}
