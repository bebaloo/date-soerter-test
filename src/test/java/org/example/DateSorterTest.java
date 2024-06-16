package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateSorterTest {
    private final DateSorter dateSorter = new DateSorter();
    private final List<LocalDate> unsortedDates = List.of(
            LocalDate.of(2004, 7, 1),
            LocalDate.of(2005, 1, 2),
            LocalDate.of(2007, 1, 1),
            LocalDate.of(2032, 5, 3));

    private final Collection<LocalDate> expectedDates = List.of(
            LocalDate.of(2005, 1, 2),
            LocalDate.of(2007, 1, 1),
            LocalDate.of(2032, 5, 3),
            LocalDate.of(2004, 7, 1));

    @Test
    void shouldSortDates() {
        Collection<LocalDate> actualDates = dateSorter.sortDates(unsortedDates);
        assertEquals(actualDates, expectedDates);
    }
}