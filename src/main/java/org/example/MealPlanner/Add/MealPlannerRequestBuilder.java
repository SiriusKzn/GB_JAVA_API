package org.example.MealPlanner.Add;

public class MealPlannerRequestBuilder {
    private String item;
    private String aisle;
    private boolean parse;

    public MealPlannerRequestBuilder setItem(String title) {
        this.item = title;
        return this;
    }

    public MealPlannerRequestBuilder setAisle(String aisle) {
        this.aisle = aisle;
        return this;
    }

    public MealPlannerRequestBuilder setParse(boolean parse) {
        this.parse = parse;
        return this;
    }

    public MealPlannerRequest createMealPlannerRequest() {
        return new MealPlannerRequest(item, aisle, parse);

    }
}
