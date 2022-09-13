package Design_pattern.behavioral.strategy;

public class StrategyMain {
    public static void main(String[] args) {
        IRoll tornadoRoll = new TornadoRoll();
        IRoll lightRoll = new LightRoll();
        IJump longJump = new LongJump();
        IJump shortJump = new ShortJump();

        Fighter fighter1 = new Fighter(longJump, tornadoRoll);
        Fighter fighter2  = new Fighter(shortJump, tornadoRoll);
        Fighter fighter3 = new Fighter(shortJump, lightRoll);
        fighter3.kick();
        fighter3.roll();
        fighter2.kick();
        fighter2.jump();
        fighter1.kick();
    }

}
