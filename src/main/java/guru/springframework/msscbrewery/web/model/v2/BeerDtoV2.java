package guru.springframework.msscbrewery.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// not persisting the object at this point in time. It's just an example for now
public class BeerDtoV2 {

  private UUID id;
  private String beerName;
  private BeerStyleEnum beerStyle;
  private Long upc;

}
