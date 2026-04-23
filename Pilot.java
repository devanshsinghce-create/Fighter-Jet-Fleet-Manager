public class Pilot {

    private String name;
    private int rank; // rank 1 (rookie) to 5 (ace)

    public Pilot(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public void printInfo() {
        System.out.println("  Pilot: " + name + " | Rank: " + rank + "/5");
    }

    public String getName() { return name; }
    public int getRank()    { return rank; }
}
