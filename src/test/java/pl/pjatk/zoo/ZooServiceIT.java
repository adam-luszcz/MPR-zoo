package pl.pjatk.zoo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ZooServiceIT {

    @MockBean
    private ZooRepository zooRepository;

    @Autowired
    private ZooService zooService;

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

    @Test
    void shouldFindById() {
        when(zooRepository.findById(any()))
                .thenReturn(Optional.of(new Zoo()));

        Zoo byId = zooService.getZooById(10);

        assertThat(byId).isNotNull();
    }

    @Test
    void shouldNotFindById() {
        when(zooRepository.findById(any()))
                .thenReturn(Optional.empty());

        Zoo byId = zooService.getZooById(1);

        assertThat(byId).isNull();
    }

    @Test
    void getAll() {
        List<Zoo> zoos = List.of(new Zoo());
        when(zooRepository.findAll())
                .thenReturn(zoos);

        List<Zoo> allZoos = zooService.getFullZoo();

        assertThat(allZoos).hasSize(zoos.size());
    }

    @Test
    void getAllEmpty() {
        List<Zoo> zooList = List.of();
        when(zooRepository.findAll()).thenReturn(zooList);

        List<Zoo> zoos = zooService.getFullZoo();

        assertThat(zoos).isEmpty();
    }

    @Test
    void shouldExistById() {
        when(zooRepository.existsById(any()))
                .thenReturn(true);

        boolean zooExistsById = zooService.zooExistsById(1);

        assertThat(zooExistsById).isTrue();

    }

    @Test
    void shouldNotExistById() {
        when(zooRepository.existsById(any()))
                .thenReturn(false);

        boolean zooExistsById = zooService.zooExistsById(1);

        assertThat(zooExistsById).isFalse();

    }

    @Test
    void shouldDelete() {
        //tylko do metod void
        doNothing().when(zooRepository).deleteById(any());

        zooService.deleteZooById(1);
        verify(zooRepository, times(1)).deleteById(any());
    }

    //shouldNotFindByID -> repo zwraca Optional.empty()
    //getAll -> ci jak zwroci x elementow, co jak zwroci pusta liste
    //zooExistsById -> co jak exists a co jak nie exists
    //deleteZooById -> sprawdzic czy wywolane
}
