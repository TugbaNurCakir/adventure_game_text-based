import javax.swing.*;
import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }


    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle())+1;
    }

    @Override
    public boolean onLocation() {
        int obstacleNumber = randomObstacleNumber();
        System.out.println("Now here: "+this.getName());
        System.out.println("Maybe become "+obstacleNumber+" " +this.getObstacle().getName()+" in here!!!!!");
        System.out.println("<W>ar and <R>un");
        String selectCase = input.nextLine().toUpperCase();
        if(selectCase.equals("W") && combat(obstacleNumber)){
                System.out.println("You defeated the enemies.");
                return true;
        }
        if(this.getPlayer().getHealth()<=0){
            System.out.println("You dead.");
            return false;
        }
        return true;
    }

    public boolean combat(int obstacleNumber){
        for(int i = 1; i<=obstacleNumber; i++){
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStatus();
            obstacleStatus(i);
            whoHitFirst();
            while(this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){
                System.out.println("<H>it veya <R>un");
                String selectCombat = input.nextLine().toUpperCase();
                if(selectCombat.equals("H")){
                    System.out.println("You shot...");
                    this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if(this.obstacle.getHealth()>0){
                        System.out.println();
                        System.out.println("The monster hit you.");
                        int obstacleDamage = this.getObstacle().getDamage()-this.getPlayer().getInventory().getWeapon().getDamage();
                        if(obstacleDamage<0){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                        afterHit();
                    }
                }
                else{
                    return false;
                }
            }
            if(this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                System.out.println("You kill enemy.");
                System.out.println("You earn "+this.getObstacle().getAward()+" money");
                this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getObstacle().getAward());
                System.out.println("Your current coin: "+this.getPlayer().getCoin());
            }
            else{
                return false;
            }
        }
        return true;
    }

    public void whoHitFirst(){
        Random r = new Random();
        int random = r.nextInt(2);
        if (random==1) {
            System.out.println("You hit monster.!!");
            this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
        }
        else{
            System.out.println("Monster hit you.!!");
            int obstacleDamage = this.getObstacle().getDamage()-this.getPlayer().getInventory().getWeapon().getDamage();
            if(obstacleDamage<0){
                obstacleDamage = 0;
            }
            this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
        }
    }



    public void afterHit(){
        System.out.println("your health: "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+"'s health: "+this.getObstacle().getHealth());
        System.out.println("----------------");
    }




        public void playerStatus(){
            System.out.println("********The player status: **********");
            System.out.println("Health: "+this.getPlayer().getHealth()
                    +" Damage: "+this.getPlayer().getTotalDamage()
                    +" Coin: "+this.getPlayer().getCoin()
                     +" Weapon: " + getPlayer().getInventory().getWeapon().getName()
                    +" Armor: "+getPlayer().getInventory().getArmor().getName()
                    );
        }
    public void obstacleStatus(int i){
        System.out.println("********The "+i+". obstacle status: **********");
        System.out.println("Health: "+this.getObstacle().getHealth()
                +" Damage: "+this.getObstacle().getDamage()
                +" Weapon: " + getPlayer().getInventory().getWeapon().getName()
                +" Armor: "+getPlayer().getInventory().getArmor().getName()
        );
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
