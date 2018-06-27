package de.htwg.cityyanderecarcassonne.thintui.view.tui;

import de.htwg.cityyanderecarcassonne.thintui.controller.ICarcassonneController;

import java.util.Scanner;

public class TextUI {
    private ICarcassonneController controller;

    public TextUI(ICarcassonneController controller) {
        this.controller = controller;
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        boolean continu = true;
        while (continu) {
            continu = processInput(in.next());
        }
        in.close();
    }

    private boolean processInput(String line) {
        if ("q".equals(line)) {
            printBye();
            return false;
        } else if ("h".equals(line)) {
            printCommands();
        } else if ("c".equals(line)) {
            controller.createGame();
        } else if (line.startsWith("p")) {
            controller.addPlayer(line.substring(1));
        } else if ("fr".equals(line)) {
            controller.finishRound();
        } else if ("rl".equals(line)) {
            controller.rotateCard("left");
        } else if ("rr".equals(line)) {
            controller.rotateCard("right");
        } else if (line.matches("s[A-Z]+")) {
            controller.placeCard(line.replace("s", ""));
        } else if (line.matches("m[A-Z]")) {
            controller.placeMeeple(line.replace("m", ""));
        } else if (line.startsWith("sg")) {
            controller.saveGame();
        } else if (line.startsWith("lg")) {
            controller.loadGame(line.substring(2));
        } else {
            printCommandUnknown();
        }
        printOutln(controller.tui());
        printPrompt();

        return true;
    }

    private void printCommands() {
        printOutln("Commands:");
        printOutln("c:           Create a new Game.");
        printOutln("p[Name]:     Add a Player.");
        printOutln("fr:          Finish current Round.");
        printOutln("rl:          Rotate Card counterclockwise.");
        printOutln("rr:          Rotate Card clockwise.");
        printOutln("h:           Show Yandere-chan\'s command list.");
        printOutln("q:           Quit City Yandere Carcassonne.");
        printOutln("s[Position]: Let Yandere-chan place that card for you on [Position]. E.g. sB places the card on possibility B.");
        printOutln("m[Position]: Yandere-chan will also place your Meeple on [Position]. E.g. mC places the Meeple on possibility C.");
        printOutln("sg:          This will save the game and tells you your ID to load it later.");
        printOutln("lg[ID]:      This lets Yandere-chan load the game with the specific ID.");
    }

    private void printPrompt() {
        printOut("> ");
    }

    private void printCommandUnknown() {
        printOutln("Yandere-chan doesn't know that command. Enter \'h\'");
    }

    private void printBye() {
        printOutln("Thanks for playing! See you later.");
    }

    private void printOutln() {
        printOutln("");
    }

    private void printOutln(String x) {
        printOut(x + '\n');
    }

    private void printOut(String x) {
        System.out.print(x);
    }
}
