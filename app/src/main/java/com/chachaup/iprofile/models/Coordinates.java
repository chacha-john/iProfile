
package com.chachaup.iprofile.models;

import javax.annotation.Generated;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Coordinates implements Parcelable
{

    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    public final static Creator<Coordinates> CREATOR = new Creator<Coordinates>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Coordinates createFromParcel(android.os.Parcel in) {
            return new Coordinates(in);
        }

        public Coordinates[] newArray(int size) {
            return (new Coordinates[size]);
        }

    }
    ;

    protected Coordinates(android.os.Parcel in) {
        this.latitude = ((String) in.readValue((String.class.getClassLoader())));
        this.longitude = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Coordinates() {
    }

    /**
     * 
     * @param latitude
     * @param longitude
     */
    public Coordinates(String latitude, String longitude) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(latitude);
        dest.writeValue(longitude);
    }

    public int describeContents() {
        return  0;
    }

}
