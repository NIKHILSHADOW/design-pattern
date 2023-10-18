package factory.simplefactory.game;

import org.jetbrains.annotations.NotNull;

public class Factory {

    public static @NotNull GameObject getInstance(@NotNull Gametype gametype){
        switch (gametype)
        {
            case BACK_GROUND :
            {
                GameObject gameObject = new BackgroundObject();
                return gameObject;
            }
            case FORE_GROUND:
            {
                GameObject gameObject = new ForegroundObject();
                return gameObject;
            }
        }
        throw new RuntimeException("object type Not Found");
    }
}
