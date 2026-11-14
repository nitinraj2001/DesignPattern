package DesignPattern.RealUseCases.ParkingSystem.fare.strategy;

import DesignPattern.RealUseCases.ParkingSystem.model.Ticket;

import java.math.BigDecimal;

/**
 *  This interface is used to represent the fare strategy which is used to calculate the fare for the parking spot
 */
public interface FareStrategy {
    /**
     *  This method is used to calculate the fare for the parking spot
     * @param ticket object which is used to calculate the fare for the parking spot
     * @return  it returns the fare for the parking spot
     */
    public BigDecimal calculateFare(Ticket ticket);
}
