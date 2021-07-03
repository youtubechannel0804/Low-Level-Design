import model.Game;
import service.impl.GameServiceImpl;

public class App {

    public static void main(String[] args) {
        Game game = new Game(10, 4);
        GameServiceImpl gameService = new GameServiceImpl();
        gameService.play(game);
    }
}
