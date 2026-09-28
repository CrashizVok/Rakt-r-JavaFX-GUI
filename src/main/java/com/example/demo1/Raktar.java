package com.example.demo1;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Raktar {
    private final String filePath;

    public Raktar() {
        this("raktar.dat");
    }

    public Raktar(String filePath) {
        this.filePath = filePath;
    }

    public void mentes(List<String> raktar1, List<String> raktar2) throws Exception {
        List<String> sorok = new ArrayList<>();
        for (String elem : raktar1) {
            sorok.add("1;" + elem);
        }
        for (String elem : raktar2) {
            sorok.add("2;" + elem);
        }
        Files.write(Paths.get(filePath), sorok);
    }

    public Map<Integer, List<String>> betoltes() throws Exception {
        Map<Integer, List<String>> adatok = new HashMap<>();
        adatok.put(1, new ArrayList<>());
        adatok.put(2, new ArrayList<>());

        File file = new File(filePath);
        if (!file.exists()) {
            return adatok;
        }

        List<String> sorok = Files.readAllLines(file.toPath());
        for (String sor : sorok) {
            String[] reszek = sor.split(";", 2);
            if (reszek.length == 2) {
                int raktarId = Integer.parseInt(reszek[0].trim());
                if (adatok.containsKey(raktarId)) {
                    adatok.get(raktarId).add(reszek[1]);
                }
            }
        }
        return adatok;
    }
}