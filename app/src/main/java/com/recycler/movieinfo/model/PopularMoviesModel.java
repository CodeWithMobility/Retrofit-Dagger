package com.recycler.movieinfo.model;

import java.util.List;

/**
 * Created by Manu on 10/31/2017.
 */
public class PopularMoviesModel {


    private int page;
    private int total_results;
    private int total_pages;
    private List<ResultsEntity> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<ResultsEntity> getResults() {
        return results;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public static class ResultsEntity {
        /**
         * vote_count : 4185
         * id : 211672
         * video : false
         * vote_average : 6.4
         * title : Minions
         * popularity : 215.348394
         * poster_path : /q0R4crx2SehcEEQEkYObktdeFy.jpg
         * original_language : en
         * original_title : Minions
         * genre_ids : [10751,16,12,35]
         * backdrop_path : /uX7LXnsC7bZJZjn048UCOwkPXWJ.jpg
         * adult : false
         * overview : Minions Stuart, Kevin and Bob are recruited by Scarlet Overkill, a super-villain who, alongside her inventor husband Herb, hatches a plot to take over the world.
         * release_date : 2015-06-17
         */

        private int vote_count;
        private int id;
        private boolean video;
        private double vote_average;
        private String title;
        private double popularity;
        private String poster_path;
        private String original_language;
        private String original_title;
        private String backdrop_path;
        private boolean adult;
        private String overview;
        private String release_date;
        private List<Integer> genre_ids;

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }
    }
}