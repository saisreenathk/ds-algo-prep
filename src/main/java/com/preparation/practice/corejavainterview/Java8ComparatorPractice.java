package com.preparation.practice.corejavainterview;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8ComparatorPractice {



    @Getter
    @Setter
    @Builder
    @ToString
    private static class Pair<K,V>{
        K key;
        V value;
    }

    public static void main(String[] args){
        List<Pair<Integer,Integer>> list = new ArrayList<>();
        list.add(Pair.<Integer, Integer>builder().key(5).value(0).build());
        list.add(Pair.<Integer, Integer>builder().key(4).value(1).build());
        list.add(Pair.<Integer, Integer>builder().key(3).value(2).build());
        list.add(Pair.<Integer, Integer>builder().key(2).value(3).build());
        list.add(Pair.<Integer, Integer>builder().key(1).value(4).build());

        List<Pair<Integer,Integer>> sortedList = sortPairs(list);
        System.out.println(sortedList);

    }

    private static List<Pair<Integer, Integer>> sortPairs(List<Pair<Integer, Integer>> list) {
        Comparator<Pair<Integer,Integer>> comparator = Comparator.comparing(Pair::getValue);
        return list.stream().sorted(comparator).collect(Collectors.toList());
    }
            /*
            sample for reference:
                     Comparator<ExportFlattenedResultRow> flattenedResultRowComparator = Comparator
                        .comparing(ExportFlattenedResultRow::getPartNumber)
                        .thenComparing(ExportFlattenedResultRow::getRevisionScheduledPushDate,
                                        Comparator.nullsLast(Comparator.naturalOrder()))
                        .thenComparing(ExportFlattenedResultRow::getGeo,
                                        Comparator.nullsLast(Comparator.naturalOrder()))
                        .thenComparing(ExportFlattenedResultRow::getSegment,
                                        Comparator.nullsLast(Comparator.naturalOrder()))
                        .thenComparing(ExportFlattenedResultRow::getChannel,
                                        Comparator.nullsLast(Comparator.naturalOrder()));
             */
}
