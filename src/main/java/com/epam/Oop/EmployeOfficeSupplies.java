package com.epam.Oop;

import java.util.Comparator;
import java.util.TreeSet;

public class EmployeOfficeSupplies {
    private int id;
    private String nameEmploye;
    private OfficeSupplies[] numberOOfficeSupplies;

    public EmployeOfficeSupplies(int id, String nameEmploye, OfficeSupplies[] numberOOfficeSupplies) {
        this.id = id;
        this.nameEmploye = nameEmploye;
        this.numberOOfficeSupplies = numberOOfficeSupplies;
    }

    double getAllCostOfficeSupplies() {
        double costSum = 0;
        for (OfficeSupplies tmp :
                numberOOfficeSupplies) {
            costSum += tmp.getCost();
        }
        System.out.println("Id: " + id + " Name: " + nameEmploye + " CostAllOfficeSup: " + costSum);
        return costSum;
    }


    public static void main(String[] args) {
        OopTask1Pen pen = new OopTask1Pen(130.04, "Parcer", "Red", 100);
        Stepler stepler = new Stepler(380.4, "Stepler", 20);
        Proofreader proofreader = new Proofreader(46.6, "Pro", "White");
        OfficeSupplies[] naborNovichka = {pen, stepler, proofreader};

        EmployeOfficeSupplies tmp = new EmployeOfficeSupplies(01, "Alex", naborNovichka);
        tmp.getAllCostOfficeSupplies();
        Comparator<OfficeSupplies> pcomp = new OfficeSuppliesNameComparator().thenComparing(new OfficeSuppliesCostComparator());
        TreeSet<OfficeSupplies> naborRuk = new TreeSet(pcomp);
        naborRuk.add(pen);
        naborRuk.add(stepler);
        naborRuk.add(proofreader);
        for (OfficeSupplies p :
                naborRuk) {
            System.out.println(p.getName() + " " + p.getCost());

        }
    }
}
