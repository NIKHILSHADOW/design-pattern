package prototype.game.application;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ForegroundGameObject implements GameObject{
    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;
    private GameObjectType type;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<Integer> pixels;

    @Override
    public ForegroundGameObject clone(){
        ForegroundGameObject object = new ForegroundGameObject();
        return object;
    }
}
