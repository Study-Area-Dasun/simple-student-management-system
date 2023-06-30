package lk.ijse.dep10.simplestudentmanagementsystem.dao;


import lk.ijse.dep10.simplestudentmanagementsystem.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudDAO<T extends SuperEntity, ID extends Serializable> {

    T save(T entity) throws Exception;

    void deleteById(ID pk) throws Exception;

    List<T> findAll() throws Exception;
}
