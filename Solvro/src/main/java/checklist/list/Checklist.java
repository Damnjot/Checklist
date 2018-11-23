package checklist.list;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Checklist {

    @Id
    private String name;

    public Checklist(){}

    public Checklist(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
