package com.liordahan.matrix_lior.models;


import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class DataListAddr {

    @SerializedName("Addr")
    private String address;

    @SerializedName("DAd")
    private String location;

    public DataListAddr(String address, String location) {
        this.address = address;
        this.location = location;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataListAddr that = (DataListAddr) o;
        return Objects.equals(address, that.address) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, location);
    }

    @Override
    public String toString() {
        return "DataListAddr{" +
                "address='" + address + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
