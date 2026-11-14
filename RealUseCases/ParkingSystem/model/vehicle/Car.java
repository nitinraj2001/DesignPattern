package DesignPattern.RealUseCases.ParkingSystem.model.vehicle;

/**
 *  This class is used to represents the car which is a type of vehicle
 */
public class Car implements Vehicle{

    private final String licencePlate;

    public Car(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    /**
     * This method is used to get the licence plate of the car
     * @return  it returns the licence plate of the car
     */
    @Override
    public String getLicencePlate() {
        return this.licencePlate;
    }

    /**
     *  This method is used to get the vehicle size of the car
     * @return  it returns the vehicle size of the car which is large
     */
    @Override
    public VehicleSize getVehicleSize() {
        return VehicleSize.MEDIUM;
    }
}
