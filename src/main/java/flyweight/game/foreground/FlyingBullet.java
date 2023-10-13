package flyweight.game.foreground;

import org.jetbrains.annotations.NotNull;

public class FlyingBullet {
    private Double x;
    private Double y;
    private Double z;
    private Double velocity;
    private Bullet bullet;

    private FlyingBullet(){}

    private void copyTo(FlyingBullet flyingBullet){
        flyingBullet.x = this.x;
        flyingBullet.y = this.y;
        flyingBullet.z = this.z;
        flyingBullet.velocity = this.velocity;
        flyingBullet.bullet = bullet;
    }

    public static class Builder{
        FlyingBullet flyingBullet;
        private Builder(){
            flyingBullet = new FlyingBullet();
        }
        public static Builder builder(){
            return new Builder();
        }

        public FlyingBullet build(){
            FlyingBullet ogBullet = new FlyingBullet();
            flyingBullet.copyTo(ogBullet);
            return ogBullet;
        }
        public  Builder setX(Double x){
            flyingBullet.x = x;
            return this;
        }

        public  Builder setY(Double y){
            flyingBullet.y = y;
            return this;
        }

        public  Builder setZ(Double z){
            flyingBullet.z = z;
            return this;
        }

        public Builder bullet(@NotNull Bullet bullet){
            flyingBullet.bullet = Bullet.Builder.
                    getInstance().
                    color(bullet.getColor()).
                    image(bullet.getImage()).
                    type(bullet.getType()).
                    weight(bullet.getWeight()).
                    build();
            return this;
        }
    }
}
