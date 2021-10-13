package com.transunion.graphql.crud.backend.service;

import com.transunion.graphql.crud.backend.model.CustomerInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerInfoRespository extends PagingAndSortingRepository<CustomerInfo, Integer>, CrudRepository<CustomerInfo, Integer>, QueryByExampleExecutor<CustomerInfo> {
    List<CustomerInfo> findAll();
}
