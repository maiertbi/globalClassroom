package com.dogsy.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.firestore.DocumentId;
import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.IgnoreExtraProperties;

import java.util.Date;
import java.util.List;

@IgnoreExtraProperties
public class User implements Parcelable {
    @DocumentId private String id;
    private String firstName;
    private Date birthday;
    private Gender gender;
    private String hometown;
    private String location;
    private String biography;
    private String park;
    private List<String> dogIds;
    private List<String> matches;
    private List<String> likedUsers;
    private List<String> shownUsers;
    @Exclude private List<byte[]> pictures;

    public User() {
    }

    public User(String id, String firstName, Date birthday, Gender gender, String hometown, String location, String biography, String park, List<String> dogIds, List<String> matches, List<String> likedUsers, List<String> shownUsers, List<byte[]> pictures) {
        this.id = id;
        this.firstName = firstName;
        this.birthday = birthday;
        this.gender = gender;
        this.hometown = hometown;
        this.location = location;
        this.biography = biography;
        this.park = park;
        this.dogIds = dogIds;
        this.matches = matches;
        this.likedUsers = likedUsers;
        this.shownUsers = shownUsers;
        this.pictures = pictures;
    }

    protected User(Parcel in) {
        id = in.readString();
        firstName = in.readString();
        hometown = in.readString();
        location = in.readString();
        biography = in.readString();
        park = in.readString();
        dogIds = in.createStringArrayList();
        likedUsers = in.createStringArrayList();
        matches = in.createStringArrayList();
        likedUsers = in.createStringArrayList();
        shownUsers = in.createStringArrayList();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }

    public List<String> getDogIds() {
        return dogIds;
    }

    public void setDogIds(List<String> dogIds) {
        this.dogIds = dogIds;
    }

    public List<String> getMatches() {
        return matches;
    }

    public void setMatches(List<String> matches) {
        this.matches = matches;
    }

    public List<String> getLikedUsers() {
        return likedUsers;
    }

    public void setLikedUsers(List<String> likedUsers) {
        this.likedUsers = likedUsers;
    }

    public List<String> getShownUsers() {
        return shownUsers;
    }

    public void setShownUsers(List<String> shownUsers) {
        this.shownUsers = shownUsers;
    }

    @Exclude
    public List<byte[]> getPictures() {
        return pictures;
    }

    @Exclude
    public void setPictures(List<byte[]> pictures) {
        this.pictures = pictures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", hometown='" + hometown + '\'' +
                ", location='" + location + '\'' +
                ", biography='" + biography + '\'' +
                ", park='" + park + '\'' +
                ", dogIds=" + dogIds +
                ", matches=" + matches +
                ", likedUsers=" + likedUsers +
                ", shownUsers=" + shownUsers +
                '}';
    }

  @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(firstName);
        parcel.writeString(birthday.toString());
        parcel.writeString(gender.name());
        parcel.writeString(hometown);
        parcel.writeString(location);
        parcel.writeString(biography);
        parcel.writeString(park);
        parcel.writeStringList(dogIds);
        parcel.writeStringList(matches);
        parcel.writeStringList(likedUsers);
        parcel.writeStringList(shownUsers);


    }

    public enum Gender {
        MALE,
        FEMALE,
        NON_BINARY;
    }
}
