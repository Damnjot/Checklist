package checklist.list;

import org.springframework.data.repository.CrudRepository;

public interface ChecklistRepository extends CrudRepository<Checklist, String> {

    boolean existsByName(String checklist);

}
