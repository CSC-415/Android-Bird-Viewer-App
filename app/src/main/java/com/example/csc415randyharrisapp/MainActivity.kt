package com.example.csc415randyharrisapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val recyclerView = findViewById<RecyclerView>(R.id.champion_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val champions = mutableListOf<Champion>()

        for (i in 0 .. 30){
            champions.add(createChampions())
        }

        val adapter = ChampionAdapter(champions)
        recyclerView.adapter = adapter
    }

    private fun createChampions() = Champion(
        name = "Champion: " + randomChampName(),
        image = R.drawable.karma,
        role = "Role: " + randomRole(),
        winrate = "Winrate: " + Random.nextInt(0, 100).toString() + "%",
        id = "Riot ID: " + Random.nextInt(0 , 162).toString()
    )

    private fun randomChampName(): String{
        val champNames = arrayOf<String>("Aatrox",
            "Ahri",
            "Akali",
            "Alistar",
            "Amumu",
            "Anivia",
            "Annie",
            "Aphelios",
            "Ashe",
            "Aurelion Sol",
            "Azir",
            "Bard",
            "Blitzcrank",
            "Brand",
            "Braum",
            "Caitlyn",
            "Camille",
            "Cassiopeia",
            "Cho'Gath",
            "Corki",
            "Darius",
            "Diana",
            "Dr. Mundo",
            "Draven",
            "Ekko",
            "Elise",
            "Evelynn",
            "Ezreal",
            "Fiddlesticks",
            "Fiora",
            "Fizz",
            "Galio",
            "Gangplank",
            "Garen",
            "Gnar",
            "Gragas",
            "Graves",
            "Hecarim",
            "Heimerdinger",
            "Illaoi",
            "Irelia",
            "Ivern",
            "Janna",
            "Jarvan IV",
            "Jax",
            "Jayce",
            "Jhin",
            "Jinx",
            "Kai'Sa",
            "Kalista",
            "Karma",
            "Karthus",
            "Kassadin",
            "Katarina",
            "Kayle",
            "Kayn",
            "Kennen",
            "Kha'Zix",
            "Kindred",
            "Kled",
            "Kog'Maw",
            "K'sante",
            "LeBlanc",
            "Lee Sin",
            "Leona",
            "Lillia",
            "Lissandra",
            "Lucian",
            "Lulu",
            "Lux",
            "Malphite",
            "Malzahar",
            "Maokai",
            "Master Yi",
            "Miss Fortune",
            "Mordekaiser",
            "Morgana",
            "Nami",
            "Nasus",
            "Nautilus",
            "Neeko",
            "Nidalee",
            "Nocturne",
            "Nunu and Willump",
            "Olaf",
            "Orianna",
            "Ornn",
            "Pantheon",
            "Poppy",
            "Pyke",
            "Qiyana",
            "Quinn",
            "Rakan",
            "Rammus",
            "Rek'Sai",
            "Rell",
            "Renekton",
            "Rengar",
            "Riven",
            "Rumble",
            "Ryze",
            "Samira",
            "Sejuani",
            "Senna",
            "Seraphine",
            "Sett",
            "Shaco",
            "Shen",
            "Shyvana",
            "Singed",
            "Sion",
            "Sivir",
            "Skarner",
            "Sona",
            "Soraka",
            "Swain",
            "Sylas",
            "Syndra",
            "Tahm Kench",
            "Taliyah",
            "Talon",
            "Taric",
            "Teemo",
            "Thresh",
            "Tristana",
            "Trundle",
            "Tryndamere",
            "Twisted Fate",
            "Twitch",
            "Udyr",
            "Urgot",
            "Varus",
            "Vayne",
            "Veigar",
            "Vel'Koz",
            "Vi",
            "Viktor",
            "Vladimir",
            "Volibear",
            "Warwick",
            "Wukong",
            "Xayah",
            "Xerath",
            "Xin Zhao",
            "Yasuo",
            "Yone",
            "Yorick",
            "Yuumi",
            "Zac",
            "Zed",
            "Ziggs",
            "Zilean",
            "Zoe",
            "Zyra",)
        return champNames[Random.nextInt(0, 150)]
    }

    private fun randomRole(): String{
        val roles = arrayOf<String>("Top", "Jungle", "Mid", "Bottom", "Support")
        return roles[Random.nextInt(0, 4)]
    }
}