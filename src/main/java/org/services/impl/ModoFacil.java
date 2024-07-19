package org.services.impl;

import org.model.bank.Banco;
import org.model.player.strategyBot.StrategyBotConservador;
import org.model.player.strategyBot.StrategyBotEquilibrado;
import org.services.IModoJuego;
import org.model.player.Bot;
import org.services.IPeon;

import java.util.ArrayList;
import java.util.List;

public class ModoFacil implements IModoJuego {

    private List<IPeon> bots;
    private Bot bot;
    private Bot bot2;

    @Override
    public List<IPeon> getBots(){ return bots;}

    @Override
    public void generateBots() {
        bot = new Bot( "Bot Equilibrado", new StrategyBotEquilibrado());
        bots.add(bot);
        bot2 = new Bot( "Bot Conservador", new StrategyBotConservador());
        bots.add(bot2);

    }

    @Override
    public String showBotsEnemies() {
        return bot.getNombre() + System.lineSeparator() + bot2.getNombre();
    }

   public ModoFacil(){
        this.bots = new ArrayList<IPeon>();
        generateBots();
        showBotsEnemies();
    }
}
