package flyweight.game.foreground;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class Bullet {
    private BulletType type;
    private String color;
    private Double weight;
    private Byte[] image;

    private Bullet(){}

    public static class Builder{
        private Bullet bullet;

        private Builder(){
            bullet = new Bullet();
        }

        public static Builder getInstance(){
            return new Builder();
        }

        public Bullet build(){
           Bullet ogBullet;
           BulletPrototypeRegistry instanceOfRegistry = BulletPrototypeRegistry.getInstance();
           ogBullet = instanceOfRegistry.getBullet(bullet.getType());

           if (ogBullet == null){
               synchronized (Builder.class) {
                   if(ogBullet == null) {
                       instanceOfRegistry.addBullet(bullet);
                       ogBullet = bullet;
                   }
               }
           }
           return ogBullet;
        }

        public Builder type(BulletType type){
            bullet.type = type;
            return this;
        }

        public Builder color(String color){
            bullet.color = color;
            return this;
        }

        public Builder weight(Double weight){
            bullet.weight = weight;
            return this;
        }

        public Builder image(Byte[] image){
            bullet.image = image;
            return this;
        }

    }
}
