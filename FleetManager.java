import java.util.ArrayList;
import java.util.List;

public class FleetManager {

    private List<Jet> fleet = new ArrayList<>();

    // Add a jet to the fleet
    public void addJet(Jet jet) {
        fleet.add(jet);
        System.out.println(jet.getModel() + " added to fleet.");
    }

    // Show all jets and their status
    public void showFleet() {
        System.out.println("\n===== FLEET STATUS =====");
        for (Jet jet : fleet) {
            jet.printInfo();
        }
        System.out.println("========================\n");
    }

    // Check overall fleet readiness
    public void checkReadiness() {
        int ready = 0;
        int total = fleet.size();
        for (Jet jet : fleet) {
            if (jet.getStatus() == Jet.Status.READY && jet.getFuel() >= 20) {
                ready++;
            }
        }
        System.out.println("Fleet Readiness: " + ready + "/" + total + " jets combat-ready.");
    }

    // Refuel ALL jets that are on the ground
    public void refuelAll() {
        System.out.println("Refueling all grounded jets...");
        for (Jet jet : fleet) {
            if (jet.getStatus() != Jet.Status.AIRBORNE) {
                jet.refuel();
            }
        }
    }
}
