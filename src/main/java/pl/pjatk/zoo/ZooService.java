package pl.pjatk.zoo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooService {

    public Zoo getExampleZoo() {
        Animal lion = new Animal(1, "lion", Diet.MEAT, Type.LAND, true, 100);
        return new Zoo(1, "Zoo", "Gdansk", false, List.of(lion));
    }

    public Zoo getEmptyZoo() {
        return new Zoo(1, "Zoo", "Gdansk", false, null);
    }

    public Zoo getNamedZoo(String name) {
        return new Zoo(1, name, "Gdansk", false, null);
    }
}
