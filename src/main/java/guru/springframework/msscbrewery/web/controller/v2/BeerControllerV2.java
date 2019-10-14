package guru.springframework.msscbrewery.web.controller.v2;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
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
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {

  private final BeerServiceV2 beerServiceV2;

  @Autowired
  public BeerControllerV2(BeerServiceV2 beerService) {
    this.beerServiceV2 = beerService;
  }

  @GetMapping({"/{beerId}"})
  public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity handlePost(@Valid @RequestBody BeerDtoV2 beerDto) {
    BeerDtoV2 saveDto = beerServiceV2.saveBeer(beerDto);
    HttpHeaders headers = new HttpHeaders();
    // TODO add hostname to url
    headers.add("Location", "/api/v1/beer/" + saveDto.getId().toString());

    return new ResponseEntity(headers, HttpStatus.CREATED);
  }

  @PutMapping({"/{beerId}"})
  public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto) {
    beerServiceV2.updateBeer(beerId, beerDto);

    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping({"/{beerId}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void  deleteBeer(@PathVariable("beerId") UUID uuid) {
    beerServiceV2.deleteById(uuid);
  }

}
