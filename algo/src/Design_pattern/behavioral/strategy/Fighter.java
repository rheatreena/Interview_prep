package Design_pattern.behavioral.strategy;

public class Fighter {

   // Composition

    IJump iJump;
    IRoll iRoll;

    Fighter(IJump iJump, IRoll iRoll){
        this.iJump = iJump;
        this.iRoll = iRoll;
    }

    public void kick(){
        System.out.println("default kick is enabled");
    }

    public void roll()
    {
        // delegate to kick behavior
        iRoll.rolling();
    }
    public void jump()
    {

        // delegate to jump behavior
        iJump.jump();
    }
}
