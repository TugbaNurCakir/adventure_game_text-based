import java.util.Scanner;
public class Game {
    private Player player;
    private Location location;
    private Scanner input = new Scanner(System.in);

    /*
    //Constructor method.
    Game(Player player, Location location){
        this.player = player;
        this.location = location;
    }
*/
    //Start method
    public void start() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Adventure Game!!!!!!!!");
        System.out.println("Please enter a name=>");
        String playerName = input.next();
        Player player = new Player(playerName);
        System.out.println("Welcome " + player.getName());
        System.out.println("Choose a character to start game :");
        player.selectChar();
        //player.selectLocation();

       Location location = null;
        while(true){
            player.printInfo();
        System.out.println("Locations");
        System.out.println("1-Safe House");
        System.out.println("2-Tool Store");
        System.out.println("3-Cave. Take care. Maybe become a zombie here.");
        System.out.println("4-Forest. Take care. Maybe become a vampire here.");
        System.out.println("5-River. Take care. Maybe become a bear here.");
        System.out.println("6-Mine. Take care. Maybe become a snake here.");
        System.out.println("0-Exit!");
        System.out.println("Please choose a location");
        int selectLoc = input.nextInt();

        switch (selectLoc){
            case 0:
                location=null;
                break;
            case 1:
                location = new SafeHouse(player);
                break;
            case 2:
                location = new ToolStore(player);
                break;
            case 3:
                location =  new Cave(player);
                break;
            case 4:
                location = new Forest(player);
                break;
            case 5:
                location = new River(player);
                break;
            case 6:
                location = new Coal(player);
            default:
                location = new SafeHouse(player);
        }
        if(location==null){
            System.out.println("Game finished. We hope you come again.!!!!");
            break;
        }

        if(!location.onLocation()){
            System.out.println("game over.");
        }

    }
    }
}
