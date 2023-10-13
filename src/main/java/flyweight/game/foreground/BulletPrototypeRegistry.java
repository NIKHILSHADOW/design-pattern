package flyweight.game.foreground;

import java.util.HashMap;
import java.util.Map;

public class BulletPrototypeRegistry {
    private static BulletPrototypeRegistry bulletPrototypeRegistry;
    private static Map<BulletType,Bullet> bulletMap = new HashMap<>();

    public static BulletPrototypeRegistry getInstance(){
        if(bulletPrototypeRegistry == null){
            synchronized (BulletPrototypeRegistry.class){
                if (bulletPrototypeRegistry == null){
                    bulletPrototypeRegistry = new BulletPrototypeRegistry();
                }
            }
        }

        return bulletPrototypeRegistry;
    }

    public Bullet getBullet(BulletType type) {
        return bulletMap.get(type);
    }

    public void addBullet(Bullet bullet){
        bulletMap.put(bullet.getType(),bullet);
    }
}
