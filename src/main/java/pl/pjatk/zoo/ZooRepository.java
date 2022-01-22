package pl.pjatk.zoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ZooRepository extends JpaRepository<Zoo, Integer> {

//    @Transactional
//    @Modifying
//    @Query("UPDATE Zoo z SET z.name = :name, z.isClosed = :isClosed where z.id = :id")
//    int updateZoo(String name, boolean open, Integer id);
    List<Zoo> findAllByIdGreaterThan(Integer id);
}
