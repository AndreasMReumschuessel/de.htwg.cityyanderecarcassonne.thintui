package de.htwg.cityyanderecarcassonne.thintui.controller;

import de.htwg.cityyanderecarcassonne.thintui.model.ICard;
import de.htwg.cityyanderecarcassonne.thintui.model.IPlayer;
import de.htwg.cityyanderecarcassonne.thintui.model.ITownsquare;

import java.util.List;

public interface ICarcassonneController {
    String gameStatus();

    void addPlayer(String name);

    void createGame();

    IPlayer getCurrentPlayer();

    List<IPlayer> getAllPlayers();

    ICard getCurrentCard();

    void rotateCard(String direction);

    int getRemainingCards();

    String getCardPossibilities();

    void placeCard(String position);

    String getMeeplePossibilities();

    void placeMeeple(String position);

    ITownsquare getTownsquare();

    void finishRound();

    void saveGame();

    void loadGame(String id);

    String tui();
}
