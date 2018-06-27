package de.htwg.cityyanderecarcassonne.thintui.controller.impl;

import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import de.htwg.cityyanderecarcassonne.thintui.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.thintui.model.ICard;
import de.htwg.cityyanderecarcassonne.thintui.model.IPlayer;
import de.htwg.cityyanderecarcassonne.thintui.model.ITownsquare;

import java.nio.charset.Charset;
import java.util.List;

public class CarcassonneController implements ICarcassonneController {

    private static final ActorSystem system = ActorSystem.create();
    private static final Materializer materializer = ActorMaterializer.create(system);
    private static final String SERVER_URL = "http://localhost:4000/cyc/";


    private String gameStatus;

    public CarcassonneController() {
    }

    private String httpRequest(String rescource) {
        return Http.get(system)
                .singleRequest(HttpRequest.create(SERVER_URL + rescource))
                .toCompletableFuture()
                .join()
                .entity()
                .toStrict(1000, materializer)
                .toCompletableFuture()
                .join()
                .getData()
                .decodeString(Charset.defaultCharset());
    }

    @Override
    public String gameStatus() {
        return httpRequest("gamestatus/");
    }

    @Override
    public void addPlayer(String name) {
        httpRequest("addplayer/" + name);
    }

    @Override
    public void createGame() {
        httpRequest("creategame/");
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
        httpRequest("rotatecard/" + direction);
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
    public void placeCard(String position) {
        httpRequest("placecard/" + position);
    }

    @Override
    public String getMeeplePossibilities() {
        return null;
    }

    @Override
    public void placeMeeple(String position) {
        httpRequest("placemeeple/" + position);
    }

    @Override
    public ITownsquare getTownsquare() {
        return null;
    }

    @Override
    public void finishRound() {
        httpRequest("finishround/");
    }

    @Override
    public void saveGame() {
        httpRequest("savegame/");
    }

    @Override
    public void loadGame(String id) {
        httpRequest("loadgame/" + id);
    }

    @Override
    public String tui() {
        return httpRequest("tui");
    }
}
