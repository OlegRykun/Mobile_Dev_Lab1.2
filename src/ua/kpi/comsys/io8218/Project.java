package ua.kpi.comsys.io8218;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Project {
    public static void main(String[] args) {
        first();
        time();
    }

    public static void first() {
        // Частина 1
        // Дано рядок у форматі "Student1 - Group1; Student2 - Group2; ..."
        String studentsStr = " Дмитренко Олександр - ІП-84; Матвійчук Андрій - ІВ-83; Лесик Сергій - ІО-82;" +
                " Ткаченко Ярослав - ІВ-83; Аверкова Анастасія - ІО-83; Соловйов Даніїл - ІО-83;" +
                " Рахуба Вероніка - ІО-81; Кочерук Давид - ІВ-83; Лихацька Юлія - ІВ-82; Головенець Руслан - ІВ-83;" +
                " Ющенко Андрій - ІО-82; Мінченко Володимир - ІП-83; Мартинюк Назар - ІО-82; Базова Лідія - ІВ-81;" +
                " Снігурець Олег - ІВ-81; Роман Олександр - ІО-82; Дудка Максим - ІО-81; Кулініч Віталій - ІВ-81;" +
                " Жуков Михайло - ІП-83; Грабко Михайло - ІВ-81; Іванов Володимир - ІО-81; Востриков Нікіта - ІО-82;" +
                " Бондаренко Максим - ІВ-83; Скрипченко Володимир - ІВ-82; Кобук Назар - ІО-81; Дровнін Павло - ІВ-83;" +
                " Тарасенко Юлія - ІО-82; Дрозд Світлана - ІВ-81; Фещенко Кирил - ІО-82; Крамар Віктор - ІО-83;" +
                " Іванов Дмитро - ІВ-82";

        System.out.println("Частина 1");

        // Завдання 1
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – відсортований масив студентів, які відносяться до відповідної групи

        // Ваш код починається тут

        ArrayList<String> allList = new ArrayList();
        ArrayList<String> studio81 = new ArrayList<>();
        ArrayList<String> studio82 = new ArrayList<>();
        ArrayList<String> studio83 = new ArrayList<>();
        ArrayList<String> studiv81 = new ArrayList<>();
        ArrayList<String> studiv82 = new ArrayList<>();
        ArrayList<String> studiv83 = new ArrayList<>();
        ArrayList<String> studip83 = new ArrayList<>();
        ArrayList<String> studip84 = new ArrayList<>();

        HashMap<String, ArrayList<String>> studentsGroups = new HashMap<>();
        studentsGroups.put("ІО-81", studio81);
        studentsGroups.put("ІО-82", studio82);
        studentsGroups.put("ІО-83", studio83);
        studentsGroups.put("ІВ-81", studiv81);
        studentsGroups.put("ІВ-82", studiv82);
        studentsGroups.put("ІВ-83", studiv83);
        studentsGroups.put("ІП-83", studip83);
        studentsGroups.put("ІП-84", studip84);

        for (String str : studentsStr.split(";")) {
            allList.add(str);
        }

        for (int i = 0; i < allList.size(); i++) {
            String[] student = allList.get(i).split(" - ");
            //System.out.println(student[i]);  // для перевірки наявності ключа(групи)
            studentsGroups.get(student[1]).add(student[0]);
        }

        for (String group : studentsGroups.keySet()) {
            Collections.sort(studentsGroups.get(group));
        }

        System.out.println();

        // Ваш код закінчується тут

        System.out.println("Завдання 1");
        for (Map.Entry<String, ArrayList<String>> entry : studentsGroups.entrySet())
            System.out.println(entry.getKey() + "  --->  " + entry.getValue());
        System.out.println();

        // Дано масив з максимально можливими оцінками

        int[] points = {12, 12, 12, 12, 12, 12, 12, 16};

        // Завдання 2
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – словник, де:
        // - ключ – студент, який відносяться до відповідної групи
        // - значення – масив з оцінками студента (заповніть масив випадковими значеннями,
        //      використовуючи функцію `randomValue(maxValue: Int) -> Int`)

        // Ваш код починається тут

        HashMap<String, HashMap<String, ArrayList<Integer>>> studentsPoints = new HashMap<>();

        for (String groups : studentsGroups.keySet()) {
            studentsPoints.put(groups, new HashMap<>());
            for (String students : studentsGroups.get(groups)) {
                studentsPoints.get(groups).put(students, new ArrayList<>());
                for (int point : points) {
                    studentsPoints.get(groups).get(students).add(randomValue(point));
                }
            }
        }

        // Ваш код закінчується тут
        System.out.println("Завдання 2");
        for (String group : studentsPoints.keySet()) {
            System.out.println(group);
            for (String students : studentsPoints.get(group).keySet()) {
                System.out.print(students + "  --->  " + "[");
                for (Integer allPoints : studentsPoints.get(group).get(students)) {
                    System.out.print(allPoints + " ");
                }
                System.out.print("]");
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();

        // Завдання 3
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – словник, де:
        //   - ключ – студент, який відносяться до відповідної групи
        //   - значення – сума оцінок студента

        // Ваш код починається тут

        HashMap<String, HashMap<String, Integer>> sumPoints = new HashMap<>();

        for (String group : studentsGroups.keySet()) {
            sumPoints.put(group, new HashMap<>());
            for (String student : studentsGroups.get(group)) {
                int sum = 0;
                for (int summa : studentsPoints.get(group).get(student)) {
                    sum += summa;
                }
                sumPoints.get(group).put(student, sum);
            }
        }

        // Ваш код закінчується тут
        // System.out.println(sumPoints);

        System.out.println("Завдання 3");
        for (String group : sumPoints.keySet()) {
            System.out.println(group);
            for (String students : sumPoints.get(group).keySet()) {
                System.out.print(students + "  --->  " + sumPoints.get(group).get(students) + "\n");
            }
            System.out.println();
        }

        // Завдання 4
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – середня оцінка всіх студентів групи

        // Ваш код починається тут

        HashMap<String, Float> groupAvg = new HashMap<>();

        for (String group : sumPoints.keySet()) {
            float pointsCount = 0;
            int sum = 0;
            for (String student : sumPoints.get(group).keySet()) {
                pointsCount++;
                sum += sumPoints.get(group).get(student);
            }
            groupAvg.put(group, sum / pointsCount);
        }

        // Ваш код закінчується тут
        System.out.println("Завдання 4");
        for (String group : groupAvg.keySet()) {
            System.out.println(group + "  --->  " + groupAvg.get(group));
        }

        System.out.println();

        // Завдання 5
        // Заповніть словник, де:
        // - ключ – назва групи
        // - значення – масив студентів, які мають >= 60 балів

        // Ваш код починається тут

        HashMap<String, ArrayList<String>> passedPerGroup = new HashMap<>();

        for (String group : studentsGroups.keySet()) {
            passedPerGroup.put(group, new ArrayList<>());
            for (String student : studentsGroups.get(group)) {
                if (sumPoints.get(group).get(student) >= 60) {
                    passedPerGroup.get(group).add(student);
                }
            }
        }

        // Ваш код закінчується тут
        System.out.println("Завдання 5");
        for (Map.Entry<String, ArrayList<String>> entry : passedPerGroup.entrySet()) {
            System.out.println(entry.getKey() + "  --->  " + entry.getValue());
        }

        System.out.println();
    }


    public static int randomValue(int maxValue) {
        Random random = new Random();
        switch (random.nextInt(6)) {
            case 1:
                return (int) (maxValue * 0.7);
            case 2:
                return (int) (maxValue * 0.9);
            case 3:
                return maxValue;
            case 4:
                return maxValue;
            case 5:
                return maxValue;
            default:
                return 0;
        }
    }

    private static void time(){
        TimeOR h1 = new TimeOR();
        TimeOR h2 = new TimeOR();
        TimeOR h3 = new TimeOR();
        TimeOR err = new TimeOR();
        System.out.println("Частина 2");
        try {
            h1 = new TimeOR(0, 0, 0);
            h2 = new TimeOR(10, 25, 51);
            h3 = new TimeOR(14, 43, 21);
            err = new TimeOR(23, 65, 73);
            System.out.println("1)" + h1.getTime());
            System.out.println("2)" + h2.getTime());
            System.out.println("3)" + h3.getTime());
            System.out.println("4)" + err.getTime());

            System.out.println("5) Додавання 10:25:51 АМ та 14:43:21 РМ:" + h2.sumTime(h3).getTime());
            System.out.println("6) Віднімання 10:25:51 АМ та 14:43:21 РМ:" + h2.diffTime(h3).getTime());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}