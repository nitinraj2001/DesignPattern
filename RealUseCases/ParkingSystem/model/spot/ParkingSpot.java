package DesignPattern.RealUseCases.ParkingSystem.model.spot;

import DesignPattern.RealUseCases.ParkingSystem.model.vehicle.Vehicle;
import DesignPattern.RealUseCases.ParkingSystem.model.vehicle.VehicleSize;

/**
 *  This interface is used to represent the parking spot which is used to park the vehicle
 */
public interface ParkingSpot {

    /**
     *  This method is used to get the parking spot id
     * @return  it returns the parking spot id
     */
    public String getParkingSpotId();

    /**
     *  This method is used to get the parking spot size
     * @return  it returns the parking spot size
     */
    public VehicleSize getParkingSpotSize();

    /**
     *  This method is used to check if the parking spot is available for the given vehicle
     * @param vehicle object which is used to check if the parking spot is available for the given vehicle
     * @return  it returns true if the parking spot is available for the given vehicle, otherwise false
     */
    public boolean isParkingSpotAvailable(Vehicle vehicle);

    /**
     *  This method is used to vacate the parking spot
     * @param vehicle object which is used to vacate the parking spot
     */
    public void vacateParkingSpot(Vehicle vehicle);

    /**
     *  This method is used to occupy the parking spot
     * @param vehicle object which is used to occupy the parking spot
     */
    public void occupyParkingSpot(Vehicle vehicle);
}
