# FLYWEIGHT DESIGN PATTERN 

We expect good software code should be extensible, maintainable, scalable

The design patterns, such as

<strong>1. Singleton</strong> </br>
<strong>2. Builder </strong> </br>
<strong>3. Prototype </strong> </br>
<strong>4. Factory </strong> </br>
<strong>5. Adaptor </strong> etc <br>

concentrate on maintainbility, extensibility.

But Flyweight concentrates on scalability, interms of memory.

Suppose in games like Pubg, Freefire, CallOfDuty we see guns, bullets, players, grass, houses etc in huge number.

Create each an instance consumes too much memory.

So, here we use flyweight pattern , which helps in reuse.

Here if we take an example of bullet, bullet image is loaded multiple times, so we just reuse using reference.

For suppose bullet class has Datamembers like

1. X-Coordinate
2. Y-Coordinate
3. Z-Coordinate
4. weight
5. Type
6. color
7. image
8. velocity

So here we decide these attribute to two types

1. Extrinsic 
2. Intrinsic

Here are 
1. <strong>Extrinsic</strong> : Here we need to compulsary create new instance for each.
2. <strong>Intrinsic</strong> : Here we can use reference.

So,
Intrinsic : Type, image, Color, weight
Extrinsic : X,Y,Z-coordinate, velocity, 

```java
// intrinsic class
class Bullet{
    BulletType type;
    Byte[] image;
    String color;
    Integer weight;
}
```

```java
// extrinsic class
class FlyingBullet{
    Double x;
    Double y;
    Double z;
    Double velocity;
    Bullet bullet;
}
```

