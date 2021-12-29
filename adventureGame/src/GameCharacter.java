public abstract class  GameCharacter {
    private int id;
    private int damage;
    private int health;
    private int coin;
    private String name;

    public GameCharacter(int id, int damage, int health, int coin, String name) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.coin = coin;
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
}
