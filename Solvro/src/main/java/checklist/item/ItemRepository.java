package checklist.item;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {

    List<Item> findByChecklist_Name(String checklistId);

    void deleteItemByChecklist_NameAndId(String name, int id);

    Item findItemByChecklist_NameAndId(String name, int id);

    boolean existsByChecklistAndId(String name, int id);
}
