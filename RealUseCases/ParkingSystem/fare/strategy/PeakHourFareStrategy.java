package DesignPattern.RealUseCases.ParkingSystem.fare.strategy;

import DesignPattern.RealUseCases.ParkingSystem.model.Ticket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *  This class is used to represent the peak hour fare strategy which is used to calculate the fare for the parking lot
 *  The peak hour fare strategy is used to calculate the fare for the parking lot based on the vehicle size and the parking duration.
 */
public class PeakHourFareStrategy implements FareStrategy {

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

        BigDecimal peakRate;
        switch (ticket.getVehicle().getVehicleSize()) {
            case SMALL:
                peakRate = new BigDecimal("80.00");
                break;
            case MEDIUM:
                peakRate = new BigDecimal("160.00");
                break;
            case LARGE:
                peakRate = new BigDecimal("240.00");
                break;
            default:
                peakRate = BigDecimal.ZERO;
        }

        // Peak hours are assumed to be 9 AM - 6 PM, which is a common business rule.
        // For this implementation, we are charging a higher hourly rate during that time window.
        LocalDateTime entry = ticket.getEntryTimeStamp();
        LocalDateTime exit = ticket.getExitTimeStamp();
        if (entry == null || exit == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal peakHours = BigDecimal.ZERO;
        LocalDateTime current = entry;
        while (!current.isAfter(exit)) {
            int hour = current.getHour();
            if (hour >= 9 && hour < 18) {
                peakHours = peakHours.add(BigDecimal.ONE);
            }
            current = current.plusHours(1);
        }

        return peakRate.multiply(peakHours);
    }
}
