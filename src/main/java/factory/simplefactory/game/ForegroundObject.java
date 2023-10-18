package factory.simplefactory.game;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ForegroundObject implements GameObject
{
    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private List<Integer> pixels;

    public static class Builder{
        public ForegroundObject build(){
            ForegroundObject foregroundObject = new ForegroundObject();


            return foregroundObject;
        }
    }
}
