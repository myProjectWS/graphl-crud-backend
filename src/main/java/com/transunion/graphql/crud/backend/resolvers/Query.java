package com.transunion.graphql.crud.backend.resolvers;



import com.transunion.graphql.crud.backend.model.CustomerInfo;
import com.transunion.graphql.crud.backend.service.CustomerInfoService;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

  @Autowired
  CustomerInfoService customerInfoService;

  public List<CustomerInfo> customers(InputCustomer inputCustomer) {
    if(inputCustomer == null) {
      return customerInfoService.find(null);
    }else{
      return customerInfoService.find(inputCustomer.convert());
    }
  }

  public Optional<CustomerInfo> customer(Integer id) {
    return customerInfoService.findById(id);
  }
}
