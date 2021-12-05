package pl.put.poznan.building.info.logic;
/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class BuildingInfo {

    private final String[] transforms;

    public BuildingInfo(String[] transforms){
        this.transforms = transforms;
    }

    public String transform(String text){
        return text.toUpperCase();
    }
}
