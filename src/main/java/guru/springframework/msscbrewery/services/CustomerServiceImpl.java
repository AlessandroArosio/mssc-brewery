package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
  @Override
  public CustomerDto getCustomer(UUID id) {
    return CustomerDto.builder()
        .id(UUID.randomUUID())
        .name("Alessandro")
        .build();
  }

  @Override
  public CustomerDto saveCustomer(CustomerDto customerId) {
    return CustomerDto.builder()
        .id(UUID.randomUUID())
        .name("Random name")
        .build();
  }

  @Override
  public void updateCustomer(UUID customerId, CustomerDto customerDto) {
    log.debug("update customer");
  }

  @Override
  public void deleteById(UUID uuid) {
    log.debug("delete customer");
  }
}
