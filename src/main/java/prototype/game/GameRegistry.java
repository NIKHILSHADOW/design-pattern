package prototype.game;

import java.util.HashMap;
import java.util.Map;

public class GameRegistry {

    Map<GameObjectType,GameObject> values = new HashMap<>();

    public void addPrototype(GameObjectType type, GameObject object){
        values.put(type, object);
    }

    public GameObject getPrototype(GameObjectType type){
        return values.get(type);
    }
}
