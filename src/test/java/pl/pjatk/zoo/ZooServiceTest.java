package pl.pjatk.zoo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ZooServiceTest {
    //Inicjalizacja testowanego serwisu
    private ZooService zooService = new ZooService(null);
    //Testy...
    @Test
    void shouldAddSuffixToName() {
        //GIVEN
        Zoo zoo = new Zoo(null, "Gdanskie zoo", "Gdansk", false, List.of());
        //WHEN
        zooService.addSuffixToName(zoo);
        //THEN
        assertThat(zoo.getName()).isEqualTo("Gdanskie zoo_SUFFIX");

    }

    @Test
    void shouldNotDoAnything() {
        //GIVEN
        Zoo zoo = new Zoo(null, null, "Gdansk", false, List.of());
        //WHEN
        zooService.addSuffixToName(zoo);
        //THEN
        assertThat(zoo.getName()).isNull();

    }

    @Test
    void shouldChangeDiet() {
        //GIVEN
        Animal animal = new Animal(null, "lion", Diet.MEAT, Type.AIR, true, 50);
        //WHEN
        zooService.changeAnimalDiet(animal, Diet.MIXED);
        //THEN
        assertThat(animal.getDiet()).isEqualTo(Diet.MIXED);
    }

    @Test
    void shouldDoNothing() {
        //GIVEN
        Animal animal = new Animal(null, "lion", null, Type.AIR, true, 50);
        //WHEN
        zooService.changeAnimalDiet(animal, Diet.MIXED);
        //THEN
        assertThat(animal.getDiet()).isNull();
    }

    @Test
    void shouldChangeZooLocation() {
        //GIVEN
        Zoo zoo = new Zoo(null, "Gdanskie zoo", "Gdansk", false, List.of());
        //WHEN
        zooService.changeZooLocation(zoo, "Russia");
        //THEN
        assertThat(zoo.getLocation()).isEqualTo("Russia");
    }

    @Test
    void shouldNotChangeZooLocation() {
        //GIVEN
        Zoo zoo = new Zoo(null, "Gdanskie zoo", "USA", false, List.of());
        //WHEN
        zooService.changeZooLocation(zoo, "Russia");
        //THEN
        assertThat(zoo.getLocation()).isEqualTo("USA");
    }

    @Test
    void shouldToggleZooIsClosed() {
        //GIVEN
        Zoo zoo = new Zoo(null, "Gdanskie zoo", "Gdansk", true, List.of());
        //WHEN
        zooService.toggleZooIsClosed(zoo);
        //THEN
        assertThat(zoo.isClosed()).isFalse();
    }

    @Test
    void shouldNotToggleZooIsClosed() {
        //GIVEN
        Zoo zoo = new Zoo(null, "Gdanskie zoo", "Gdansk", false, List.of());
        //WHEN
        zooService.toggleZooIsClosed(zoo);
        //THEN
        assertThat(zoo.isClosed()).isFalse();
    }

    @Test
    void shouldFeedAnimal() {
        //GIVEN
        Animal animal = new Animal(null, "lion", null, Type.AIR, true, 50);
        //WHEN
        zooService.feedAnimal(animal);
        //THEN
        assertThat(animal.isHungry()).isFalse();
        assertThat(animal.getHealth()).isEqualTo(75);
    }

    @Test
    void shouldNotFeedAnimal() {
        //GIVEN
        Animal animal = new Animal(null, "lion", null, Type.AIR, false, 50);
        //WHEN
        zooService.feedAnimal(animal);
        //THEN
        assertThat(animal.isHungry()).isFalse();
        assertThat(animal.getHealth()).isEqualTo(50);
    }

    @Test
    void shouldReturnTrue() {
        //GIVEN
        Animal animal = new Animal(null, "lion", null, Type.AIR, true, 50);
        //WHEN
        boolean isLion = zooService.isAnimalSpecimenLion(animal);
        //THEN
        assertThat(isLion).isTrue();
    }
}
