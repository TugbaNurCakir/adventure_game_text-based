public class Inventory {
   // private boolean water;
    //private boolean food;
    //private boolean firewood;
    //private String weaponName;
    //  private String armorName;
    //private int weaponDamage;
    //private int armorDefence;
    private Weapon weapon;
    private Armor armor;
/*
    public Inventory(boolean water, boolean food, boolean firewood, String weaponName, String armorName, int weaponDamage, int armorDefence) {
        this.water = water;
        this.food = food;
        this.firewood = firewood;
        this.weaponName = weaponName;
        this.armorName = armorName;
        this.weaponDamage = weaponDamage;
        this.armorDefence = armorDefence;
    }*/

    public Inventory() {
        this.weapon = new Weapon(-1, "Fist",0,0);
        this.armor = new Armor(-1,0,0,"pacavra");
    }


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
