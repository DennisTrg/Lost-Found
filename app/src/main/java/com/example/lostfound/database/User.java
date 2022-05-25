package com.example.lostfound.database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "user")
public class User implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int user_id;
    private String userName;
    private String userPhone;
    private String userDescription;
    private String userDate;
    private String userLocation;
    private String userStatus;

    public User(String userName, String userPhone, String userDescription, String userDate, String userLocation, String userStatus) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.userDescription = userDescription;
        this.userDate = userDate;
        this.userLocation = userLocation;
        this.userStatus = userStatus;
    }

    protected User(Parcel in) {
        user_id = in.readInt();
        userName = in.readString();
        userPhone = in.readString();
        userDescription = in.readString();
        userDate = in.readString();
        userLocation = in.readString();
        userStatus = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getUserDate() {
        return userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(user_id);
        dest.writeString(userName);
        dest.writeString(userPhone);
        dest.writeString(userDescription);
        dest.writeString(userDate);
        dest.writeString(userLocation);
        dest.writeString(userStatus);
    }
}
