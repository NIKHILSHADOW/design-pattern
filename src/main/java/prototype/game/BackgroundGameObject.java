package prototype.game;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BackgroundGameObject implements GameObject{
    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;
    private GameObjectType type;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<Integer> pixels;

    public BackgroundGameObject(Integer x, Integer y, Integer width, Integer height, GameObjectType type){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;

        this.pixels = hugeComputationalMethod();
    }

    private List<Integer> hugeComputationalMethod() {
        // huge logics

        return Collections.emptyList();
    }

    @Override
    public BackgroundGameObject clone(){
        BackgroundGameObject object = new BackgroundGameObject();
        object.x = this.x;
        object.y = this.y;
        object.height = this.height;
        object.width = this.width;
        object.type = this.type;
        object.pixels = this.pixels;

        return object;
    }
}
