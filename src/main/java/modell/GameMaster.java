package modell;

import dao.PlayerEntity;
import dao.PlayerEntityDAOImpl;

public class GameMaster {


    private final Player player;

    private final Ai ai;

    public GameMaster(){
        this.ai = new Ai();
        this.player = new Player();
    }

    public Player getPlayer() {
        return player;
    }

    public Ai getAi() {
        return ai;
    }


}
