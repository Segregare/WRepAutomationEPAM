package Planes;

import models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private MilitaryType variety;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType variety) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = variety;
    }

    public MilitaryType getType() {
        return variety;
    }

    @Override
    public String toDefineExperimentalPlane() {
        return super.toDefineExperimentalPlane().replace("}",
                ", type=" + variety +
                '}');
    }

    @Override
    public boolean equals(Object flyingParameters) {
        if (this == flyingParameters) return true;
        if (!(flyingParameters instanceof MilitaryPlane)) return false;
        if (!super.equals(flyingParameters)) return false;
        MilitaryPlane that = (MilitaryPlane) flyingParameters;
        return variety == that.variety;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), variety);
    }
}
