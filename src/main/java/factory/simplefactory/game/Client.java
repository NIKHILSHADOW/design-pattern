package factory.simplefactory.game;

public class Client {
    public static void main(String[] args){
        GameObject gameObject = Factory.getInstance(Gametype.BACK_GROUND);
        System.out.println(gameObject);
    }
}
