package com.wickedwitchwarsaw.recyclerviewcomplexproject.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ZuZ on 2016-09-24.
 */
public class Entity implements Parcelable {

    private int entityId;
    private String entityName;
    private String entityDescription;
    private String entityPicture; //picture url
    private String entityFact;
    private String entityString;

    public Entity(int entityId, String entityName, String entityDescription, String entityPicture, String entityFact, String entityString) {
        this.entityId = entityId;
        this.entityName = entityName;
        this.entityDescription = entityDescription;
        this.entityPicture = entityPicture;
        this.entityFact = entityFact;
        this.entityString = entityString;
    }

    protected Entity(Parcel in) {
        entityId = in.readInt();
        entityName = in.readString();
        entityDescription = in.readString();
        entityPicture = in.readString();
        entityFact = in.readString();
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(entityId);
        parcel.writeString(entityName);
        parcel.writeString(entityDescription);
        parcel.writeString(entityPicture);
        parcel.writeString(entityFact);
        parcel.writeString(entityString);
    }


    public int getEntityId() {
        return entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getEntityDescription() {
        return entityDescription;
    }

    public String getEntityPicture() {
        return entityPicture;
    }

    public String getEntityFact() {
        return entityFact;
    }

    public String getEntityString() {
        return entityString;
    }

    public static final Creator<Entity> CREATOR = new Creator<Entity>() {
        @Override
        public Entity createFromParcel(Parcel in) {
            return new Entity(in);
        }

        @Override
        public Entity[] newArray(int size) {
            return new Entity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

}
