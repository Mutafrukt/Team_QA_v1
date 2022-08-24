package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    GameStore store = new GameStore();
    Player player = new Player("Petya");
    Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Game game2 = store.publishGame("Diablo", "RPG");
    Game game3 = store.publishGame("Warcraft 2", "Стратегия");
    Game game4 = store.publishGame("Ведьмак 2", "RPG");

    @Test
    public void shouldSumGenreIfOneGame() {

        player.installGame(game1);
        player.play(game1, 3);

        int expected = 3;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIFNotPlay() {

        player.installGame(game1);

        int expected = 0;
        int actual = player.sumGenre(game1.getGenre());

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreDifferentTwoGame() {

        player.installGame(game1);
        player.installGame(game2);

        player.play(game1, 3);
        player.play(game2, 4);
        player.play(game2, 4);

        int expected = 8;
        int actual = player.sumGenre(game2.getGenre());

        assertEquals(expected, actual);
    }

}
