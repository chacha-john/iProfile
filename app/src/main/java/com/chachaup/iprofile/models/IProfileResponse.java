
package com.chachaup.iprofile.models;

import java.util.List;
import javax.annotation.Generated;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;

import com.chachaup.iprofile.Result;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class IProfileResponse implements Parcelable
{

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("info")
    @Expose
    private Info info;
    public final static Creator<IProfileResponse> CREATOR = new Creator<IProfileResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public IProfileResponse createFromParcel(android.os.Parcel in) {
            return new IProfileResponse(in);
        }

        public IProfileResponse[] newArray(int size) {
            return (new IProfileResponse[size]);
        }

    }
    ;

    protected IProfileResponse(android.os.Parcel in) {
        in.readList(this.results, (Result.class.getClassLoader()));
        this.info = ((Info) in.readValue((Info.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public IProfileResponse() {
    }

    /**
     * 
     * @param results
     * @param info
     */
    public IProfileResponse(List<Result> results, Info info) {
        super();
        this.results = results;
        this.info = info;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(results);
        dest.writeValue(info);
    }

    public int describeContents() {
        return  0;
    }

}
