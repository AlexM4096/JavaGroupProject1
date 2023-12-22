package com.example.javagroupproject1.data;

import com.example.javagroupproject1.tools.SerializableImage;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "step-image")
public class StepImage {
    public static final String STEP_ID_FIELD_NAME = "id";

    @DatabaseField(useGetSet = true, generatedId = true)
    private long ID;

    @DatabaseField(useGetSet = true, foreign = true, foreignColumnName = STEP_ID_FIELD_NAME)
    private Step step;

    @DatabaseField(useGetSet = true, dataType = DataType.SERIALIZABLE)
    private SerializableImage image;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public SerializableImage getImage() {
        return image;
    }

    public void setImage(SerializableImage image) {
        this.image = image;
    }
}
