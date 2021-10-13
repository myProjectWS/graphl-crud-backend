package com.transunion.graphql.crud.backend.service;

import com.transunion.graphql.crud.backend.model.CustomerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@Slf4j
public class CustomerInfoService {

  @Autowired CustomerInfoRespository customerInfoRespository;

  /**
   *
   * @param inputCustomer
   * @return
   */
  public List<CustomerInfo> find(CustomerInfo inputCustomer) {
    if (inputCustomer == null) {
      log.info("InputCustomer null; so fetching all records.");
      return customerInfoRespository.findAll();
    } else {
      log.info("Inside inputCustomer not null");
      ExampleMatcher matcher =
          ExampleMatcher.matching()
              .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
              .withIgnoreCase();
      log.info("Matcher {}", matcher);

      return StreamSupport.stream(
              customerInfoRespository.findAll(Example.of(inputCustomer, matcher)).spliterator(),
              false)
          .collect(Collectors.toList());
    }
  }

  /**
   *
   * @param id
   * @return
   */
  public Optional<CustomerInfo> findById(int id){
    return customerInfoRespository.findById(id);
  }

  /**
   *
   * @param inputCustomer
   * @return
   */
  public CustomerInfo save(CustomerInfo inputCustomer){
    return customerInfoRespository.save(inputCustomer);
  }
}
