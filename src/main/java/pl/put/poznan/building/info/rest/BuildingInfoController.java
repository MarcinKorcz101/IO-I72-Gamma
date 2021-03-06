package pl.put.poznan.building.info.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.building.info.data.BuildingData;
import pl.put.poznan.building.info.logic.composit.Building;
import pl.put.poznan.building.info.logic.visitor.*;
import pl.put.poznan.building.info.service.BuildingService;



import java.util.LinkedHashMap;

/**
 *
 * BuildingInfoController is class which enables to create REST communications.
 *
 */
@RestController
public class BuildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);
    private BuildingService service;
    LinkedHashMap<String, Object> response;
    
    @Autowired
    public BuildingInfoController(BuildingService service) {
        this.service = service;
        Building building = BuildingData.get();
        service.setBuilding(building);
        logger.debug("Loading example data");
    }
    @CrossOrigin()
    @PostMapping("/load")
    public void loadBuilding(@RequestBody Building building){
        logger.debug("Loading new building info");
        service.setBuilding(building);
        logger.debug("Saving data");
    }

    @CrossOrigin()
    @GetMapping("/")
    public Building getBuildingName() {
        logger.debug("Getting building name");
        return service.getBuilding();
    }

    @CrossOrigin()
    @GetMapping("/area/{id}")
    public LinkedHashMap<String, Object> getArea(@PathVariable int id) {
        logger.debug("Getting area of location " + id);
        GetAreaVisitor getAreaVisitor = new GetAreaVisitor(id);
        service.getBuilding().accept(getAreaVisitor);

        response = new LinkedHashMap<String, Object>();
        response.put("id", id);
        response.put("area", getAreaVisitor.getArea());
        return response;
    }


    @CrossOrigin()
    @GetMapping("/cube/{id}")
    public LinkedHashMap<String, Object> getCube(@PathVariable int id) {
        logger.debug("Getting cube of location " + id);
        GetCubeVisitor getCubeVisitor = new GetCubeVisitor(id);
        service.getBuilding().accept(getCubeVisitor);

        response = new LinkedHashMap<String, Object>();
        response.put("id", id);
        response.put("cube", getCubeVisitor.getCube());

        return response;

    }

    @CrossOrigin()
    @GetMapping("/heating/{id}")
    public LinkedHashMap<String, Object> getHeating(@PathVariable int id) {
        logger.debug("Getting heating usage of location " + id);
        GetHeatingVisitor getHeatingVisitor = new GetHeatingVisitor(id);
        service.getBuilding().accept(getHeatingVisitor);

        response = new LinkedHashMap<String, Object>();
        response.put("id", id);
        response.put("heating", getHeatingVisitor.getHeating());

        return response;
    }

    @CrossOrigin()
    @GetMapping("/light/{id}")
    public LinkedHashMap<String, Object> getLight(@PathVariable int id) {
        logger.debug("Getting light of location " + id);
        GetLightVisitor getLightVisitor = new GetLightVisitor(id);
        service.getBuilding().accept(getLightVisitor);

        response = new LinkedHashMap<String, Object>();
        response.put("id", id);
        response.put("light", getLightVisitor.getLight());

        return response;
    }

    @CrossOrigin
    @GetMapping("/ExceededHeating/{buildingId}/{threshold}")
    public LinkedHashMap<String, Object> getExceedingHeating(@PathVariable int buildingId, @PathVariable double threshold) {
        logger.debug("Getting locations where heating exceeds: " + threshold);
        GetExceededHeatingVisitor getEHeatingVisitor = new GetExceededHeatingVisitor(buildingId, threshold);
        service.getBuilding().accept(getEHeatingVisitor);

        response = new LinkedHashMap<String, Object>();
        response.put("ids", getEHeatingVisitor.getExceededHeating());

        return response;
    }
}


