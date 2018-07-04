package db;

import models.Console;
import models.Game;
import models.Owner;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBGame {

    private static Session session;
    private static Transaction transaction;

    public static void addGameToConsole(Game game, Console console){
        console.addGame(game);
        game.addConsole(console);
        DBHelper.update(game);
    }

    public static List<Console> getConsolesFromGames(Game game){
        session = HibernateUtil.getSessionFactory().openSession();

        List<Console> results = null;

        try {
            Criteria cr = session.createCriteria(Console.class);
            cr.createAlias("games", "game");
            cr.add(Restrictions.eq("game.id", game.getId()));
            results = cr.list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return results;
    }

    public static List<Owner> getFansOfGame(Game game) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Owner> results = null;
        try {
            Criteria cr = session.createCriteria(Owner.class);
            cr.add(Restrictions.eq("fav_game", game));
            results =  cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
