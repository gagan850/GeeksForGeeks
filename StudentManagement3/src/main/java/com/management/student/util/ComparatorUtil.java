package com.management.student.util;

import java.util.Comparator;

import comparator.AddressAscComparator;
import comparator.AddressDescComparator;
import comparator.AgeAscComparator;
import comparator.AgeDescComparator;
import comparator.NameAscComparator;
import comparator.NameDescComparator;
import comparator.RollAscComparator;
import comparator.RollDescComparator;

public class ComparatorUtil {


    /**
     * Gets the comparator.
     *
     * @param column the column
     * @param dir the dir
     * @return the comparator
     */
    public static Comparator getComparator (int column, int dir) {

        Comparator comparator;
        if (dir == 0) {

            if (column == 0) {
                comparator = new RollAscComparator();

            } else if (column == 1) {
                comparator = new NameAscComparator();
            } else if (column == 1) {
                comparator = new AgeAscComparator();
            } else {
                comparator = new AddressAscComparator();
            }
        } else {

            if (column == 0) {
                comparator = new RollDescComparator();
            } else if (column == 1) {
                comparator = new NameDescComparator();
            } else if (column == 1) {
                comparator = new AgeDescComparator();
            } else {
                comparator = new AddressDescComparator();
            }
        }
        return comparator;

    }
}
