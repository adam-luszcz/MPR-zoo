package pl.pjatk.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ZooApplication {

	public static void main(String[] args) {

		//Klasa Zoo
		//Zoo -> id, name, location, isClosed, list Animal
		//Klasa Animal
		//Animal -> id, specimen, diet (meat, vege, mixed), type (water, land, air), hunger, health

		SpringApplication.run(ZooApplication.class, args);

		Animal lion = new Animal(1, "lion", Diet.MEAT, Type.LAND, true, 100);

		Zoo zoo = new Zoo(1, "Zoo", "Gdansk", false, List.of(lion));

		System.out.println(zoo);
	}

}
