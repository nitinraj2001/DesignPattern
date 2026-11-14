package DesignPattern.RealUseCases.ParkingSystem.orchestra;

import DesignPattern.RealUseCases.ParkingSystem.fare.FareCalculator;
import DesignPattern.RealUseCases.ParkingSystem.model.Ticket;
import DesignPattern.RealUseCases.ParkingSystem.model.spot.CompactSpot;
import DesignPattern.RealUseCases.ParkingSystem.model.spot.OversizedSpot;
import DesignPattern.RealUseCases.ParkingSystem.model.spot.ParkingSpot;
import DesignPattern.RealUseCases.ParkingSystem.model.spot.RegularSpot;
import DesignPattern.RealUseCases.ParkingSystem.model.vehicle.Vehicle;
import DesignPattern.RealUseCases.ParkingSystem.utility.ParkingManager;

import java.math.BigDecimal;
import java.util.UUID;
import java.time.LocalDateTime;

/**
 *  This class is used to represent the parking lot which is used to park the vehicle
 *  It is a singleton class which is used to manage the parking lot
 */
public class ParkingLot {

    ParkingManager parkingManager;
    FareCalculator fareCalculator;

    public ParkingLot(ParkingManager parkingManager, FareCalculator fareCalculator){
        this.parkingManager = parkingManager;
        this.fareCalculator = fareCalculator;

        // Add all physical parking spots into the manager as soon as the lot is created.
        // This is the correct place because the manager should search only among existing spots.
        parkingManager.addParkingSpot(new CompactSpot("C1"));
        parkingManager.addParkingSpot(new CompactSpot("C2"));
        parkingManager.addParkingSpot(new CompactSpot("C3"));

        parkingManager.addParkingSpot(new RegularSpot("R1"));
        parkingManager.addParkingSpot(new RegularSpot("R2"));
        parkingManager.addParkingSpot(new RegularSpot("R3"));

        parkingManager.addParkingSpot(new OversizedSpot("O1"));
        parkingManager.addParkingSpot(new OversizedSpot("O2"));
    }

    /**
     * This method is used to enter the vehicle in the parking lot
     * 1. Check if the vehicle can be parked in the parking lot
     * 2. If yes, then park the vehicle and generate the ticket
     * 3. If no, then return null
     * 4. If the vehicle is already parked, then return null
     * @param vehicle   object which is used to enter the vehicle in the parking lot
     * @return  it returns the ticket if the vehicle is parked successfully else it returns null
     */
    public Ticket enterVehicle(Vehicle vehicle){
        String vehicleLabel = vehicle.getVehicleSize() + " vehicle [" + vehicle.getLicencePlate() + "]";
        System.out.println("[ParkingLot] Checking availability for " + vehicleLabel);

        ParkingSpot parkingSpot = parkingManager.parkVehicle(vehicle);
        if(parkingSpot != null){
            System.out.println("[ParkingLot] Vehicle accepted: " + vehicleLabel +
                    " assigned to spot " + parkingSpot.getParkingSpotId());

            Ticket ticket = new Ticket("TC-" + UUID.randomUUID(), vehicle, parkingSpot);
            System.out.println("[ParkingLot] Ticket issued: " + ticket.getTicketId() +
                    " | Vehicle: " + vehicleLabel +
                    " | Spot: " + parkingSpot.getParkingSpotId());
            return ticket;
        }
        System.err.println("[ParkingLot] Rejected: " + vehicleLabel + " | no available spot found.");
        return null;
    }

    /**
     *  This method is used to exit the vehicle from the parking lot
     * 1. Check if the vehicle is parked in the parking lot
     * 2. If yes, then exit the vehicle and calculate the fare
     * 3. If no, then return null
     * 4. If the vehicle is not parked, then return null
     * @param ticket    object which is used to exit the vehicle from the parking lot
     */
    public void exitVehicle(Ticket ticket){
        Vehicle vehicle = ticket.getVehicle();
        String vehicleLabel = vehicle.getVehicleSize() + " vehicle [" + vehicle.getLicencePlate() + "]";
        System.out.println("[ParkingLot] Processing exit for " + vehicleLabel);

        if(parkingManager.isVehicleParked(vehicle)){
            parkingManager.unParkVehicle(vehicle);
            ticket.setExitTimeStamp(LocalDateTime.now().plusHours(2));
            BigDecimal fare = fareCalculator.calculateFare(ticket);
            System.out.println("[ParkingLot] Final fare for " + vehicleLabel + " = " + fare);
            System.out.println("[ParkingLot] Exit completed for " + vehicleLabel);
        } else {
            System.err.println("[ParkingLot] Exit rejected: " + vehicleLabel + " is not currently parked.");
        }
    }
}
