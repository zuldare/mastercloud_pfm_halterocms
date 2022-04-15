package com.pfm.halterocms.daos;

import com.pfm.halterocms.models.Lift;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiftDAO extends CrudRepository<Lift, Integer> {

	List<Lift> findAllByBatchLifter_Id(Integer batchLifterId);

}
