package com.phoenixroberts.popcorn.data;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rzmudzinski on 8/27/17.
 */

//http://www.jsonschema2pojo.org/
public class DTO {

    static public class MoviesListResultPage {

        private Integer page;
        private Integer totalResults;
        private Integer totalPages;
        private List<MoviesListItem> results = null;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(Integer totalResults) {
            this.totalResults = totalResults;
        }

        @JsonProperty("total_pages")
        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        public List<MoviesListItem> getResults() {
            return results;
        }

        public void setResults(List<MoviesListItem> results) {
            this.results = results;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    static public class MoviesListItem {

        private Boolean requiresRefresh=false;
        private Integer voteCount;
        private Integer id;
        private Boolean video;
        private Double voteAverage;
        private String title;
        private Double popularity;
        private String posterPath;
        private String originalLanguage;
        private String originalTitle;
        private List<Integer> genreIds = null;
        private String backdropPath;
        private Boolean adult;
        private String overview;
        private String releaseDate;
        private Integer runtime;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public MoviesListItem() {}
        public MoviesListItem(String movieTitle, int Id) {
            title=movieTitle;
            id=Id;
        }

        public Boolean getRequiresRefresh() { return requiresRefresh; }
        public void setRequiresRefresh(Boolean requiresDataRefresh) {
            requiresRefresh=requiresDataRefresh;
        }

        @JsonProperty("vote_count")
        public Integer getVoteCount() {
            return voteCount;
        }

        @JsonProperty("vote_count")
        public void setVoteCount(Integer voteCount) {
            this.voteCount = voteCount;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Boolean getVideo() {
            return video;
        }

        public void setVideo(Boolean video) {
            this.video = video;
        }

        @JsonProperty("vote_average")
        public Double getVoteAverage() {
            return voteAverage;
        }

        @JsonProperty("vote_average")
        public void setVoteAverage(Double voteAverage) {
            this.voteAverage = voteAverage;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Double getPopularity() {
            return popularity;
        }

        public void setPopularity(Double popularity) {
            this.popularity = popularity;
        }

        @JsonProperty("poster_path")
        public String getPosterPath() {
            return posterPath;
        }

        @JsonProperty("poster_path")
        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        public List<Integer> getGenreIds() {
            return genreIds;
        }

        public void setGenreIds(List<Integer> genreIds) {
            this.genreIds = genreIds;
        }

        public String getBackdropPath() {
            return backdropPath;
        }

        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }

        public Boolean getAdult() {
            return adult;
        }

        public void setAdult(Boolean adult) {
            this.adult = adult;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        @JsonProperty("release_date")
        public String getReleaseDate() {
            return releaseDate;
        }

        @JsonProperty("release_date")
        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        @JsonProperty("runtime")
        public Integer getRuntime() {
            return runtime;
        }

        @JsonProperty("runtime")
        public void setRuntime(Integer runtime) {
            this.runtime = runtime;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }


    }
}

