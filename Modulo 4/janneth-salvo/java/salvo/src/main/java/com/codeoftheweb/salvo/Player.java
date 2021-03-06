package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

import javax.persistence.*;
import java.util.*;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
   @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String userName;

    @OneToMany(mappedBy = "player",fetch = FetchType.EAGER)
    //private Set<GamePlayer> gamePlayers;
    Set<GamePlayer> gamePlayers=new LinkedHashSet<>();

    @OneToMany(mappedBy = "player",fetch = FetchType.EAGER)
    Set<Score> scores=new LinkedHashSet<>();

    public Player() {
    }

    public Player(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public void setGamePlayers(Set<GamePlayer> gamePlayers) {
        this.gamePlayers = gamePlayers;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public Map<String,Object> makePlayerDTO(){
        Map<String,Object> dto=new LinkedHashMap<String, Object>();
        dto.put("id",this.getId());
        dto.put("email",this.getUserName());
        return dto;
    }









}
