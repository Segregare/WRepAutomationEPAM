package Planes;

import java.util.Objects;

public class PassengerPlane extends Plane{


    private int passengersCapacity;


    public PassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }


    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toDefineCapacityOfPassengers() {
        return super.toDefineCapacityOfPassengers().replace("}",
                ", passengersCapacity=" + passengersCapacity +
                '}');
    }


    @Override
    public boolean equals(Object flyingParameters) {
        if (this == flyingParameters) return true;
        if (!(flyingParameters instanceof PassengerPlane)) return false;
        if (!super.equals(flyingParameters)) return false;
        PassengerPlane plane = (PassengerPlane) flyingParameters;
        return passengersCapacity == plane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
