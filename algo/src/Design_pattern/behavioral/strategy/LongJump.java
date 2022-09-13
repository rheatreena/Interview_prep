package Design_pattern.behavioral.strategy;

public class LongJump implements  IJump{
    @Override
    public void jump() {
        System.out.println("Long Jump enabled");
    }
}
