public class Armor {
    private int id;
    private int block;
    private int price;
    private String name;

    public Armor(int id, int block, int price, String name) {
        this.id = id;
        this.block = block;
        this.price = price;
        this.name = name;
    }
    public static Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1,1,15,"light");
        armorList[1] = new Armor(2,3,25,"medium");
        armorList[2] = new Armor(3,5,40,"heavy");

        return armorList;
    }
    public static Armor getArmorObjById(int id){

        for (Armor a: armors()){
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
