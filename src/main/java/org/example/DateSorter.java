package org.example;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateSorter {
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        Map<Boolean, List<LocalDate>> partitionedDates = unsortedDates.stream()
                .collect(Collectors.partitioningBy(localDate -> localDate.getMonth()
                        .getDisplayName(TextStyle.FULL, Locale.ENGLISH).contains("r")));

        List<LocalDate> datesWithR = partitionedDates.get(true).stream()
                .sorted()
                .toList();

        List<LocalDate> datesWithoutR = partitionedDates.get(false).stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        return Stream.concat(datesWithR.stream(), datesWithoutR.stream())
                .collect(Collectors.toList());
    }
}