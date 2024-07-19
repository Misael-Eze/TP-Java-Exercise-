package org.services.impl;

import org.model.bank.Banco;
import org.model.player.Bot;
import org.model.player.strategyBot.StrategyBotAgresivo;
import org.model.player.strategyBot.StrategyBotConservador;
import org.model.player.strategyBot.StrategyBotEquilibrado;
import org.services.IModoJuego;
import org.services.IPeon;

import java.util.ArrayList;
import java.util.List;

public class ModoDificil implements IModoJuego {
    private List<IPeon> bots;
    private Bot bot;
    private  Bot bot2;
    private Bot bot3;
    private Bot bot4;

    @Override
    public List<IPeon> getBots(){ return bots;}

    @Override
    public void generateBots() {
        bot = new Bot("Bot Equilibrado 1", new StrategyBotEquilibrado());
        bots.add(bot);
        bot2 = new Bot( "Bot Conservador", new StrategyBotConservador());
        bots.add(bot2);
        bot3 = new Bot( "Bot Equilibrado 2", new StrategyBotEquilibrado());
        bots.add(bot3);
        bot4 = new Bot("Bot Agresivo", new StrategyBotAgresivo());
        bots.add(bot4);

    }

    @Override
    public String showBotsEnemies() {
        return bot.getNombre() + System.lineSeparator() +
                bot2.getNombre() + System.lineSeparator() +
                bot3.getNombre() + System.lineSeparator() +
                bot4.getNombre();
    }

    public ModoDificil(){
        this.bots = new ArrayList<IPeon>();
        generateBots();
        showBotsEnemies();
    }

}
