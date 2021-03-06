package com.ellison.dagger2demo.bean

data class Movie(
        var Title: String,
        var Year: String,
        var imdbID: String,
        var Type: String = "",
        var Poster: String
) {
    override fun toString(): String {
        return "Movie(Title='$Title', Year='$Year', imdbID='$imdbID', Type='$Type')"
    }
}