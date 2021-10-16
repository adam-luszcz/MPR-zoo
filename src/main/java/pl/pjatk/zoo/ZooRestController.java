package pl.pjatk.zoo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zoo")
public class ZooRestController {

    @GetMapping("/example")
    public ResponseEntity<Zoo> getExampleZoo() {
        Animal lion = new Animal(1, "lion", Diet.MEAT, Type.LAND, true, 100);
        Zoo zoo = new Zoo(1, "Zoo", "Gdansk", false, List.of(lion));
        return ResponseEntity.ok(zoo);
    }

    @GetMapping("/empty")
    public ResponseEntity<Zoo> getEmptyZoo() {
        Animal lion = new Animal(1, "lion", Diet.MEAT, Type.LAND, true, 100);
        Zoo zoo = new Zoo(1, "Zoo", "Gdansk", false, null);
        return ResponseEntity.ok(zoo);
    }

}
