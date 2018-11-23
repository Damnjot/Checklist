package checklist.item;
import checklist.exceptions.DoesntExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAllItems( String name){
        List<Item> items = new ArrayList<>();
        itemRepository.findByChecklist_Name(name).forEach(items::add);
        return items;
    }

    public void addItem(Item item){
        itemRepository.save(item);
    }

    public void updateItem(String name, int id, boolean checked){
        try {
            Item item = itemRepository.findItemByChecklist_NameAndId(name, id);
            item.changeCheckStatus(checked);
            itemRepository.save(item);
        }catch(Exception e){
            throw new DoesntExistException("Item of given ID does not exist.");
        }


    }
    @Transactional
    public void deleteItem(String name, int id){
        try {
            itemRepository.deleteItemByChecklist_NameAndId(name, id);
        }catch(Exception e){
            throw new DoesntExistException("Item of given ID does not exist in checklist.");
        }
    }

}
