package Planes;

import java.util.Objects;

abstract public class Plane {
    String model;
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;

    public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMinLoadCapacity() {
        int result = this.maxLoadCapacity;
        return result;
    }

    @Override
    public String toDefineFlyingParameters() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }

    @Override
    public boolean equals(Object flyingParameters) {
        if (this == flyingParameters) return true;
        if (!(flyingParameters instanceof Plane)) return false;
        Plane flight = (Plane) flyingParameters;
        return maxSpeed == flight.maxSpeed &&
                maxFlightDistance == flight.maxFlightDistance &&
                maxLoadCapacity == flight.maxLoadCapacity &&
                Objects.equals(model, flight.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}
