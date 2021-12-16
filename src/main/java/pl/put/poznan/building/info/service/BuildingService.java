package pl.put.poznan.building.info.service;

import org.springframework.stereotype.Service;
import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.composit.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {
    private Building building;

    public void setBuilding(Building building){
        this.building = building;
    }

    public Building getBuilding() {
        return building;
    }

    public void addLevel(Level level){
        building.addLevel(level);
    }

    public void addRoom(int levelId, Room room){
        Optional<Level> level = building.getLevels()
                .stream()
                .filter(lvl -> lvl.getId() == levelId)
                .findFirst();
        level.ifPresent(value -> value.addRoom(room));
    }

    public List<Level> getLevels() {
        return building.getLevels();
    }

    public List<Room> getRooms(long levelId){
        Optional<Level> level =  building.getLevels()
                .stream()
                .filter(lvl -> lvl.getId() == levelId)
                .findFirst();
        return level.isPresent() ? level.get().getRooms() : new ArrayList<>();
    }
}
