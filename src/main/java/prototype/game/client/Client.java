package prototype.game.client;

import prototype.game.application.GameObject;
import prototype.game.application.GameObjectType;
import prototype.game.application.GameRegistry;

public class Client {
    public static void main(String[] args){
        // if wanna clone backgroundobject
        GameRegistry gameRegistry = new GameRegistry();
        GameObject backgroundObjectClone = gameRegistry.getPrototype(GameObjectType.BACK_GROUND).clone();

        // if wanna clone foregroundobject
        GameObject foregroundObjectClone = gameRegistry.getPrototype(GameObjectType.FORE_GROUND).clone();
    }
}
