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

		Animal lion = new Animal(0, "lion", Diet.MEAT, Type.LAND, true, 100);

		List<Animal> animals = new ArrayList<>();
		animals.add(lion);


	}

}
