public class ToolStore extends NormalLocation{

    public ToolStore(Player player) {
        super(player, "Store");
    }
    @Override
    public boolean onLocation(){
        System.out.println("Welcome to store.**********");
        boolean showMenu = true;
        while(showMenu){
            System.out.println("1-Weapons");
            System.out.println("2-Armors");
            System.out.println("3-Exit");
            System.out.print("Your choosen is: ");
            int selectCase =  input.nextInt();
            while(selectCase<1 && selectCase>3){
                System.out.println("Wrong choosen. Try again.");
                selectCase = input.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                case 2:
                    printArmors();
                    buyArmor();
                case 3:
                    System.out.println("We hope you come again.");
                    showMenu=false;
                    break;
            }
        }

        return true;
    }
   public void printWeapon(){
        System.out.println("--------Weapons--------");
        for (Weapon w: Weapon.weapons()){
            System.out.println(w.getId()+ " name: "+w.getName()+" damage: "+w.getDamage()+" price: "+w.getPrice());
        }
       System.out.println("Enter 0 to exit.!!!!");
    }
    public void buyWeapon(){
        System.out.print("Please choose a weapon!!!");
        int selectWeapon = input.nextInt();
        while(selectWeapon<1 || selectWeapon>Weapon.weapons().length){
            System.out.println("Please try again.");
            selectWeapon = input.nextInt();

        }
        if(selectWeapon!=0){
            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeapon);
            if(selectedWeapon!=null){
                if(selectedWeapon.getPrice()>this.getPlayer().getCoin()){
                    System.out.println("Not enough coin to buy any armor.");
                }
                else{
                    System.out.println("You bought "+selectedWeapon.getName());
                    int balance =this.getPlayer().getCoin() - selectedWeapon.getPrice();
                    this.getPlayer().setCoin(balance);
                    System.out.println("Your remaining money: "+getPlayer().getCoin());
                    System.out.println("Previous weapon: "+getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Your current weapon: "+getPlayer().getInventory().getWeapon().getName());
                }
            }
        }


    }
   public void printArmors(){
        System.out.println("--------Armors--------");
       for (Armor a: Armor.armors()){
           System.out.println(a.getId()+ " name: "+a.getName()+" block: "+a.getBlock()+" price: "+a.getPrice());
       }
       System.out.println("Enter 0 to exit.!!!!");
    }
    public void buyArmor(){
        System.out.print("Please choose a armor!!!");
        int selectArmor = input.nextInt();
        while(selectArmor<1 || selectArmor>Armor.armors().length){
            System.out.println("Please try again.");
            selectArmor = input.nextInt();
        }
        if(selectArmor!=0){
            Armor selectedArmor = Armor.getArmorObjById(selectArmor);
            if(selectedArmor != null){
                if(selectedArmor.getPrice()>this.getPlayer().getCoin()){
                    System.out.println("Not enough coin to buy any armor.");
                }
                else{
                    System.out.println("You bought "+selectedArmor.getName());
                    int balance = this.getPlayer().getCoin() - selectedArmor.getPrice();
                    this.getPlayer().setCoin(balance);
                    System.out.println("Your remaining money: "+getPlayer().getCoin());
                    System.out.println("Previous armor: "+getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Your current weapon: "+getPlayer().getInventory().getArmor().getName());
                }

            }
        }


    }
}