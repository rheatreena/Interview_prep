package Design_pattern.behavioral.strategy;

public class ShortJump implements IJump{
    @Override
    public void jump() {
        System.out.println("Short Jump enabled");
    }
}
