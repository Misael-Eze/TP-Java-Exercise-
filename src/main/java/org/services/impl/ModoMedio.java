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

public class ModoMedio implements IModoJuego {
    private List<IPeon> bots;
    private Bot bot;
    private Bot bot2;
    private Bot bot3;

    @Override
    public List<IPeon> getBots(){ return bots;}

    @Override
    public void generateBots() {
        bot = new Bot( "Bot Equilibrado", new StrategyBotEquilibrado());
        bot.setNombre("Bot 1");
        bots.add(bot);

        bot2 = new Bot( "Bot Conservador", new StrategyBotConservador());
        bot2.setNombre("Bot 2");

        bots.add(bot2);
        bot3 = new Bot("Bot Agresivo", new StrategyBotAgresivo());
        bot3.setNombre("Bot 3");
        bots.add(bot3);

    }

    @Override
    public String showBotsEnemies() {
        return bot.getNombre() + System.lineSeparator() +
                bot2.getNombre() + System.lineSeparator() +
                bot3.getNombre() ;
    }

    public ModoMedio(){
        this.bots = new ArrayList<IPeon>();
        generateBots();
        showBotsEnemies();
    }

}
