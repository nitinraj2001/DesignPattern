package DesignPattern.RealUseCases.ParkingSystem.utility;

import DesignPattern.RealUseCases.ParkingSystem.model.spot.ParkingSpot;
import DesignPattern.RealUseCases.ParkingSystem.model.vehicle.Vehicle;
import DesignPattern.RealUseCases.ParkingSystem.model.vehicle.VehicleSize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  This class is used to represents the parking manager which is used to manage the parking system
 */
public class ParkingManager {

    /**
     * Stores available parking spots grouped by vehicle size.
     * Example: SMALL -> [compactSpot1, compactSpot2]
     */
    private final Map<VehicleSize, List<ParkingSpot>> availableSlots;

    /**
     * Tracks which vehicle is currently parked in which spot.
     */
    private final Map<Vehicle, ParkingSpot> mapVehicleToSpot;

    public ParkingManager() {
       // Initialize the map for each supported vehicle size.
       availableSlots = new HashMap<>();
       for (VehicleSize vehicleSize : VehicleSize.values()) {
           availableSlots.put(vehicleSize, new ArrayList<>());
       }

       // Keep a track of parked vehicles so we can find them later.
       mapVehicleToSpot = new HashMap<>();
    }

    /**
     * Adds a new parking spot to the manager.
     * This is called by the ParkingLot when the lot is created.
     * Without this, the manager has no spots to search in.
     */
    public void addParkingSpot(ParkingSpot parkingSpot) {
       VehicleSize spotSize = parkingSpot.getParkingSpotSize();
       availableSlots.computeIfAbsent(spotSize, key -> new ArrayList<>()).add(parkingSpot);
    }

    /**
     * Adds multiple parking spots at once.
     */
    public void addParkingSpots(List<ParkingSpot> parkingSpots) {
       for (ParkingSpot parkingSpot : parkingSpots) {
           addParkingSpot(parkingSpot);
       }
    }

    /**
     * Finds an available spot for the given vehicle.
     * We first try the exact vehicle size.
     * If no exact-size spot is available, we try larger spots.
     * A smaller spot must never be considered for a larger vehicle.
     */
    public synchronized ParkingSpot findSpotForVehicle(Vehicle vehicle) {
       String vehicleLabel = vehicle.getVehicleSize() + " vehicle [" + vehicle.getLicencePlate() + "]";
       System.out.println("[ParkingManager] Searching for a spot for " + vehicleLabel);

       // 1. Exact size match first
       List<ParkingSpot> exactSpots = availableSlots.get(vehicle.getVehicleSize());
       if (exactSpots != null) {
           for (ParkingSpot spot : exactSpots) {
               System.out.println("[ParkingManager] Checking exact-size spot: " + spot.getParkingSpotId() +
                       " for " + vehicleLabel);

               if (spot.isParkingSpotAvailable(vehicle)) {
                   System.out.println("[ParkingManager] Exact match available: " + spot.getParkingSpotId() +
                           " for " + vehicleLabel);
                   return spot;
               }
           }
       }

       System.out.println("[ParkingManager] No exact-size slot found for " + vehicleLabel +
               ". Checking compatible larger spots...");

       // 2. Try only larger sizes, not smaller ones.
       VehicleSize requestedSize = vehicle.getVehicleSize();
       for (VehicleSize size : VehicleSize.values()) {
           if (size.ordinal() <= requestedSize.ordinal()) {
               continue;
           }

           List<ParkingSpot> compatibleSpots = availableSlots.get(size);
           if (compatibleSpots == null) {
               continue;
           }

           for (ParkingSpot spot : compatibleSpots) {
               if (spot.isParkingSpotAvailable(vehicle)) {
                   System.out.println("[ParkingManager] Compatible larger slot found: " + spot.getParkingSpotId() +
                           " for " + vehicleLabel);
                   return spot;
               }
           }
       }

       System.err.println("[ParkingManager] No compatible spot available for " + vehicleLabel);
       return null;
    }

    /**
     * Parks a vehicle in an available spot.
     * The spot is selected using findSpotForVehicle(), then the vehicle is mapped to that spot.
     */
    public synchronized ParkingSpot parkVehicle(Vehicle vehicle) {
       String vehicleLabel = vehicle.getVehicleSize() + " vehicle [" + vehicle.getLicencePlate() + "]";
       System.out.println("[ParkingManager] Attempting to park " + vehicleLabel);

       ParkingSpot spot = findSpotForVehicle(vehicle);
       if (spot != null) {
           System.out.println("[ParkingManager] Assigning " + vehicleLabel + " to spot " + spot.getParkingSpotId());
           spot.occupyParkingSpot(vehicle);
           mapVehicleToSpot.put(vehicle, spot);
           availableSlots.get(spot.getParkingSpotSize()).remove(spot);
           System.out.println("[ParkingManager] Parking confirmed: " + vehicleLabel + " -> " + spot.getParkingSpotId());
           return spot;
       }

       System.err.println("[ParkingManager] Parking failed: no available spot for " + vehicleLabel);
       return null;
    }

    /**
     *  This method is used to unpark the vehicle from the parking spot
     * @param vehicle object which is used to unpark the vehicle from the parking spot
     */
    public synchronized void unParkVehicle(Vehicle vehicle){
        String vehicleLabel = vehicle.getVehicleSize() + " vehicle [" + vehicle.getLicencePlate() + "]";
        System.out.println("[ParkingManager] Removing " + vehicleLabel + " from the lot");

        ParkingSpot parkingSpot = mapVehicleToSpot.get(vehicle);
        if(parkingSpot != null){
            parkingSpot.vacateParkingSpot(vehicle);
            mapVehicleToSpot.remove(vehicle);
            availableSlots.get(parkingSpot.getParkingSpotSize()).add(parkingSpot);
            System.out.println("[ParkingManager] Vehicle exited: " + vehicleLabel +
                    " from spot " + parkingSpot.getParkingSpotId() +
                    ". Spot is now available.");
        } else {
            System.out.println("[ParkingManager] Vehicle not found in active parking map: " + vehicleLabel);
        }
    }

    /**
     *  This method is used to check if the vehicle is parked in the parking spot
     * @param vehicle   object which is used to check if the vehicle is parked in the parking spot
     * @return  it returns true if the vehicle is parked in the parking spot, otherwise false
     */
    public synchronized boolean isVehicleParked(Vehicle vehicle) {
        return mapVehicleToSpot.containsKey(vehicle);
    }
}
