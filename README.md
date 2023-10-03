# Singleton Design Pattern

This pattern helps creating single instance for a class and using the same instance throughout

* This helps in restricting multiple instances.

* This will be useful in some cases where we creating instances for
1. Shared resources -> DB, logs
2. Single Access Point. -> Configuration files.

Actually we create instance by calling Constructor with new keyword

```java
// file DatabaseConnection.java
public class DatabaseConnection{
    public DatabaseConnection(){
        
    }
}

// Main.java
public class Main{
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        DatabaseConnection databaseConnection1 = new DatabaseConnection();
    }
}
```

In the baove code each time we call constructor new instance is created, we want avoid that
for that
our first step should be constructor hiding
1. Constructor hiding

```java
// file - DatabaseConnection.java

public class DatabaseConnection{
    private DatabaseConnection(){
        
    }
}
```
Here there is no way to create constructor outside class, so we create new method for that.

```java
// file - DatabaseConnection.java
public class DatabaseConnection {
    private DatabaseConnection() {

    }

    public DatabaseConnection getInstance(){
        return new DatabaseConnection();
    }
}
```

but without creating instance we can't call getInstance method, so what we do is just make it static method.
so that we can directly call by classname.methodname();

````java
// file - DatabaseConnection.java

public class DatabaseConnection {
    private DatabaseConnection() {

    }

    public static DatabaseConnection getInstance(){
        return new DatabaseConnection();
    }
}
````

This also doesn't our problem each time we call that method, it will create new instance.
so we keep static variable for that, so that it creates when class is loaded and use it indefinitely.

```java
// file - DatabaseConnection.java

public class DatabaseConnection {
    private static DatabaseConnection instance = new DatabaseConnection();
    private DatabaseConnection(){
        
    }
    
    public DatabaseConnection getInstance(){
        return instance;
    }
}
```

Here it instance is thread safe, as class is loaded only once.

But there is issue here, each time class is loaded it creates an instance, where we dont require also.
This is called early or eager instialisation.

so we need to do lazy intialisation.

```java
// file DatabaseConnection.java
public class DatabaseConnection{
    private static DatabaseConnection instance = null;
    private DatabaseConnection(){
        
    }
    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
```

This solved our lazy intialisation problem and multiple instance creation problem up to some extend, but fails, when we use threads
* It is not threadsafe

Suppose at the starting when instance is null, if 100 threads try to call getInstance method, 
for each thread it will be null, because they execute in parallel.
so 100 instances will be created.

* so for solving threads problems, we need to use locks.
 so we synchronized keyword.

```java
// file DatabaseConnection.java

public  class DatabaseConnection{
    private static DatabaseConnection instance = null;
    
    private DatabaseConnection(){
        
    }
    
    private synchronized static DatabaseConnection getInstance(){
        if(instance == null){
            instance =  new DatabaseConnection();
        }
        return instance;
    }
}
```

It solves problem of multiple threads creating multiple instances. But it is very slow, because,
If suppose if already instance is created, then also it will not allow the getinstance calls. so it is slow.

so what we do is give synchronised when it is null

```java
// file - DatabaseCVonnection.java

public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    private DatabaseConnection(){
        
    }
    
    public static DatabaseConnection getInstance(){
        if(instance == null){
            synchronized (DatabaseConnection.class){
                instance = new DatabaseConnection();
            }
        }
        return instance;
    }
}
```

But here the problem is, if there are 100 threads calling the getinstance function at same time, 
they will check whether the instance is null, yes it is, so now, one by one all threads enter inside crtical section 
and create new instances, which is not solving our problem, by leaking.

so after entering into critical section again we need to check if it is null, double checking.

```java
// file - DatabaseConnection.java

public class DatabaseConnection{
    private static DatabaseConnection instance = null;
    private DatabaseConnection(){
        
    }
    private static DatabaseConnection getInstance(){
        if(instance == null){
            synchronized (DatabaseConnection.class){
                if(instance == null){
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
}
```

So here, there are no more problems

// final code

```java
 // file - DatabaseConnection.java

public class DatabaseConnection {
 private static DatabaseConnection instance =  null;
 private DatabaseConnection(){
     
 }
 public static DatabaseConnection getInstance(){
     if(instance == null){
         synchronized (DatabaseConnection.class){
             if(instance == null){
                 instance = new DatabaseConnection();
             }
         }
     }
     return instance;
 }
}

// Main.java

public class Main{
 public static void main(String[] args) {
  DatabaseConnection databaseConnection, databaseConnection1;
  databaseConnection = DatabaseConnection.getInstance();
  databaseConnection1= DatabaseConnection.getInstance();
  // here both instances are same
 }
}
```