package DesignPattern.RealUseCases.ParkingSystem.model.vehicle;

/**
 *  This class is used to represents the motorcycle which is a type of vehicle
 */
public class MotorCycle implements Vehicle{
    private final String licencePlate;

    public MotorCycle(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    /**
     * This method is used to get the licence plate of the vehicle
     * @return  it returns the licence plate of the vehicle
     */
    @Override
    public String getLicencePlate() {
        return this.licencePlate;
    }

    /**
     * This method is used to get the size of the vehicle
     * @return  it returns the size of the vehicle
     */
    @Override
    public VehicleSize getVehicleSize() {
        return VehicleSize.SMALL;
    }
}
