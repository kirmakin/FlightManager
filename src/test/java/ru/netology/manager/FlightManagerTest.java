package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Flight;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {
    private FlightManager manager = new FlightManager();
    private Flight first = new Flight(1, 200, "SVO", "AER", 880);
    private Flight second = new Flight(2, 500, "LED", "GTW", 1300);
    private Flight third = new Flight(3, 300, "SVO", "AER", 880);
    private Flight forth = new Flight(4, 500, "SVO", "GTW", 1380);
    private Flight fifth = new Flight(5, 700, "LED", "VVO", 7300);
    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
    }

    @Test
    void shouldSearchAndSortByAirports() {
        String from = "SVO";
        String to = "AER";
        Flight[] expected = new Flight[]{first, third};
        Flight[] actual = manager.findAllByAirports(from, to);
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchOneAirport() {
        String from = "SVO";
        String to = "GTW";
        Flight[] expected = new Flight[]{forth};
        Flight[] actual = manager.findAllByAirports(from, to);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNoOneAirport() {
        String from = "AER";
        String to = "SVO";
        Flight[] expected = new Flight[]{};
        Flight[] actual = manager.findAllByAirports(from, to);
        assertArrayEquals(expected, actual);
    }

}