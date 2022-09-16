package org.example.lesson03;

public class EndPoints extends AbstractTest {
    private static String addMealPlanner = getBaseUrl() + "mealplanner/" + getUsername() + "/shopping-list/items";
    private static String deleteMealPlanner = getBaseUrl() + "mealplanner/" + getUsername() + "/shopping-list/items/";
    private static String getMealPlanner = getBaseUrl() + "mealplanner/" + getUsername() + "/shopping-list";

    private static String complexSearch = getBaseUrl() + "recipes/complexSearch";

    private static String classifyCuisine = getBaseUrl() + "recipes/cuisine";

    public static String getAddMealPlanner() {
        return addMealPlanner;
    }

    public static String getDeleteMealPlanner(int id) {
        return deleteMealPlanner + id;
    }

    public static String getGetMealPlanner() {
        return getMealPlanner;
    }

    public static String getComplexSearch() {
        return complexSearch;
    }

    public static String getClassifyCuisine() {
        return classifyCuisine;
    }
}
