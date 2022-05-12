package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Terminal {
    @Id
    private int TerminalId;
    private String Gates;
    private String Name;
    private String Workers;

    public String getWorkers() {
        return Workers;
    }

    public void setWorkers(String workers) {
        Workers = workers;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGates() {
        return Gates;
    }

    public void setGates(String gates) {
        Gates = gates;
    }
}
