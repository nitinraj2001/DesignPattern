package DesignPattern.RealUseCases.ParkingSystem.model.vehicle;

/**
 *  This interface is used to represent the vehicle which is used to park in the parking lot
 */
public interface Vehicle {

    // This method is used to get the license plate of the vehicle
    public String getLicencePlate();
    // This method is used to get the size of the vehicle
    public VehicleSize getVehicleSize();

}
