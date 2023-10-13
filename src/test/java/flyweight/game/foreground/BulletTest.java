package flyweight.game.foreground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BulletTest {
    Bullet bullet;
    FlyingBullet flyingBullet;

    @BeforeEach
    public void instance(){
        bullet = Bullet.Builder.
                getInstance().
                weight(34.54).
                type(BulletType.BIG).
                color("yellow").
                image(new Byte[4]).
                build();
        flyingBullet = FlyingBullet.Builder.
                builder().
                setX(45.5).
                setY(445.5).
                setZ(43.3).
                bullet(bullet).
                build();
    }

    @Test
    public void bulletTest(){
        Assertions.assertNotNull(bullet);
        Assertions.assertTrue(bullet instanceof Bullet);
        Assertions.assertEquals(bullet,BulletPrototypeRegistry.getInstance().getBullet(bullet.getType()));
    }

    @Test
    public void flyingBulletTest(){
        Assertions.assertNotNull(flyingBullet);
        Assertions.assertTrue(flyingBullet instanceof FlyingBullet);
    }
}
