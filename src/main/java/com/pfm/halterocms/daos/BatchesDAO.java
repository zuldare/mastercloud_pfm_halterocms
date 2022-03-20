package com.pfm.halterocms.daos;

import com.pfm.halterocms.models.Batch;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BatchesDAO extends CrudRepository<Batch, Integer> {

    List<Batch> findByCompetitionId(Integer competitionId);
}
