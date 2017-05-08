package harman.com.freelauncher.models;

/**
 * Created by MShekhar on 5/1/2017.
 */

public class PendingDataModel {
    public String getRadioElapsedTime() {
        return radioElapsedTime;
    }

    public void setRadioElapsedTime(String radioElapsedTime) {
        this.radioElapsedTime = radioElapsedTime;
    }

    String radioElapsedTime;

    public String getRadioUri() {
        return radioUri;
    }

    public void setRadioUri(String radioUri) {
        this.radioUri = radioUri;
    }

    String radioUri;

    public String getProfilePictureUri() {
        return profilePictureUri;
    }

    public void setProfilePictureUri(String profilePictureUri) {
        this.profilePictureUri = profilePictureUri;
    }

    String profilePictureUri;

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    String profileName;

    String destination;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getWayPoint() {
        return wayPoint;
    }

    public void setWayPoint(String wayPoint) {
        this.wayPoint = wayPoint;
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
    }

    public String getTravelDuration() {
        return travelDuration;
    }

    public void setTravelDuration(String travelDuration) {
        this.travelDuration = travelDuration;
    }

    String wayPoint;
    String meetingTime;
    String travelDuration;
}