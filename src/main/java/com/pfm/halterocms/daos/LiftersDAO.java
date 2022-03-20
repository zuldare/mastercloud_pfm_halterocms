package com.pfm.halterocms.daos;

import com.pfm.halterocms.models.Lifter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LiftersDAO extends CrudRepository<Lifter, Integer> {

    List<Lifter> findAllByCompetitionId(Integer competitionId);
}
