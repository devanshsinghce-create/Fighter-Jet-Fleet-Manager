public class Jet {

    // Possible states of a jet
    public enum Status {
        READY, AIRBORNE, MAINTENANCE
    }

    private String model;
    private int fuel;        // fuel level 0–100
    private Status status;
    private Pilot pilot;     // can be null if no pilot assigned

    public Jet(String model, int fuel) {
        this.model = model;
        this.fuel = fuel;
        this.status = Status.READY;
        this.pilot = null;
    }

    // Assign a pilot to this jet
    public void assignPilot(Pilot pilot) {
        this.pilot = pilot;
        System.out.println("Pilot " + pilot.getName() + " assigned to " + model);
    }

    // Launch the jet into the air
    public void scramble() {
        if (status == Status.MAINTENANCE) {
            System.out.println(model + " is under maintenance. Cannot scramble.");
        } else if (fuel < 20) {
            System.out.println(model + " has low fuel (" + fuel + "%). Refuel first!");
        } else if (pilot == null) {
            System.out.println(model + " has no pilot assigned!");
        } else {
            status = Status.AIRBORNE;
            fuel -= 20; // flying uses fuel
            System.out.println(model + " is now AIRBORNE. Fuel: " + fuel + "%");
        }
    }

    // Land the jet
    public void land() {
        if (status == Status.AIRBORNE) {
            status = Status.READY;
            System.out.println(model + " has landed successfully.");
        } else {
            System.out.println(model + " is not in the air.");
        }
    }

    // Refuel the jet
    public void refuel() {
        if (status == Status.AIRBORNE) {
            System.out.println("Cannot refuel " + model + " while airborne!");
        } else {
            fuel = 100;
            System.out.println(model + " refueled to 100%.");
        }
    }

    // Send jet for maintenance
    public void sendForMaintenance() {
        status = Status.MAINTENANCE;
        System.out.println(model + " sent for maintenance.");
    }

    // Print jet info
    public void printInfo() {
        String pilotName = (pilot != null) ? pilot.getName() : "None";
        System.out.println("  [" + model + "] Status: " + status + " | Fuel: " + fuel + "% | Pilot: " + pilotName);
    }

    public String getModel()  { return model; }
    public int getFuel()      { return fuel; }
    public Status getStatus() { return status; }
}
