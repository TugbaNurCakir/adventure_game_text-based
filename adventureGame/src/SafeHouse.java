public class SafeHouse extends NormalLocation{

    public SafeHouse(Player player) {
        super(player, "Safe house");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in safety house.");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        return true;
    }
}
