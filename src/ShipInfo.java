import java.sql.Time;

public class ShipInfo {
    private String mmsi;
    private String longitude;
    private String latitude;
    private String time;

    public ShipInfo() {

    }

    public ShipInfo(String mmsi, String longitude, String latitude, String time) {
        this.mmsi = mmsi;
        this.longitude = longitude;
        this.latitude = latitude;
        this.time = time;
    }

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
