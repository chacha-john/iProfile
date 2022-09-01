
package com.chachaup.iprofile.models;

import javax.annotation.Generated;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Registered implements Parcelable
{

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("age")
    @Expose
    private Integer age;
    public final static Creator<Registered> CREATOR = new Creator<Registered>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Registered createFromParcel(android.os.Parcel in) {
            return new Registered(in);
        }

        public Registered[] newArray(int size) {
            return (new Registered[size]);
        }

    }
    ;

    protected Registered(android.os.Parcel in) {
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.age = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Registered() {
    }

    /**
     * 
     * @param date
     * @param age
     */
    public Registered(String date, Integer age) {
        super();
        this.date = date;
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(date);
        dest.writeValue(age);
    }

    public int describeContents() {
        return  0;
    }

}
