package checklist.item;

import checklist.list.Checklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping("/lists/{name}/items")
    public List<Item> getAll(@PathVariable String name){

        return itemService.getAllItems(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/lists/{name}/items")
    public Item addItem(@PathVariable String name, @RequestBody String itemName){
        Item item = new Item(itemName);
        item.setChecklist(new Checklist(name));
        itemService.addItem(item);
        return item;
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/lists/{name}/items/{id}")
    public void changeCheckStatus(@PathVariable String name, @PathVariable int id, @RequestBody boolean checked){
        itemService.updateItem(name, id, checked);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/lists/{name}/items/{id}")
    public void deleteItem(@PathVariable String name, @PathVariable int id){
        itemService.deleteItem(name, id);
    }
}
