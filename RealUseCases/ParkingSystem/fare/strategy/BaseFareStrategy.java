package DesignPattern.RealUseCases.ParkingSystem.fare.strategy;

import DesignPattern.RealUseCases.ParkingSystem.model.Ticket;

import java.math.BigDecimal;

/**
 *  This class is used to represent the base fare strategy which is used to calculate the fare for the parking lot
 *  The base fare strategy is used to calculate the fare for the parking lot based on the vehicle size and the parking duration.
 *  */
public class BaseFareStrategy implements FareStrategy{

    /**
     *  This method is used to calculate the fare for the parking spot based on the vehicle size and the parking duration.
     *  The fare is calculated based on the vehicle size and the parking duration.
     * @param ticket object which is used to calculate the fare for the parking spot
     * @return  it returns the fare for the parking spot based on the vehicle size and the parking duration.
     */
    @Override
    public BigDecimal calculateFare(Ticket ticket) {
        BigDecimal durationHours = ticket.calculateParkingDuration();
        if (durationHours.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal baseFare = BigDecimal.ZERO;
        switch (ticket.getVehicle().getVehicleSize()) {
            case SMALL:
                baseFare = new BigDecimal("50.00");
                break;
            case MEDIUM:
                baseFare = new BigDecimal("100.00");
                break;
            case LARGE:
                baseFare = new BigDecimal("150.00");
                break;
        }

        BigDecimal normalFare = baseFare.multiply(durationHours);

        // Extra charge if the vehicle was assigned a larger slot than required.
        // Example: MEDIUM vehicle parked in a LARGE spot should pay surcharge.
        BigDecimal upgradeCharge = BigDecimal.ZERO;
        if (ticket.getParkingSpot() != null) {
            int spotOrder = ticket.getParkingSpot().getParkingSpotSize().ordinal();
            int vehicleOrder = ticket.getVehicle().getVehicleSize().ordinal();

            if (spotOrder > vehicleOrder) {
                int diff = spotOrder - vehicleOrder;
                BigDecimal surchargeRate = new BigDecimal("0.20");
                BigDecimal extraPerLevel = baseFare.multiply(surchargeRate);
                upgradeCharge = extraPerLevel.multiply(BigDecimal.valueOf(diff)).multiply(durationHours);
            }
        }

        return normalFare.add(upgradeCharge);
    }
}
