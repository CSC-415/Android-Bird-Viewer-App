package com.example.csc415randyharrisapp
//Design the view for the recycler view
data class Champion(
    val name: String, //Name of the champion
    val image: Int,
    val role: String, //Preferred role of the champion [Top, Jungle, Mid, Bot, Support]
    val id: String, //Riot ID of the champion
    val winrate: String, //Winrate of the champion by percent
    //val counters: List<Int>, //List of Riot ID's that the given champion counters
    //val countered: List<Int> //List of Riot ID's that the champion is countered by
)
