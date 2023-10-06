package prototype.game.application;

public class Application {
    public static void main(String[] args){
        GameRegistry gameRegistry = new GameRegistry();

        ForegroundGameObject foregroundGameObject = new ForegroundGameObject();
        gameRegistry.addPrototype(foregroundGameObject.getType(),foregroundGameObject);

        BackgroundGameObject backgroundGameObject = new BackgroundGameObject(100,100,200,338,GameObjectType.BACK_GROUND);
        gameRegistry.addPrototype(backgroundGameObject.getType(),backgroundGameObject);

        // create instances and add to gameRegistry so client can use,
        // here client will have access to GameObjectType and GameObjectRegistry
        // so client can easily clone
    }
}
