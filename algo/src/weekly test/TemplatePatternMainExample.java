/**
 * @author trinapal
 */
public class TemplatePatternMainExample {
    public static void main(String[] args) {
        Game game = new Soccer();
        game.play();
        Game game1 = new Chess();
        game1.play();
    }
}
