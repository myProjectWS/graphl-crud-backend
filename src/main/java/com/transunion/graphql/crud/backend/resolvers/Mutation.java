package com.transunion.graphql.crud.backend.resolvers;


import com.transunion.graphql.crud.backend.model.CustomerInfo;
import com.transunion.graphql.crud.backend.service.CustomerInfoRespository;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Mutation implements GraphQLMutationResolver {

  @Autowired
  CustomerInfoRespository customerInfoRespository;

  /**
   *
   * @param inputCustomer
   * @return
   */
  public CustomerInfo addCustomer(InputCustomer inputCustomer) {
    log.info("Inside addCustomer with inputCustomer: {}",inputCustomer.toString());
    return customerInfoRespository.save(inputCustomer.convert());
  }

  /**
   *
   * @param id
   * @return
   */
  public String deleteCustomer(Integer id){
    log.info("Inside deleteCustomer with id: {}",id);
    customerInfoRespository.deleteById(id);
    return "Successfully deleted customer with id: "+ id;
  }

  /**
   * 
   * @param inputCustomer
   * @return
   */
  public CustomerInfo updateCustomer(InputCustomer inputCustomer){
    log.info("Inside updateCustomer with inputCustomer: {}",inputCustomer.toString());
    return customerInfoRespository.save(inputCustomer.convert());
  }
}
