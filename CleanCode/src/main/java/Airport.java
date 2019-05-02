import Planes.experimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

/**
 * version: 1.1
 * made by Vitali Shulha
 * 4-Jan-2019
 */

public class Airport {
    private List<? extends Plane> planes;



    public List<PassengerPlane> getPassengerPlanes() {
        List<? extends Plane> list = this.planes;
        List<PassengerPlane> flight = new ArrayList<>();
        for (Plane air : list) {if (air instanceof PassengerPlane) {flight.add((PassengerPlane) air);}}
        return flight;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane air : planes) {
            if (air instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) air);
            }
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
      List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
      List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
      for (int i = 0; i < militaryPlanes.size(); i++) {
        MilitaryPlane plane = militaryPlanes.get(i);
        if (plane.getType() == MilitaryType.TRANSPORT) {
          transportMilitaryPlanes.add(plane);
        }
      }
      return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane plane = militaryPlanes.get(i);
            if (plane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;
    }

    public List<experimentalPlane> getExperimentalPlanes() {
        List<experimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane air : planes) {
            if (air instanceof experimentalPlane) {
                experimentalPlanes.add((experimentalPlane) air);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane blue, Plane green) {
                return blue.getMaxFlightDistance() - green.getMaxFlightDistance();
            }
        });
        return this;
    }



    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane blue, Plane green) {
                return blue.getMaxSpeed() - green.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane blue, Plane green) {
                return blue.getMinLoadCapacity() - green.getMinLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends Plane> collection) {
        Iterator<? extends Plane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Plane plane = iterator.next();
        }
    }

    @Override
    public String toShowAirportAndPlane() {
        return "Airport{" +
                "Planes=" + planes.toShowAirportAndPlane() +
                '}';
    }

    //Constructor
    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

}
