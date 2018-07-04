import db.DBConsole;
import db.DBGame;
import db.DBHelper;
import models.Console;
import models.Game;
import models.Genre;
import models.Owner;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Console ps4 =  new Console("Sony", "PS4", "Europe");
        DBHelper.save(ps4);

        Console xbox = new Console("Microsoft", "Xbone", "Europe");
        DBHelper.save(xbox);

        Console nintendo = new Console("Nintendo", "Switch", "Europe");
        DBHelper.save(nintendo);

        Game game1 = new Game("Yakuza Kiwami", Genre.BEATEMUP);
        DBHelper.save(game1);
        Game game2 = new Game("Skyrim", Genre.RPG);
        DBHelper.save(game2);
        Game game3 = new Game("Witcher 3", Genre.RPG);
        DBHelper.save(game3);
        Game game4 = new Game("Splatoon", Genre.FPS);
        DBHelper.save(game4);
        Game game5 = new Game("Street Fighter", Genre.ARCADE);
        DBHelper.save(game5);
        Game game6 = new Game("Assassins Creed: Origins", Genre.RPG);
        DBHelper.save(game6);

        Owner huey = new Owner("Huey", game1);
        DBHelper.save(huey);

        Owner dewey = new Owner("Dewey", game3);
        DBHelper.save(dewey);

        Owner louie = new Owner("Louie", game3);
        DBHelper.save(louie);

        DBGame.addGameToConsole(game1, ps4);
        DBGame.addGameToConsole(game2, ps4);
        DBGame.addGameToConsole(game1, xbox);
        DBGame.addGameToConsole(game2, xbox);
        DBGame.addGameToConsole(game2, nintendo);

        List<Game> gamelist = DBConsole.getGamesOnConsole(ps4);

        List<Console> consolelist = DBGame.getConsolesFromGames(game2);

        List<Owner> gamefans = DBGame.getFansOfGame(game3);

    }
}
