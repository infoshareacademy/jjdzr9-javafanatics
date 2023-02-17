
package com.isa.jjdzr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;

    class AddExcercises {

        private static final List<Exercises> exercise = new ArrayList<>();

        static void createExercises() {
            Exercises exercise = new Exercises();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                List<Exercises> usersList = objectMapper.readValue
                        (new File("src/main/resources/exercises.json"), new TypeReference<>() {
                        });
                exercise.addAll(usersList);
            } catch (IOException ignored) {
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj nazwe cwiczenia");
            String exerciseName = scanner.nextLine();
            List<String> listOfExercisesName = exercise.stream().map(Exercises::getName).toList();
            while (listOfExercisesName.contains(Name) || exerciseName.length() > 10 || exerciseName.length() < 2) {
                if (listOfExercisesName.contains(exerciseName)) {
                    System.out.println("Ta nazwa cwiczenia już istnieje");
                    exerciseName = scanner.nextLine();
                } else if (exerciseName.length() > 10) {
                    System.out.println("Nazwa cwiczenia jest zbyt długa. Maksymalnie 10 znaków");
                    exerciseName = scanner.nextLine();
                } else {
                    System.out.println("Nazwa cwiczenia jest zbyt krótka. Conajmniej 2 znaki");
                    exerciseName = scanner.nextLine();
                }
            }
            Exercises.setName(Name);
            System.out.println("Stwórz opis");
            String description = scanner.nextLine();

            Exercises;
            System.out.println("Podaj adres email");
            String email = scanner.nextLine();
            List<String> listOfEmails = users.stream().map(User::getUserEmail).toList();
            while (listOfEmails.contains(email) || email.length() < 6 || !email.contains("@") || !email.contains(".")) {
                if (listOfEmails.contains(email)) {
                    System.out.println("Ten adres email posiada już konto. Proszę użyc inny adres email.");
                    email = scanner.nextLine();
                } else {
                    System.out.println("To nie jest adres email");
                    email = scanner.nextLine();
                }
            }
            user.setUserEmail(email);
            System.out.println("Utworzono użytkownika '" + user.getUserName() + "'");
            users.add(user);
            try {
                objectMapper.writeValue(new FileWriter
                        ("src/main/resources/user.json"), users);
            } catch (IOException e) {
                System.out.println("Nie można utworzyć użytkownika");
            }
        }
    }
}