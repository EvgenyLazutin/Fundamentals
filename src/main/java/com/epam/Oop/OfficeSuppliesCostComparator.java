package com.epam.Oop;

import java.util.Comparator;

public class OfficeSuppliesCostComparator implements Comparator<OfficeSupplies> {

    public int compare(OfficeSupplies a, OfficeSupplies b) {

        return Double.compare(a.getCost(), b.getCost());
    }
}

