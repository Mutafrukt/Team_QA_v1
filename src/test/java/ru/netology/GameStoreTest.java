package ru.netology;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;


import org.junit.jupiter.api.Test;


public class GameStoreTest {

    @Test
    public void shouldAddOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }


    @Test
    public void shouldContainsAddedGameIfOneGame() {

        GameStore store = new GameStore();

        Game game1 = store.publishGame("Blitzkrieg", "strategy");

        Assertions.assertTrue(store.containsGame(game1));
    }

    @Test
    public void shouldContainsAddedGameIfTwoGames() {

        GameStore store = new GameStore();

        Game game1 = store.publishGame("Blitzkrieg", "strategy");
        Game game2 = store.publishGame("Scrum", "office");
        Assertions.assertTrue(store.containsGame(game1));
        Assertions.assertTrue(store.containsGame(game2));

    }

    @Test
    public void shouldContainsAddedGameIfNoGames() {

        GameStore store = new GameStore();

        assertFalse(store.containsGame(null));

    }

    @Test
    public void shouldAddPlayTimeForOnePlayerWithoutRepeat() {

        GameStore store = new GameStore();

        store.addPlayTime("Jerry", 12);

        Assertions.assertEquals(12, store.getSumPlayedTime());
    }

    @Test
    public void shouldAddPlayTimeForOnePlayerIfRepeats() {

        GameStore store = new GameStore();

        store.addPlayTime("Jerry", 12);
        store.addPlayTime("Jerry", 2);
        store.addPlayTime("Jerry", 4);

        Assertions.assertEquals(18, store.getSumPlayedTime());
    }

    @Test
    public void shouldAddPlayTimeForThreePlayers() {

        GameStore store = new GameStore();

        store.addPlayTime("Jerry", 12);
        store.addPlayTime("Max445", 1);
        store.addPlayTime("Frida", 20);

        Assertions.assertEquals(33, store.getSumPlayedTime());
    }

    @Test
    public void shouldGetMostPlayerIfOnePlayer() {

        GameStore store = new GameStore();


        store.addPlayTime("Zoob", 12);

        assertEquals("Zoob", store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayerIfOneHour() {

        GameStore store = new GameStore();


        store.addPlayTime("Zina", 0);
        store.addPlayTime("Mingus", 1);

        assertEquals("Mingus", store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("Nika", 3);
        store.addPlayTime("Zoob", 12);
        store.addPlayTime("Sting", 25);
        store.addPlayTime("FFgfs4411", 2);

        assertEquals("Sting", store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayerIfNoPlayers() {

        GameStore store = new GameStore();

        assertEquals(null, store.getMostPlayer());
    }

    @Test
    public void shouldGetSumPlayedTimeForOnePlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("FFgfs4411", 2);

        assertEquals(2, store.getSumPlayedTime());
    }

    @Test
    public void shouldGetSumPlayedTimeForFivePlayers() {

        GameStore store = new GameStore();

        store.addPlayTime("FFgfs4411", 2);
        store.addPlayTime("Nika", 3);
        store.addPlayTime("Zoob", 12);
        store.addPlayTime("Sting", 25);
        store.addPlayTime("Jerry", 12);

        assertEquals(54, store.getSumPlayedTime());
    }

    @Test
    public void shouldGetSumPlayedTimeIfNoPlayers() {

        GameStore store = new GameStore();

        assertEquals(0, store.getSumPlayedTime());
    }
}
