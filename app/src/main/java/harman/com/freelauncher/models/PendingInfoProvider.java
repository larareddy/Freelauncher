package harman.com.freelauncher.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by MShekhar on 4/30/2017.
 */

public class PendingInfoProvider {
    String jSonString;

    public PendingDataModel GetAllData(String jString) {
        jSonString = jString;
        PendingDataModel result = new PendingDataModel();
        try {
            JSONObject jsonObj = (new JSONObject(jSonString)).getJSONObject("profile");
            String name = jsonObj.getString("FirstName");
            String profilePicture = jsonObj.getString("ProfileUrl");
            result.setProfileName(name);
            result.setProfilePictureUri(profilePicture);
            JSONObject jsonRootObject = new JSONObject(jSonString);
            JSONArray jsonArray = jsonRootObject.optJSONArray("pendingUpdates");

            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String data = jsonObject.getString("data");
            JSONObject beacon = (new JSONObject(data)).getJSONObject("beacon");
            String radioUri = beacon.getString("Uri");
            String elapsedTime = beacon.getString("elapsedTime");
            result.setRadioUri(radioUri);
            result.setRadioElapsedTime(elapsedTime);
            JSONObject jObject = jsonArray.getJSONObject(1);
            String navData = jObject.getString("data");


            if (jObject !=null && navData !=null && (new JSONObject(navData)).getJSONArray("NavigationData") != null) {

                //calendar data
                JSONObject jCalData = ((JSONObject)(new JSONObject(navData)).getJSONArray("CalendarData").get(0)).getJSONObject("CalendarResponse");

                String startDate = jCalData.getString("StartDateTime");
//                result.setMeetingTime(startDate);
                String endDate = jCalData.getString("EndDateTime");
                String meetingLocation = jCalData.getString("Location");
                String subject = jCalData.getString("Subject");

                //navigation data
                JSONObject nJsonData = ((JSONObject) (new JSONObject(navData)).getJSONArray("NavigationData").get(0)).getJSONObject("NavigationData");

                try {
                    if (nJsonData.getJSONArray("routeLegs").length() > 1) {
                        JSONObject routeLegs1 = (JSONObject) nJsonData.getJSONArray("routeLegs").get(0);
                        Double stopOverCoordinates1 = routeLegs1.getJSONArray("destinationCoordinates").getDouble(0);
                        Double stopOverCoordinates2 = routeLegs1.getJSONArray("destinationCoordinates").getDouble(1);
                        String stopOverAddress = routeLegs1.getString("destinationDescription");
                        result.setWayPoint(stopOverAddress);

                        JSONObject routeLegs2 = (JSONObject) nJsonData.getJSONArray("routeLegs").get(1);
                        Double destinationOverCoordinates1 = routeLegs2.getJSONArray("destinationCoordinates").getDouble(0);
                        Double destinationOverCoordinates2 = routeLegs2.getJSONArray("destinationCoordinates").getDouble(1);
                        String destinationAddress = routeLegs2.getString("destinationDescription");
                        result.setDestination(destinationAddress);

                        Double travelDistance = nJsonData.getDouble("travelDistance");
                        Double travelDurationInMin = nJsonData.getDouble("travelDuration") * 60;
                    } else {
                        JSONObject routeLegs1 = (JSONObject) nJsonData.getJSONArray("routeLegs").get(0);
                        Double startCoordinates1 = routeLegs1.getJSONArray("startCoordinates").getDouble(0);
                        Double startCoordinates2 = routeLegs1.getJSONArray("startCoordinates").getDouble(1);
                        String startAddress = routeLegs1.getString("startDescription");

                        Double destinationOverCoordinates1 = routeLegs1.getJSONArray("destinationCoordinates").getDouble(0);
                        Double destinationOverCoordinates2 = routeLegs1.getJSONArray("destinationCoordinates").getDouble(1);
                        String destinationAddress = routeLegs1.getString("destinationDescription");

                        Double travelDistance = nJsonData.getDouble("travelDistance");
                        Double travelDurationInMin = nJsonData.getDouble("travelDuration") * 60;
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

//    public String getName() throws JSONException {
//        JSONObject jsonObj=(new JSONObject(jSonString)).getJSONObject("profile");
//        String name = jsonObj.getString("FirstName");
//        return name;
//    }
//
//    public String getprofilePicture() throws JSONException {
//        JSONObject jsonObj=(new JSONObject(jSonString)).getJSONObject("profile");
//        String profilePicture = jsonObj.getString("ProfileUrl");
//        return profilePicture;
//    }
//
//    public String getRadioURL() throws JSONException {
//        JSONObject jsonRootObject=new JSONObject(jSonString);
//        JSONArray jsonArray = jsonRootObject.optJSONArray("pendingUpdates");
//        JSONObject jsonObject = jsonArray.getJSONObject(0);
//        String data = jsonObject.getString("data");
//        JSONObject beacon = (new JSONObject(data)).getJSONObject("beacon");
//        String radioUri = beacon.getString("Uri");
//        String elapsedTime = beacon.getString("elapsedTime");
////        JSONObject jsonObject = jsonArray.getJSONObject(1);
//        return radioUri;
//    }
}
