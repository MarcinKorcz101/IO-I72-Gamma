package pl.put.poznan.building.info.logic.composit;

import pl.put.poznan.building.info.logic.visitor.Visitor;

public abstract class Location {
    private Integer id;
    private String name;

    public Location(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void accept(Visitor visitor);
}
