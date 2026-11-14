package DesignPattern.RealUseCases.ParkingSystem;

import DesignPattern.RealUseCases.ParkingSystem.fare.FareCalculator;
import DesignPattern.RealUseCases.ParkingSystem.fare.strategy.BaseFareStrategy;
import DesignPattern.RealUseCases.ParkingSystem.fare.strategy.FareStrategy;
import DesignPattern.RealUseCases.ParkingSystem.model.Ticket;
import DesignPattern.RealUseCases.ParkingSystem.model.vehicle.Car;
import DesignPattern.RealUseCases.ParkingSystem.model.vehicle.Vehicle;
import DesignPattern.RealUseCases.ParkingSystem.model.vehicle.VehicleSize;
import DesignPattern.RealUseCases.ParkingSystem.orchestra.ParkingLot;
import DesignPattern.RealUseCases.ParkingSystem.utility.ParkingManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *  This class is used to represent the parking system client which is used to test the parking system
 */
public class ParkingSystemClient {

    public static void main(String[] args) {

        System.out.println("-------Welcome to the Parking System Client---------");

        ParkingManager parkingManager = new ParkingManager();

        FareStrategy fareStrategy = new BaseFareStrategy();

        List<FareStrategy> fareStrategies = new ArrayList<>();
        fareStrategies.add(fareStrategy);

        FareCalculator fareCalculator = new FareCalculator(fareStrategies);

        ParkingLot parkingLot = new ParkingLot(parkingManager, fareCalculator);

        // Create 7 medium cars arriving at the exact same time.
        // This simulates a burst request using threads, not a loop.
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("MEDIUM-1"));
        vehicles.add(new Car("MEDIUM-2"));
        vehicles.add(new Car("MEDIUM-3"));
        vehicles.add(new Car("MEDIUM-4"));
        vehicles.add(new Car("MEDIUM-5"));
        vehicles.add(new Car("MEDIUM-6"));
        vehicles.add(new Car("MEDIUM-7"));

        List<Ticket> tickets = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            Thread thread = new Thread(() -> {
                Ticket ticket = parkingLot.enterVehicle(vehicle);
                synchronized (tickets) {
                    tickets.add(ticket);
                }
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        System.out.println("-------Exiting the vehicles from the Parking System Client---------");

        // Simulate all vehicles exiting after 2 hours.
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                ticket.setExitTimeStamp(ticket.getEntryTimeStamp().plusHours(2));
                parkingLot.exitVehicle(ticket);
            }
        }

        System.out.println("-------Thank you for using the Parking System Client---------");
    }
}
