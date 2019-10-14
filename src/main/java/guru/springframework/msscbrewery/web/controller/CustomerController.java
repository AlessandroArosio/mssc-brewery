package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

  private final CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping({"/{id}"})
  public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID id) {
    return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity handlePost(@Valid @RequestBody CustomerDto customerId) {
    CustomerDto saveDto = customerService.saveCustomer(customerId);
    HttpHeaders headers = new HttpHeaders();
    // TODO add hostname to url
    headers.add("Location", "/api/v1/customer/" + saveDto.getId().toString());

    return new ResponseEntity(headers, HttpStatus.CREATED);
  }

  @PutMapping({"/{customerId}"})
  public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, @Valid @RequestBody CustomerDto customerDto) {
    customerService.updateCustomer(customerId, customerDto);

    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping({"/{customerId}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void  deleteCustomer(@PathVariable("customerId") UUID uuid) {
    customerService.deleteById(uuid);
  }

}
