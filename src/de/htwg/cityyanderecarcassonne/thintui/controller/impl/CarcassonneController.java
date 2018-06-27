package de.htwg.cityyanderecarcassonne.thintui.controller.impl;

import de.htwg.cityyanderecarcassonne.thintui.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.thintui.model.ICard;
import de.htwg.cityyanderecarcassonne.thintui.model.IPlayer;
import de.htwg.cityyanderecarcassonne.thintui.model.ITownsquare;

import java.util.List;

public class CarcassonneController implements ICarcassonneController {

    private String gameStatus;

    @Override
    public String gameStatus() {
        return null;
    }

    @Override
    public void addPlayer(String name) {

    }

    @Override
    public void createGame() {

    }

    @Override
    public IPlayer getCurrentPlayer() {
        return null;
    }

    @Override
    public List<IPlayer> getAllPlayers() {
        return null;
    }

    @Override
    public ICard getCurrentCard() {
        return null;
    }

    @Override
    public void rotateCard(String direction) {

    }

    @Override
    public int getRemainingCards() {
        return 0;
    }

    @Override
    public String getCardPossibilities() {
        return null;
    }

    @Override
    public void placeCard(String selector, String position) {

    }

    @Override
    public String getMeeplePossibilities() {
        return null;
    }

    @Override
    public ITownsquare getTownsquare() {
        return null;
    }

    @Override
    public void finishRound() {

    }

    @Override
    public String saveGame() {
        return null;
    }

    @Override
    public void loadGame(String id) {

    }
}
