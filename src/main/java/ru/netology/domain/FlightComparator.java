package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@NoArgsConstructor
@Data
public class FlightComparator implements Comparator<Flight> {
    @Override
    public int compare(Flight o1, Flight o2) {
        return o1.getDuration() - o2.getDuration();
    }
}
