package company;

public class Game{
    Player player;
    public Map map;
    public Game(Map map){
        this.map = map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void addPlayer(Player player){
        this.player = player;
        player.setMap(this.map);
        player.getPosition();
    }
}
