
package com.chachaup.iprofile.models;

import javax.annotation.Generated;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Id implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private Object value;
    public final static Creator<Id> CREATOR = new Creator<Id>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Id createFromParcel(android.os.Parcel in) {
            return new Id(in);
        }

        public Id[] newArray(int size) {
            return (new Id[size]);
        }

    }
    ;

    protected Id(android.os.Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.value = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Id() {
    }

    /**
     * 
     * @param name
     * @param value
     */
    public Id(String name, Object value) {
        super();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(value);
    }

    public int describeContents() {
        return  0;
    }

}
