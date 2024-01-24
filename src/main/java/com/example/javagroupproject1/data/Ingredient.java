package com.example.javagroupproject1.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ingredients")
public class Ingredient {
    //region Fields

    @DatabaseField(useGetSet = true, generatedId = true)
    private long ID;

    @DatabaseField(useGetSet = true, foreign = true, foreignAutoCreate = true)
    private IngredientName name;

    @DatabaseField(useGetSet = true)
    private String amount;

    //endregion

    //region Properties

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public IngredientName getName() {
        return name;
    }

    public void setName(IngredientName name) {
        this.name = name;
    }

    //endregion
}
