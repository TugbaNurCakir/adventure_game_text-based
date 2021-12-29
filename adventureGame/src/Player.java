import java.util.Scanner;

public class Player {
    private Inventory inventory;
    private int id;
    private int damage;
    private int health;
    private int originalHealth;
    private int coin;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }
    public void selectChar(){
        //Polymorphism
        GameCharacter[] charList = {new Samurai(), new Archer(), new Knight()};
        for (GameCharacter gameChar:  charList) {
            System.out.println("Character ->Name:" +gameChar.getName()+", ID: "+gameChar.getId()+" Damage: "+gameChar.getDamage()+", Health: "+gameChar.getHealth()+", Coin:"+gameChar.getCoin());
        }
        System.out.println("Enter a number to choose a character: ");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());

        }
        System.out.println("Your choosen is : "+this.getCharName()+", Damage: "+this.getDamage()+", Health: "+this.getHealth()+", Coin: "+this.getCoin());

    }

    public void initPlayer(GameCharacter gameChar){
        this.setDamage(gameChar.getDamage());
        this.setCoin(gameChar.getCoin());
        this.setOriginalHealth(gameChar.getHealth());
        this.setCharName(gameChar.getName());
        this.setHealth(gameChar.getHealth());

    }
    public void printInfo(){
        System.out.println(
                "Your weapon: "+
                this.getInventory().getWeapon().getName()+
                        " Your armor: "+
                        this.getInventory().getArmor().getName()+
                ", Your damage: "+this.getTotalDamage()+
                ", Your health: "+this.getHealth()+ ", Your coin: "+this.getCoin());
    }
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage(); //silahlardan hangşisini seçtiysen onun hasarı da üstüne eklenir.
    }

    public int getDamage() {
       return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
