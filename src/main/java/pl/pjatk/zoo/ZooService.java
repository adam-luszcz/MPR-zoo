package pl.pjatk.zoo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ZooService {

    private final ZooRepository zooRepository;

    public ZooService(ZooRepository zooRepository) {
        this.zooRepository = zooRepository;
    }

    public Zoo getExampleZoo() {
        Animal lion = new Animal(null, "lion", Diet.MEAT, Type.LAND, true, 100);
        Zoo zoo = new Zoo(null, "Zoo", "Gdansk", false, List.of(lion));
        zooRepository.save(zoo);
        return zoo;
    }

    public List<Zoo> getEmptyZoo() {
//        return new Zoo(1, "Zoo", "Gdansk", false, null);
        return zooRepository.findAllByIdGreaterThan(5);
    }

    public Zoo getNamedZoo(String name) {
        return new Zoo(1, name, "Gdansk", false, null);
    }

    public List<Zoo> getFullZoo() {
        return zooRepository.findAll();
    }

    public Zoo getZooById(Integer id) {
        Optional<Zoo> byId = zooRepository.findById(id);
        return byId.orElseThrow(RuntimeException::new);
    }

    public void addSuffixToName(Zoo zoo) {
        if (zoo.getName() != null) {
            String suffixName = zoo.getName() + "_SUFFIX";
            zoo.setName(suffixName);
        }
    }

    public void addAnimalToZoo(Zoo zoo, Animal animal) {
        if (zoo.getAnimal() != null) {
            zoo.getAnimal().add(animal);
        }
    }

    public void changeAnimalDiet(Animal animal, Diet diet) {
        if (animal.getDiet() != null) {
            animal.setDiet(diet);
        }
    }

    public void changeZooLocation(Zoo zoo, String newLocation) {
        if (!zoo.getLocation().equals("USA")) {
            zoo.setLocation(newLocation);
        }
    }

    public void toggleZooIsClosed(Zoo zoo) {
        if (zoo.isClosed()) {
            zoo.setClosed(!zoo.isClosed());
        }
    }

    public void feedAnimal(Animal animal) {
        if (animal.isHungry()) {
            animal.setHealth(animal.getHealth() + 25);
            animal.setHungry(false);
        }
    }

    public boolean isAnimalSpecimenLion(Animal animal) {
        return animal.getSpecimen().equals("lion");
    }

    public void changeAnimalTypeToLand(Animal animal) {
        if (animal.getType() != Type.LAND) {
            animal.setType(Type.LAND);
        }
    }
}
