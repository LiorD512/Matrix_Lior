package com.liordahan.matrix_lior.repository;

import android.content.Context;

import com.google.gson.Gson;
import com.liordahan.matrix_lior.models.Benefit;
import com.liordahan.matrix_lior.models.Categories;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class BenefitsRepository extends EntityRepository{

    BenefitsRepository(BaseRepository mainRepository) {
        super(mainRepository);
    }


    public ArrayList<Categories> getClientBenefits(Context context) {

        JSONObject obj;
        JSONObject dataObject = null;
        Benefit benefit;
        Categories categories;

        ArrayList<Benefit> benefitArrayList = new ArrayList<>();
        ArrayList<Categories> categoriesArrayList = new ArrayList<>();
        ArrayList<Benefit> benefitsByCat = new ArrayList<>();

        try {
            obj = new JSONObject(readJSONFromAsset(context));
            dataObject = obj.getJSONObject("DataObject");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            JSONArray objectList = (JSONArray) dataObject.getJSONArray("DataListObject ");
            if (objectList != null) {
                for (int i = 0; i < objectList.length(); i++) {
                    JSONObject o = (JSONObject) objectList.get(i);
                    Gson g = new Gson();
                    benefit = g.fromJson(String.valueOf(o), Benefit.class);
                    benefitArrayList.add(benefit);
                }


            }

            JSONArray categoriesList = (JSONArray) dataObject.getJSONArray("DataListCat");
            if (categoriesList != null) {
                for (int i = 0; i < categoriesList.length(); i++) {
                    JSONObject o = (JSONObject) categoriesList.get(i);
                    Gson g = new Gson();
                    categories = g.fromJson(String.valueOf(o), Categories.class);
                    categoriesArrayList.add(categories);
                }


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (categoriesArrayList != null && benefitArrayList != null) {
            for (Categories c : categoriesArrayList) {
                for (Benefit b : benefitArrayList) {
                    if (b.getCatId() == c.getCatId()) {
                        benefitsByCat.add(b);
                    }
                }

                c.setBenefitList(benefitsByCat);

                benefitsByCat = new ArrayList<>();

            }
        }

        return categoriesArrayList;
    }

    public String readJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("jsonObject.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


}
