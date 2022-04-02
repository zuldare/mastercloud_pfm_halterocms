package com.pfm.halterocms.daos;

import com.pfm.halterocms.models.BatchLifter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BatchLiftersDAO extends CrudRepository<BatchLifter, Integer> {

    List<BatchLifter> findAllByBatchId(Integer batchId);

    BatchLifter findOneByBatchIdAndDrawOrder(Integer batchId, Integer drawOrder);

}
