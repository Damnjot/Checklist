package checklist.list;
import checklist.exceptions.AlreadyExistException;
import checklist.exceptions.DoesntExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChecklistService {

    @Autowired
    ChecklistRepository checklistRepository;

    public List<Checklist> getAll(){
        List<Checklist> checklists = new ArrayList<>();
        checklistRepository.findAll().forEach(checklists::add);
        return checklists;
    }

    public void addChecklist(Checklist checklist) {
        if(checklistRepository.existsByName(checklist.getName()))
            throw new AlreadyExistException(checklist.getName());
        checklistRepository.save(checklist);
    }

    public void deleteChecklist(String name){
        if(!checklistRepository.existsByName(name))
            throw new DoesntExistException("Checklist of given ID does not exist.");
        checklistRepository.deleteById(name);
    }

    public boolean checklistExist(String checklist) {
        return checklistRepository.existsByName(checklist);
    }
}
