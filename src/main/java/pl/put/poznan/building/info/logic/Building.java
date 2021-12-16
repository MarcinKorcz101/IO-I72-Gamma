package pl.put.poznan.building.info.logic;

import java.util.List;

public class Building extends Location{
    private List<Level> levels;

    public Building(Integer id, String name) {
        super(id, name);
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    private void addLevel(Level level){
        levels.add(level);
    }
}
