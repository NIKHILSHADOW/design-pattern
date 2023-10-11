# Prototype Design Pattern

Prototype Design pattern, as the name says, we build one prototype, and use it when ever similar instances come.

Let's take general example of prototype design pattern, where we use.

* Assignment submission :
    - The first person creates it.
    - Next we make copies, with little modifications.

<B>We use prototype pattern, when there are huge Computational tasks, to be done, so if we need to create large number of similar objects, instead of performing huge computational tasks everytime, we just create once, next we clone it, and we change it according to requirement</B>

For example, 
In games, we need to 
create background objects like trees, grass, buildings etc.
create foreground objects like human, cars, bikes etc;

so here we need to create similar tree objects or cars in large number, 
so instead of creating new instances each time, we just create one object, and just make clone of it, and change position and use it.

Prototype Design pattern is divided in to two types.
1. Simple Prototype
2. Prototype Registry

<b> 1. Simple Prototype : </b>
It just says create prototype and use it.
It has two steps
1. create a prototype.
2. next time just clone it.

For that we need to follow some steps, here they are
1. Create Clonable interface, which returns our own object.
2. create classes for each prototype, and implement clone method.

```java
// file  - GameObject.java (Cloneable interface)

import java.util.ArrayList;

public interface GameObject {
    public GameObject clone();
}

// file - BackgroundObject.java

public class BackgroundGameObject implements GameObject {

    public BackgroundGameObject() {
        //huge computations
    }

    @Override
    public BackgroundGameObject clone() {
        BackgroundGameObject object = new BackgroundGameObject();
        // copy values from object
        return object;
    }
}

// Foreground.java
public class ForegroundGameObject implements GameObject {

    public ForegroundGameObject() {
        // huge computations
    }

    @Override
    public ForegroundGameObject clone() {
        ForegroundGameObject object = new ForegroundGameObject();
        // copy values from object
        return object;
    }
}

// file - Client.java

public class Client {
    // if we need 1000000 foreground objects
    // so we need object 
    public static void Main(String[] args) {
        // so here we need to create instance for each prototype, in every client classes, or else we need pass object reference
        ForegroundGameObject foregroundGameObject = new ForegroundGameObject();
        List<ForegroundGameObject> foregroundObjects = new ArrayList<>();
        int countOfForegroundObjects = 1000000;
        for(int i=0;i<countOfForegroundObjects;i++){
            foregroundObjects.add(foregroundGameObject.clone());
        
        }
    }
}

```

Here there is one problem, 
What if there are many prototypes.
Can we pass all classes in reference to each class whereever we need, the answer is no.
Can we create instance for first object in each class, the answer is no, because it has huge computational task. which is not good performance wise.

So instead we ask our developer, to take create mapping class for us, so we can directly fetch.

<b> 2. Prototype Registry : </b>
1. Create a Mappper class and define two methods, one for adding prototypes into map, other fetching from map.

```java
import java.util.HashMap;
import java.util.Map;

public class GameObjectRegistry {
    Map<Type, GameObject> gameObjects = new HashMap<>();
    
    public void addPrototype(Type type, GameObject gameObject){
        gameObjects.put(type,gameObject);
    }
    
    public GameObject getPrototype(Type type){
        return gameObjects.get(type);
    }
}
```

// so client directly gets what he need.
```java
public class Client{
    public static void Main(String[] args){
        GameObjectRegistry gameObjectRegistry = new GameObjectRegistry();
        ForegroundObject foregroundObject = gameObjectRegistry.getPrototype(type);
    }
}
```
