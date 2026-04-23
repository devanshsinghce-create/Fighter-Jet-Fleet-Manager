public class Main {

    public static void main(String[] args) {

        // --- Create pilots ---
        Pilot p1 = new Pilot("Maverick", 5);
        Pilot p2 = new Pilot("Iceman", 4);
        Pilot p3 = new Pilot("Rooster", 3);

        // --- Create jets ---
        Jet f22  = new Jet("F-22 Raptor", 80);
        Jet f16  = new Jet("F-16 Falcon", 15); // low fuel on purpose
        Jet su57 = new Jet("Su-57 Felon", 60);

        // --- Set up fleet manager ---
        FleetManager manager = new FleetManager();
        manager.addJet(f22);
        manager.addJet(f16);
        manager.addJet(su57);

        System.out.println();

        // --- Assign pilots ---
        f22.assignPilot(p1);
        f16.assignPilot(p2);
        su57.assignPilot(p3);

        // --- Show initial fleet ---
        manager.showFleet();

        // --- Try scrambling all jets ---
        System.out.println("=== Scramble order! ===");
        f22.scramble();   // should work
        f16.scramble();   // should fail - low fuel
        su57.scramble();  // should work

        // --- Check readiness ---
        System.out.println();
        manager.checkReadiness();

        // --- Refuel the F-16 and try again ---
        System.out.println("\nRefueling F-16...");
        f16.refuel();
        f16.scramble(); // now it works

        // --- Send F-22 for maintenance ---
        System.out.println();
        f22.land();
        f22.sendForMaintenance();

        // --- Final fleet state ---
        manager.showFleet();
        manager.checkReadiness();
    }
}
