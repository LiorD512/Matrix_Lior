package com.liordahan.matrix_lior.models;

import com.google.gson.annotations.SerializedName;
import com.liordahan.matrix_lior.utils.ListItem;

import java.util.ArrayList;
import java.util.Objects;

public class Benefit implements ListItem {


    private int CatId;
    private String Title;
    private String STitle;
    private String Imag;
    private long Id;
    private ArrayList<DataListAddr> DataListAddr;



    public Benefit(int CatId, String Title, String STitle, String Imag, long Id, ArrayList<DataListAddr> DataListAddr) {
        this.CatId = CatId;
        this.Title = Title;
        this.STitle = STitle;
        this.Imag = Imag;
        this.Id = Id;
        this.DataListAddr = DataListAddr;
    }


    public int getCatId() {
        return CatId;
    }

    public void setCatId(int catId) {
        this.CatId = catId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getSTitle() {
        return STitle;
    }

    public void setSTitle(String STitle) {
        this.STitle = STitle;
    }

    public String getImag() {
        return Imag;
    }

    public void setImag(String imag) {
        this.Imag = imag;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public ArrayList<DataListAddr> getDataListAddr() {
        return DataListAddr;
    }

    public void setDataListAddr(ArrayList<DataListAddr> dataListAddr) {
        this.DataListAddr = dataListAddr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Benefit benefit = (Benefit) o;
        return CatId == benefit.CatId &&
                Id == benefit.Id &&
                Objects.equals(Title, benefit.Title) &&
                Objects.equals(STitle, benefit.STitle) &&
                Objects.equals(Imag, benefit.Imag) &&
                Objects.equals(DataListAddr, benefit.DataListAddr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CatId, Title, STitle, Imag, Id, DataListAddr);
    }

    @Override
    public String toString() {
        return "Benefit{" +
                "CatId=" + CatId +
                ", Title='" + Title + '\'' +
                ", STitle='" + STitle + '\'' +
                ", Imag='" + Imag + '\'' +
                ", Id=" + Id +
                ", DataListAddr=" + DataListAddr +
                '}';
    }

    @Override
    public String getId() {
        return String.valueOf(Id);
    }
}
