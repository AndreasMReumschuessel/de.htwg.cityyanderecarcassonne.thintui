package de.htwg.cityyanderecarcassonne.thintui;

import de.htwg.cityyanderecarcassonne.thintui.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.thintui.controller.impl.CarcassonneController;
import de.htwg.cityyanderecarcassonne.thintui.view.tui.TextUI;

public final class CarcassonneThinTUI {
    private ICarcassonneController controller;

    private static CarcassonneThinTUI instance;

    private CarcassonneThinTUI() {
        controller = new CarcassonneController();
    }

    public static CarcassonneThinTUI getInstance() {
        if (instance == null) {
            instance = new CarcassonneThinTUI();
        }
        return instance;
    }

    public static void main(String[] args) {
        CarcassonneThinTUI app = CarcassonneThinTUI.getInstance();

        TextUI tui = new TextUI(app.controller);
        tui.start();
        System.exit(0);
    }
}
