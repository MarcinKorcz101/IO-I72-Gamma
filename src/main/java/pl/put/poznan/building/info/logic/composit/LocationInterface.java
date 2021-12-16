package pl.put.poznan.building.info.logic.composit;

import pl.put.poznan.building.info.logic.visitor.Visitor;

public interface LocationInterface {

    double accept(Visitor visitor);
}
