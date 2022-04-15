public class Rocket implements SpaceShip {

    int cost;
    int weight;
    int maxWeight;
    double launchExplosion;
    double landCrash;
    int currentWeight;

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public int carry(Item item) {
        this.currentWeight += item.weight;
        return this.currentWeight;
    }

    public boolean canCarry(Item item) {

        return this.currentWeight + item.weight <= maxWeight;

    }


}
