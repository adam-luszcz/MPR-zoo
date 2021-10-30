package pl.pjatk.zoo;

import javax.persistence.*;

@Entity
@Table(name = "Animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "specimen")
    private String specimen;
    @Column(name = "diet")
    private Diet diet;
    @Column(name = "type")
    private Type type;
    @Column(name = "isHungry")
    private boolean isHungry;
    @Column(name = "health")
    private int health;

    public Animal(Integer id, String specimen, Diet diet, Type type, boolean isHungry, int health) {
        this.id = id;
        this.specimen = specimen;
        this.diet = diet;
        this.type = type;
        this.isHungry = isHungry;
        this.health = health;
    }

    public Animal() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecimen() {
        return specimen;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", specimen='" + specimen + '\'' +
                ", diet=" + diet +
                ", type=" + type +
                ", isHungry=" + isHungry +
                ", health=" + health +
                '}';
    }
}
