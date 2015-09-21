package za.ac.cput.myorderapp.Services;

import za.ac.cput.myorderapp.Domain.AuditTopping;

import java.util.List;

/**
 * Created by Andies on 2015-05-20.
 */
public interface AuditToppingService {
    public List<AuditTopping> findAll();
    public AuditTopping findById(Long id);

    public AuditTopping save(AuditTopping entity);

    public AuditTopping update(AuditTopping entity);

    public void delete(AuditTopping entity);
}
