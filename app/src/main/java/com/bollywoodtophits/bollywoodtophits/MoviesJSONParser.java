package com.bollywoodtophits.bollywoodtophits;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Hasan on 12/29/2015.
 */
public class MoviesJSONParser {

    public List<HashMap<String, Object>> parse(JSONObject jObject) {

        JSONArray jMovies = null;
        try {
            jMovies = jObject.getJSONArray("movies");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return getMovies(jMovies);
    }

    private List<HashMap<String, Object>> getMovies(JSONArray jMovies) {
        int movieCount = jMovies.length();
        List<HashMap<String, Object>> movieList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> movie = null;

        for (int i = 0; i < movieCount; i++) {
            try {
                movie = getMovie((JSONObject) jMovies.get(i));
                movieList.add(movie);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return movieList;
    }

    private HashMap<String, Object> getMovie(JSONObject jMovie) {
        HashMap<String, Object> movie = new HashMap<String, Object>();
        String movieName = "";
        String yt_id = "";
        String artist = "";
        String id = "";
        String category = "";

        try {
            movieName = jMovie.getString("video_title");
            yt_id = "http://i1.ytimg.com/vi/" + jMovie.getString("yt_id") + "/default.jpg";
            artist = jMovie.getString("artist");
            id = jMovie.getString("id");
            category = jMovie.getString("category");

            String details = "Artist : " + artist + "\n" +
                    "ID : " + id + "\n" +
                    "Category : " + category;

            movie.put("movie", movieName);
            movie.put("yt_id", R.mipmap.ic_launcher);
            movie.put("img_path", yt_id);
            movie.put("details", details);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movie;
    }

}