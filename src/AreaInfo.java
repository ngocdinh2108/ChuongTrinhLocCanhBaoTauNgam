public class AreaInfo {

    private String nameArea;
    private String longitudeLeft;
    private String longitudeRight;
    private String latitudeTop;
    private String latitudeBot;

    public AreaInfo(String nameArea, String longitudeLeft, String longitudeRight, String latitudeTop, String latitudeBot) {
        this.nameArea = nameArea;
        this.longitudeLeft = longitudeLeft;
        this.longitudeRight = longitudeRight;
        this.latitudeTop = latitudeTop;
        this.latitudeBot = latitudeBot;
    }

    public String getNameArea() {
        return nameArea;
    }

    public void setNameArea(String nameArea) {
        this.nameArea = nameArea;
    }

    public String getLongitudeLeft() {
        return longitudeLeft;
    }

    public void setLongitudeLeft(String longitudeLeft) {
        this.longitudeLeft = longitudeLeft;
    }

    public String getLongitudeRight() {
        return longitudeRight;
    }

    public void setLongitudeRight(String longitudeRight) {
        this.longitudeRight = longitudeRight;
    }

    public String getLatitudeTop() {
        return latitudeTop;
    }

    public void setLatitudeTop(String latitudeTop) {
        this.latitudeTop = latitudeTop;
    }

    public String getLatitudeBot() {
        return latitudeBot;
    }

    public void setLatitudeBot(String latitudeBot) {
        this.latitudeBot = latitudeBot;
    }
}
