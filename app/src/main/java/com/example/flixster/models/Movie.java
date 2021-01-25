package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    String backdropPath;
    String posterPath;
    String title;
    String overview;

    // whoever calls this method is responsible for handling this exception
    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath   = jsonObject.getString("poster_path");
        title        = jsonObject.getString("title");
        overview     = jsonObject.getString("overview");
    }

    // iterate through the JsonArray and construct a movie for each element in this JsonArray
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();

        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }

        return movies;
    }

    // only gets a relative path (look @ API response),
    // you still need the full path, this is a hardcoded workaround
    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public void hello(String msg) {
        System.out.println("Hello " + msg);
    }

} // end of movie class
