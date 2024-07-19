package org.services;

import java.util.List;

public interface IModoJuego {
   void generateBots();
   String showBotsEnemies();
   List<IPeon> getBots();
}

