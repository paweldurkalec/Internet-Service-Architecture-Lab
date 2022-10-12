package Project.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public interface Repository<E, K> {

    Optional<E> find(K id);

    HashSet<E> findAll();

    void create(E entity);

    void delete(E entity);


}
