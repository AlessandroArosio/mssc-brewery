package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
  CustomerDto getCustomer(UUID id);

  CustomerDto saveCustomer(CustomerDto customerId);

  void updateCustomer(UUID customerId, CustomerDto customerDto);

  void deleteById(UUID uuid);
}
