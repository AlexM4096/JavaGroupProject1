package com.example.javagroupproject1.data;

import com.example.javagroupproject1.Database;
import com.example.javagroupproject1.repository.IEntity;
import com.example.javagroupproject1.tools.SerializableImage;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import javafx.scene.image.Image;

import java.sql.SQLException;
import java.util.List;

@DatabaseTable(tableName = "recipes")
public class Recipe implements IEntity {

    @DatabaseField(useGetSet = true, generatedId = true)
    private long ID;

    @DatabaseField(useGetSet = true)
    private String name;

    @DatabaseField(useGetSet = true, foreign = true, foreignAutoCreate = true)
    private Category category;

    @DatabaseField(useGetSet = true)
    private int portionsAmount;

    @DatabaseField(useGetSet = true)
    private int cookingTimeMinutes;

    @DatabaseField(useGetSet = true)
    private boolean isFavorite;

    @DatabaseField(useGetSet = true, dataType = DataType.SERIALIZABLE)
    private SerializableImage serializableImage;

    public Recipe() {
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPortionsAmount() {
        return portionsAmount;
    }

    public void setPortionsAmount(int portionsAmount) {
        this.portionsAmount = portionsAmount;
    }

    public int getCookingTimeMinutes() {
        return cookingTimeMinutes;
    }

    public void setCookingTimeMinutes(int cookingTimeMinutes) {
        if (cookingTimeMinutes <= 0){
            this.cookingTimeMinutes = 0;
            return;
        }

        this.cookingTimeMinutes = cookingTimeMinutes;
    }

    public boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public SerializableImage getSerializableImage() {
        return serializableImage;
    }

    public void setSerializableImage(SerializableImage serializableImage) {
        this.serializableImage = serializableImage;
    }

    public Image getImage(){
        if(serializableImage == null) return null;

        return serializableImage.getImage();
    }

    public void setImage(Image image){
        if (serializableImage == null)
            serializableImage = new SerializableImage(image);
    }
    public String getCategoryName(){
        if (category == null) return null;

        return category.getName();
    }

    public void setCategoryName(String name){
        if (category == null) category = new Category();

        try {
            if (name != null){
                var a = Database.INSTANCE.daoContext.categoryDao.queryForEq("name", name);
                if (a.isEmpty()){
                    category.setName(name);
                }
                else {
                    category = a.getFirst();
                    category.setName(name);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
