package pl.pjatk.zoo;
import java.util.List;

public class Zoo {
    private Integer id;
    private String name;
    private String location;
    private boolean isClosed;
    private List<Animal> animal;

    public Zoo() {
    }

    public Zoo(Integer id, String name, String location, boolean isClosed, List<Animal> animal) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.isClosed = isClosed;
        this.animal = animal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", isClosed=" + isClosed +
                ", animal=" + animal +
                '}';
    }


}
