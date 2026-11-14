package DesignPattern.RealUseCases.ParkingSystem.fare;

import DesignPattern.RealUseCases.ParkingSystem.fare.strategy.FareStrategy;
import DesignPattern.RealUseCases.ParkingSystem.model.Ticket;

import java.math.BigDecimal;
import java.util.List;

/**
 *  This class is used to represents the fare calculator which is used to calculate the fare for the parking
 */
public class FareCalculator {

    List<FareStrategy> fareStrategies;

    public FareCalculator(List<FareStrategy> fareStrategies) {
        this.fareStrategies = fareStrategies;
    }

    /**
     *  This method is used to calculate the fare for the parking
     * @param ticket object which is used to calculate the fare for the parking
     * @return  it returns the total fare for the parking
     */
    public BigDecimal calculateFare(Ticket ticket) {
        BigDecimal totalFare = BigDecimal.ZERO;
        System.out.println("Calculating fare for ticket: " + ticket.getTicketId() +
                " with vehicle size: " + ticket.getVehicle().getVehicleSize());
        for (FareStrategy fareStrategy : fareStrategies) {
            totalFare = totalFare.add(fareStrategy.calculateFare(ticket));
        }
        return totalFare;

    }
}
