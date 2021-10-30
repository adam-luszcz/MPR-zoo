package pl.pjatk.zoo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    public ResponseEntity<Zoo> getEmptyZoo() {
        return ResponseEntity.ok(zooService.getExampleZoo());
    }

    @GetMapping("/empty_name")
    public ResponseEntity<Zoo> getNamedZoo() {
        return ResponseEntity.ok(zooService.getNamedZoo("test"));
    }

    // Do przeczytania:
    // @RestController
    // @Service
    // Wstrzykiwanie zaleznosci

}
