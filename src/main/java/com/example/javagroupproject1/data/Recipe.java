package com.example.javagroupproject1.data;

import com.example.javagroupproject1.repository.IEntity;
import com.example.javagroupproject1.tools.SerializableImage;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "recipes")
public class Recipe implements IEntity {
    //region Fields

    @DatabaseField(useGetSet = true, generatedId = true)
    private long ID;

    @DatabaseField(useGetSet = true)
    private String name;

    @DatabaseField(useGetSet = true)
    private String category;

    @DatabaseField(useGetSet = true)
    private int difficulty;

    @DatabaseField(useGetSet = true)
    private int cookingTimeMinutes;

    @DatabaseField(useGetSet = true)
    private int grams;

    @DatabaseField(useGetSet = true)
    private int portionsAmount;

    @DatabaseField(useGetSet = true, dataType = DataType.SERIALIZABLE)
    private SerializableImage image;

    //endregion

    //region Constructors

    public Recipe(){

    }

    //endregion

    //region Properties

    @Override
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getCookingTimeMinutes() {
        return cookingTimeMinutes;
    }

    public void setCookingTimeMinutes(int cookingTimeMinutes) {
        this.cookingTimeMinutes = cookingTimeMinutes;
    }

    public int getGrams() {
        return grams;
    }

    public void setGrams(int grams) {
        this.grams = grams;
    }

    public int getPortionsAmount() {
        return portionsAmount;
    }

    public void setPortionsAmount(int portionsAmount) {
        this.portionsAmount = portionsAmount;
    }

    public SerializableImage getImage() {
        return image;
    }

    public void setImage(SerializableImage image) {
        this.image = image;
    }

    //endregion
}
