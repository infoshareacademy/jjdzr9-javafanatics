package com.isa.jjdzr.exercise.model;

public class Exercise {


    private Integer exercisePoints;
    private String exerciseName;
    private String description;
    private String url;

    private String category;
    public Exercise() {
    }
//TODO
    public Exercise(String exerciseName, Integer exercisePoints) {
        this.exerciseName = exerciseName;
        this.exercisePoints = exercisePoints;
    }

    public Integer getExercisePoints() {
        return exercisePoints;
    }

    public void setExercisePoints(Integer exercisePoints) {
        this.exercisePoints = exercisePoints;
    }

    String addingExercisesInfo = "This will be the Adding Exercises Class";


    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddingExercisesInfo() {
        return addingExercisesInfo;
    }

    public void setAddingExercisesInfo(String addingExercisesInfo) {
        this.addingExercisesInfo = addingExercisesInfo;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

}
