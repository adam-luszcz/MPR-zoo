package pl.pjatk.zoo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Zoo> getNamedZoo() {
        return ResponseEntity.ok(zooService.getNamedZoo("test"));
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
