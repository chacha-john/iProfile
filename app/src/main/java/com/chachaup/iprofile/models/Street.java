
package com.chachaup.iprofile.models;

import javax.annotation.Generated;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Street implements Parcelable
{

    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Creator<Street> CREATOR = new Creator<Street>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Street createFromParcel(android.os.Parcel in) {
            return new Street(in);
        }

        public Street[] newArray(int size) {
            return (new Street[size]);
        }

    }
    ;

    protected Street(android.os.Parcel in) {
        this.number = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Street() {
    }

    /**
     * 
     * @param number
     * @param name
     */
    public Street(Integer number, String name) {
        super();
        this.number = number;
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(number);
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

}
