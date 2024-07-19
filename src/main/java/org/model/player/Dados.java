package org.model.player;

import java.util.concurrent.ThreadLocalRandom;


public class Dados {
    private static Dados instance;
    private int firstDice;
    private int secondDice;
    private boolean repeated;

    // Constructor privado para evitar instanciación directa
    public Dados() {
        rollDice(); // Inicializar los dados al crear la instancia por primera vez
    }

    // Método estático para obtener la única instancia de DadosSingleton
    public static Dados getInstance() {
        if (instance == null) {
            instance = new Dados(); // Crear la instancia solo si no existe
        }
        return instance;
    }

    public boolean getRepeated(){return this.repeated;}

    public int getFirstDice() {
        return firstDice;
    }

    public int getSecondDice() {
        return secondDice;
    }

    public void rollDice() {
        this.repeated=false;
        this.firstDice = ThreadLocalRandom.current().nextInt(1, 7);
        this.secondDice = ThreadLocalRandom.current().nextInt(1, 7);
        if(firstDice==secondDice){
            repeated=true;
        }
    }

    public boolean dadosIguales(){
        return firstDice==secondDice;
    }

    public int getDiceSum() {
        return this.firstDice + this.secondDice;
    }
}