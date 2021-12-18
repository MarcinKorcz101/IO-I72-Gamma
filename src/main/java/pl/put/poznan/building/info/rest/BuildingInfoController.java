package pl.put.poznan.building.info.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.building.info.data.BuildingData;
import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.composit.Level;
import pl.put.poznan.building.info.logic.visitor.GetAreaVisitor;
import pl.put.poznan.building.info.logic.visitor.GetCubeVisitor;
import pl.put.poznan.building.info.service.BuildingService;

import java.util.List;
import java.util.Optional;


@RestController
public class BuildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);
    private BuildingService service;

    @Autowired
    public BuildingInfoController(BuildingService service) {
        this.service = service;
        Building building = BuildingData.get();
        service.setBuilding(building);
        logger.debug("Create data");
    }


    @GetMapping("/")
    public Building getBuildingName() {
        logger.debug("Getting building name");
        return service.getBuilding();
    }

    @GetMapping("/area/{id}")
    public String getArea(@PathVariable int id) {
        logger.debug("Getting area of location " + id);
        GetAreaVisitor getAreaVisitor = new GetAreaVisitor(id);
        service.getBuilding().accept(getAreaVisitor);
        return "Area " + getAreaVisitor.getArea();
    }

    @GetMapping("/cube/{id}")
    public String getCube(@PathVariable int id) {
        logger.debug("Getting cube of location " + id);
        GetCubeVisitor getCubeVisitor = new GetCubeVisitor(id);
        service.getBuilding().accept(getCubeVisitor);
        return "Cube " + getCubeVisitor.getCube();
    }

    @GetMapping("/heating/{id}")
    public String getHeating(@PathVariable int id) {
        logger.debug("Getting heating of location " + id);
        return "Heating ";
    }

    @GetMapping("/light/{id}")
    public String getLight(@PathVariable int id) {
        logger.debug("Getting light of location " + id);
        return "Light ";
    }


}


