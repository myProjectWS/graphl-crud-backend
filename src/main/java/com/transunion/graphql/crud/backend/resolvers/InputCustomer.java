package com.transunion.graphql.crud.backend.resolvers;

import com.transunion.graphql.crud.backend.model.CustomerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputCustomer {

  private int id;

  private String firstName;

  private String lastName;

  private int latestScore;

  public static CustomerInfo convert(InputCustomer inputCustomer) {
    return inputCustomer != null
        ? new CustomerInfo(
            inputCustomer.getId(),
            inputCustomer.getFirstName(),
            inputCustomer.getLastName(),
            inputCustomer.getLatestScore())
        : null;
  }

  public CustomerInfo convert() {
    return convert(this);
  }
}
