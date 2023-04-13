package com.example.csc415randyharrisapp.modelOld
//Design the view for the recycler view
data class ChampionOld(
    val name: String, //Name of the champion
    val image: String,
    val role: String, //Preferred role of the champion [Top, Jungle, Mid, Bot, Support]
    val id: Int, //Riot ID of the champion
    val winrate: Int, //Winrate of the champion by percent
    val altrole: String //Alternative role of the champion
    //val counters: List<Int>, //List of Riot ID's that the given champion counters
    //val countered: List<Int> //List of Riot ID's that the champion is countered by
)