package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Flight;
import ru.netology.domain.FlightComparator;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {
    private FlightManager manager = new FlightManager();
    FlightComparator value = new FlightComparator();
    private Flight first = new Flight(1, 200, "SVO", "AER", 890);
    private Flight second = new Flight(2, 500, "LED", "GTW", 1300);
    private Flight third = new Flight(3, 300, "SVO", "AER", 880);
    private Flight forth = new Flight(4, 500, "SVO", "GTW", 1380);
    private Flight fifth = new Flight(5, 700, "LED", "VVO", 7300);
    private Flight sixth = new Flight(5, 900, "AER", "VVO", 7500);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
    }

        @Test
    void shouldSearchByAirportsAndSortByPrice() {
        String from = "SVO";
        String to = "AER";
        Flight[] expected = new Flight[]{first, third};
        Flight[] actual = manager.findByAirports(from, to);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAirportsAndSortFromLessToMore() {
        String from = "SVO";
        String to = "AER";
        Flight[] expected = new Flight[]{third, first};
        Flight[] actual = manager.findByDuration(from, to, value);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindOneAirport() {
        String from = "AER";
        String to = "VVO";
        Flight[] expected = new Flight[]{sixth};
        Flight[] actual = manager.findByDuration(from, to, value);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindAirport() {
        String from = "AER";
        String to = "SVO";
        Flight[] expected = new Flight[]{};
        Flight[] actual = manager.findByDuration(from, to, value);
        assertArrayEquals(expected, actual);
    }

}
