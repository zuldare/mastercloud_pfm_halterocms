package com.pfm.halterocms.daos;

import com.pfm.halterocms.models.Weighin;
import org.springframework.data.repository.CrudRepository;

public interface WeighinsDAO extends CrudRepository<Weighin, Integer> {
}
