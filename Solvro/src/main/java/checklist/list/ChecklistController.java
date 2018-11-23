package checklist.list;
import checklist.exceptions.DoneCorrectlyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ChecklistController {

    @Autowired
    ChecklistService checklistService;

    @RequestMapping("/lists")
    public List<Checklist> getAll() {
        return checklistService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/lists")
    public void addChecklist(@RequestBody Checklist checklist) {
        checklistService.addChecklist(checklist);
        throw new DoneCorrectlyException("New checklist inserted.");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/lists/{name}")
    public void deleteChecklist(@PathVariable String name){
        checklistService.deleteChecklist(name);
    }
}
