package DesignPattern.RealUseCases.ParkingSystem.model.spot;

import DesignPattern.RealUseCases.ParkingSystem.model.vehicle.Vehicle;
import DesignPattern.RealUseCases.ParkingSystem.model.vehicle.VehicleSize;

/**
 *  This class is used to represents the regular parking spot which is used to park the regular vehicles
 */
public class RegularSpot implements ParkingSpot{

    final String parkingSpotNumber;

    Vehicle vehicle;

    public RegularSpot(String parkingSpotNumber){
        this.parkingSpotNumber = parkingSpotNumber;
        this.vehicle = null;
    }

    /**
     *  This method is used to get the parking spot id
     * @return  it returns the parking spot id
     */
    @Override
    public String getParkingSpotId() {
        return this.parkingSpotNumber;
    }

    /**
     *  This method is used to get the parking spot size
     * @return  it returns the parking spot size
     */
    @Override
    public VehicleSize getParkingSpotSize() {
        return VehicleSize.MEDIUM;
    }

    /**
     *  This method is used to check if the parking spot is available for the given vehicle
     * @param vehicle object which is used to check if the parking spot is available for the given vehicle
     * @return  it returns true if the parking spot is available for the given vehicle else it returns false
     */
    @Override
    public boolean isParkingSpotAvailable(Vehicle vehicle) {
        // The spot's state must be checked, not the parameter passed into this method.
        // If this.vehicle is null, the spot is free; otherwise it is occupied.
        return this.vehicle == null;
    }

    /**
     *  This method is used to vacate the parking spot
     * @param vehicle object which is used to vacate the parking spot
     */
    @Override
    public void vacateParkingSpot(Vehicle vehicle) {
       // In order to mark the spot available de-reference the vehicle instance
        this.vehicle = null;
    }

    /**
     *  This method is used to occupy the parking spot
     * @param vehicle object which is used to occupy the parking spot
     */
    @Override
    public void occupyParkingSpot(Vehicle vehicle) {
        // In order to mark the spot occupied, reference the vehicle instance
        this.vehicle = vehicle;
    }
}
