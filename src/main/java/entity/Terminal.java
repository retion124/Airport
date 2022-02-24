package entity;

import javax.persistence.Entity;

@Entity
public class Terminal {
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
