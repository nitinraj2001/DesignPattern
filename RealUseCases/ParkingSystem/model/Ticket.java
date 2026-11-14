package DesignPattern.RealUseCases.ParkingSystem.model;

import DesignPattern.RealUseCases.ParkingSystem.model.spot.ParkingSpot;
import DesignPattern.RealUseCases.ParkingSystem.model.vehicle.Vehicle;
import DesignPattern.RealUseCases.ParkingSystem.model.vehicle.VehicleSize;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *  This class is used to represents the ticket which is used to park the vehicle in the parking lot
 */
public class Ticket {

    final String ticketId;
    Vehicle vehicle;
    ParkingSpot parkingSpot;
    LocalDateTime entryTimeStamp;
    LocalDateTime exitTimeStamp;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot) {
        this.entryTimeStamp = LocalDateTime.now();
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = spot;
        this.exitTimeStamp = null;
    }

    /**
     *  This method is used to get the ticket id
     * @return  it returns the ticket id
     */
    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public LocalDateTime getExitTimeStamp() {
        return exitTimeStamp;
    }

    public void setExitTimeStamp(LocalDateTime exitTimeStamp) {
        this.exitTimeStamp = exitTimeStamp;
    }

    /**
     *  This method is used to calculate the parking duration
     *  @return it returns the parking duration in hours
     */
    public BigDecimal calculateParkingDuration() {
        if (exitTimeStamp == null) {
            return BigDecimal.ZERO;
        }

        // Implementation for calculating parking duration
        System.out.println("Calculating parking duration for ticket: " + ticketId +
                " with entry time: " + entryTimeStamp + " and exit time: " + exitTimeStamp);
        long minutes = java.time.Duration.between(entryTimeStamp, exitTimeStamp).toMinutes();
        return BigDecimal.valueOf(minutes).divide(BigDecimal.valueOf(60), 2, java.math.RoundingMode.HALF_UP);
    }
}
