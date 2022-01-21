package pl.pjatk.zoo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/zoo")
public class ZooRestController {

    private final ZooService zooService;

    public ZooRestController(ZooService zooService) {
        this.zooService = zooService;
    }

    @GetMapping("/example")
    public ResponseEntity<Zoo> getExampleZoo() {
        return ResponseEntity.ok(zooService.getExampleZoo());
    }

    @GetMapping("/empty")
    public ResponseEntity<List<Zoo>> getEmptyZoo() {
        return ResponseEntity.ok(zooService.getEmptyZoo());
    }

    @GetMapping("/empty_name")
    public ResponseEntity<Zoo> getNamedZoo(@RequestParam String name) {
        return ResponseEntity.ok(zooService.getNamedZoo(name));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Zoo>> getFullZoo() {
        return ResponseEntity.ok(zooService.getFullZoo());
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Zoo> getZooById(
            @PathVariable("id") Integer id) {
                return ResponseEntity.ok(zooService.getZooById(id));
            }

    // Do przeczytania:
    // @RestController
    // @Service
    // Wstrzykiwanie zaleznosci

    //crud repository i wstrzykujemy do serwisu

}
