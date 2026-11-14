package DesignPattern.RealUseCases.ParkingSystem.model.vehicle;

/**
 *  This class is used to represents the truck vehicle which is used in the parking system
 */
public class Truck implements Vehicle{

    final String licencePlatNumber;

    public Truck(String licencePlatNumber) {
        this.licencePlatNumber = licencePlatNumber;
    }

    /**
     * This method is used to get the licence plate number of the vehicle
     * @return  it returns the licence plate number of the vehicle
     */
    @Override
    public String getLicencePlate() {
        return this.licencePlatNumber;
    }

    /**
     *  This method is used to get the vehicle size of the vehicle
     * @return  it returns the vehicle size of the vehicle
     */
    @Override
    public VehicleSize getVehicleSize() {
        return VehicleSize.LARGE;
    }
}
