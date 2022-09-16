package org.example.ComplexSearch;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "title",
        "calories",
        "carbs",
        "fat",
        "image",
        "imageType",
        "protein"
})

public class Result {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("calories")
    private Integer calories;
    @JsonProperty("carbs")
    private String carbs;
    @JsonProperty("fat")
    private String fat;
    @JsonProperty("image")
    private String image;
    @JsonProperty("imageType")
    private String imageType;
    @JsonProperty("protein")
    private String protein;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("calories")
    public Integer getCalories() {
        return calories;
    }

    @JsonProperty("calories")
    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    @JsonProperty("carbs")
    public String getCarbs() {
        return carbs;
    }

    @JsonProperty("carbs")
    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }

    @JsonProperty("fat")
    public String getFat() {
        return fat;
    }

    @JsonProperty("fat")
    public void setFat(String fat) {
        this.fat = fat;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("imageType")
    public String getImageType() {
        return imageType;
    }

    @JsonProperty("imageType")
    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    @JsonProperty("protein")
    public String getProtein() {
        return protein;
    }

    @JsonProperty("protein")
    public void setProtein(String protein) {
        this.protein = protein;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
