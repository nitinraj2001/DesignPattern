package DesignPattern.RealUseCases.ParkingSystem.model.spot;

import DesignPattern.RealUseCases.ParkingSystem.model.vehicle.Vehicle;
import DesignPattern.RealUseCases.ParkingSystem.model.vehicle.VehicleSize;

/**
 *  This class is used to represents the compact parking spot
 *  which is used to park the compact vehicles
 */
public class CompactSpot implements ParkingSpot{

    private final String parkingSpotId;

    private Vehicle vehicle;

    public CompactSpot(String parkingSpotId){
        this.parkingSpotId = parkingSpotId;
        this.vehicle = null;
    }

    /**
     *  This method is used to get the parking spot id
     * @return  it returns the parking spot id
     */
    @Override
    public String getParkingSpotId() {
        return this.parkingSpotId;
    }

    /**
     *  This method is used to get the parking spot size
     * @return  it returns the parking spot size
     */
    @Override
    public VehicleSize getParkingSpotSize() {
        return VehicleSize.SMALL;
    }


    /**
     *  This method is used to check if the parking spot is available for the given vehicle
     * @param vehicle object which is used to check if the parking spot is available
     * for the given vehicle
     * @return  it returns true if the parking spot is available, false otherwise
     */
    @Override
    public boolean isParkingSpotAvailable(Vehicle vehicle) {
        // A spot is considered available only when the spot itself is empty.
        // Do NOT check the incoming vehicle argument, because that is not the spot state.
        return this.vehicle == null;
    }

    /**
     *  This method is used to vacate the parking spot
     * @param vehicle object which is used to vacate the parking spot
     */
    @Override
    public void vacateParkingSpot(Vehicle vehicle) {
        this.vehicle = null;
    }

    /**
     *  This method is used to occupy the parking spot
     * @param vehicle object which is used to occupy the parking spot
     */
    @Override
    public void occupyParkingSpot(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
