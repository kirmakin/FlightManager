package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {
    private Flight first = new Flight(1, 100, "SVO", "LED", 700);
    private Flight second = new Flight(2, 600, "SVO", "GTW", 1300);
    private Flight third = new Flight(3, 300, "SVO", "AER", 880);
    private Flight forth = new Flight(4, 500, "GTW", "LED", 1380);
    private Flight fifth = new Flight(5, 700, "SVO", "VVO", 7300);

    @Test
    public void shouldSortByPrice() {
        Flight[] expected = new Flight[]{first, third, forth, second, fifth };
        Flight[] actual = new Flight[]{first, second, third, forth, fifth};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}
