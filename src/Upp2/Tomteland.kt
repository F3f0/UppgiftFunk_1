package Upp2

import kotlin.system.exitProcess


/*
Tomtarna på Nordpolen har en strikt chefs-hierarki
Högsta chefen för allt är "Tomten"
Under "Tomten" jobbar "Glader" och "Butter"
Under "Glader" jobbar "Tröger", "Trötter"och "Blyger"
Under "Butter" jobbar "Rådjuret", "Nyckelpigan", "Haren" och "Räven"
Under "Trötter" jobbar "Skumtomten"
Under "Skumtomten" jobbar "Dammråttan"
Under "Räven" jobbar "Gråsuggan" och "Myran"
Under "Myran" jobbar "Bladlusen"
 */


public class Tomteland {

    var tomteland = mutableMapOf("Tomten" to mutableListOf("Glader", "Butter"),
        "Glader" to mutableListOf("Tröger", "Trötter", "Blyger"),
        "Butter" to mutableListOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
        "Trötter" to mutableListOf("Skumtomten"),
        "Skumtomten" to mutableListOf("Dammråttan"),
        "Räven" to mutableListOf("Myran", "Gråsuggan"),
        "Myran" to mutableListOf("Bladlusen"))

    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
        try {
            for (i in tomteland[currentName]!!)
                if (tomteland.containsKey(i)) {
                    getUnderlings(i, res)
                    res += tomteland[i]!!
                }
            res += tomteland[currentName]!!
        } catch (e: Exception) {
            println("Den tomte har inga underhuggare eller jobbar på ett annat ställe")
            exitProcess(0)
        }
        return res.distinct()
    }
}


    fun main() {
        val tl = Tomteland()
        var list: MutableList<String> = mutableListOf()
        println(tl.getUnderlings("Tomten", list))
    }

