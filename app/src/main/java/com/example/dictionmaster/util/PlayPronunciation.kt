package com.example.dictionmaster.util


import android.media.MediaPlayer

fun playPronunciation(url: String){

    val mp: MediaPlayer = MediaPlayer()

    try {
        mp.setDataSource(url)
        mp.prepare()
        mp.start()
    } catch (e: Exception) {
        println(e.printStackTrace())
    }
}