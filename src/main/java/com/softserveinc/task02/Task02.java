package com.softserveinc.task02;

import java.util.*;
import java.util.stream.Collectors;

public class Task02 {

    final static Collection<Employee> EMPLOYEES = Arrays.asList(
            new Employee("Jon", 16, Gender.MAN),
            new Employee("Bob", 23, Gender.MAN),
            new Employee("Susanna", 18, Gender.WOMEN),
            new Employee("Nicola", 65, Gender.MAN),
            new Employee("Alex", 25, Gender.MAN),
            new Employee("Andrea", 21, Gender.WOMEN),
            new Employee("Jack", 33, Gender.MAN),
            new Employee("Andrea", 42, Gender.WOMEN),
            new Employee("Bill", 69, Gender.MAN)
    );

    static List<Employee> ex01() {
        // TODO: find and return list of all male employee with aged 18 to 27 (inclusive)

        List<Employee> middleAge = EMPLOYEES.stream()
                .filter(n -> n.getGender().equals(Gender.MAN))
                .filter(n -> (n.getAge() >= 18 && n.getAge() <= 27))
                .collect(Collectors.toList());

        if (!middleAge.isEmpty()) {
            return middleAge;
        }
        return null;
    }

    static double ex02() {
        // TODO: compute the average age of all male

        OptionalDouble average = EMPLOYEES.stream()
                .filter(n -> n.getGender().equals(Gender.MAN))
                .mapToDouble(n -> n.getAge())
                .average();

        if (average.isPresent()) {
            return average.getAsDouble();
        }
        return 0L;
    }

    static long ex03() {
        // TODO: count how many employees are male aged 18 to 60 and women aged 18 to 55

        long countMen = EMPLOYEES.stream()
                .filter(n -> n.getGender().equals(Gender.MAN))
                .filter(n -> (n.getAge() >= 18 && n.getAge() <= 60))
                .count();

        long countWomen = EMPLOYEES.stream()
                .filter(n -> n.getGender().equals(Gender.WOMEN))
                .filter(n -> (n.getAge() >= 18 && n.getAge() <= 55))
                .count();

        return countMen + countWomen;
    }

    static List<Employee> ex04() {
        // TODO: return the list of employees was sort employee by name in descending order

        List<Employee> sortedByName = EMPLOYEES.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .collect(Collectors.toList());

        if (!sortedByName.isEmpty()) {
            return sortedByName;
        }
        return null;
    }

    static Employee ex05() {
        // TODO: find and return the oldest employee

        Optional<Employee> maxAge = EMPLOYEES.stream().max(Comparator.comparing(n -> n.getAge()));

        if (maxAge.isPresent()) {
            return maxAge.get();
        }
        return null;
    }

    static Employee ex06() {
        // TODO: find and return the youngest employee

        Optional<Employee> minAge = EMPLOYEES.stream().min(Comparator.comparing(Employee::getAge));

        if (minAge.isPresent()) {
            return minAge.get();
        }
        return null;
    }

    public static void main(String[] args) {
        // TODO: you can check your solution here
        System.out.println("ex01() = " + ex01());
        System.out.println("ex02() = " + ex02());
        System.out.println("ex03() = " + ex03());
        System.out.println("ex04() = " + ex04());
        System.out.println("ex05() = " + ex05());
        System.out.println("ex06() = " + ex06());
    }
} 
