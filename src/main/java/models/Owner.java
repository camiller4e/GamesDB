package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owners")
public class Owner {
    private int id;
    private String name;
    private Game fav_game;

    public Owner(String name, Game fav_game) {
        this.name = name;
        this.fav_game = fav_game;
    }

    public Owner() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    public Game getFav_game() {
        return fav_game;
    }

    public void setFav_game(Game fav_game) {
        this.fav_game = fav_game;
    }


}
