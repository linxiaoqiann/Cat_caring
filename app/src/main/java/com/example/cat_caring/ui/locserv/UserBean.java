package com.example.cat_caring.ui.locserv;



public class UserBean {
    private String uuid;
    private double lat;
    private double lng;

    public String getUuid() {
        return uuid;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "uuid='" + uuid + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
