package Design_pattern.behavioral.strategy;

public class LightRoll implements IRoll{

    @Override
    public void rolling() {
        System.out.println("Light roll enabled");
    }
}
