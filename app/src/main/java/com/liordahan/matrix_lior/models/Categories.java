package com.liordahan.matrix_lior.models;

import com.liordahan.matrix_lior.utils.ListItem;

import java.util.ArrayList;
import java.util.Objects;

public class Categories implements ListItem {

    private int CatId;
    private String CTitle;

    private ArrayList<Benefit> benefitList;

    public Categories(int catId, String title, ArrayList<Benefit> benefitList) {
        this.CatId = catId;
        this.CTitle = title;
        this.benefitList = benefitList;
    }

    public int getCatId() {
        return CatId;
    }

    public void setCatId(int catId) {
        CatId = catId;
    }

    public String getTitle() {
        return CTitle;
    }

    public void setTitle(String title) {
        CTitle = title;
    }

    public String getCTitle() {
        return CTitle;
    }

    public void setCTitle(String CTitle) {
        this.CTitle = CTitle;
    }

    public ArrayList<Benefit> getBenefitList() {
        return benefitList;
    }

    public void setBenefitList(ArrayList<Benefit> benefitList) {
        this.benefitList = benefitList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categories that = (Categories) o;
        return CatId == that.CatId &&
                Objects.equals(CTitle, that.CTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CatId, CTitle);
    }

    @Override
    public String toString() {
        return "Categories{" +
                "CatId=" + CatId +
                ", Title='" + CTitle + '\'' +
                '}';
    }

    @Override
    public String getId() {
        return String.valueOf(CatId);
    }
}
