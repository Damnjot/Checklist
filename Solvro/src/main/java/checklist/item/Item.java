package checklist.item;

import checklist.list.Checklist;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private boolean checked;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    Checklist checklist;


    public Item(){}

    public Item(String name) {
        this.name = name;
        this.checked = false;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void changeCheckStatus(boolean checked){
        this.checked = checked;
    }

    public Checklist getChecklist() {
        return checklist;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }

}
