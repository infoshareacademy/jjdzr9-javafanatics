package com.isa.jjdzr.exercise.service;

import com.isa.jjdzr.exercise.model.Exercise;
import com.isa.jjdzr.user.service.AdvancementLevelCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RandomExerciseGenerator {
    private static final double indicatorOfWarmUp = 0.2;
    private static final double indicatorOfCoreExercises = 0.6;
    private static final double indicatorOfStretching = 0.2;


    public List<Exercise> generateRandomExercises(int userLevel, List<Exercise> exercises) {
        List<Exercise> exerciseList = new ArrayList<>();
        double warmUpPoints = userLevel * indicatorOfWarmUp;
        double coreExercisesPoints = userLevel * indicatorOfCoreExercises;
        double stretchingPoints = userLevel * indicatorOfStretching;
        if (userLevel != 0) {
            exerciseList.addAll(fillExerciseList(ExerciseDataBase.
                    findExerciseByCategory(ExerciseCategory.WARM_UP, exercises), warmUpPoints));
            exerciseList.addAll(fillExerciseList(ExerciseDataBase.findExerciseByCategory(ExerciseCategory.CORE_EXERCISES, exercises), coreExercisesPoints));
            exerciseList.addAll(fillExerciseList(ExerciseDataBase.findExerciseByCategory(ExerciseCategory.STRETCHING, exercises), stretchingPoints));
        } else {
            System.out.println("Proszę wykonać: Test poziomu zaawansowania");
        }
        return exerciseList;
    }

    private List<Exercise> fillExerciseList(List<Exercise> exerciseByCategory, double exercisePoints) {
        List<Integer> drawnIndexes = new ArrayList<>();
        List<Exercise> exerciseList = new ArrayList<>();
        double counter = 0.0;
        while (counter < exercisePoints) {
            int indexDrawn = drawIndex(exerciseByCategory);
            if (!drawnIndexes.contains(indexDrawn)) {
                drawnIndexes.add(indexDrawn);
                Exercise exerciseDrawn = exerciseByCategory.get(indexDrawn);
                counter = counter + exerciseDrawn.getExercisePoints();
                exerciseList.add(exerciseDrawn);
            }
        }
        return exerciseList;
    }

    private int drawIndex(List<Exercise> warmUpList) {
        Random generator = new Random();
        int indexDrawn = 0;
        for (int i = 0; i < warmUpList.size(); i++) {
            indexDrawn = generator.nextInt(warmUpList.size());
        }
        return indexDrawn;
    }

    public int convertAdvancementLevel(AdvancementLevelCategory category) {
        if (category == null) {
            return 0;
        } else if (category.equals(AdvancementLevelCategory.BEGINNER)) {
            return 50;
        } else if (category.equals(AdvancementLevelCategory.ADVANCE)) {
            return 100;
        } else {
            return 150;
        }
    }
}