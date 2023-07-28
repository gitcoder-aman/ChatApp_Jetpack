package com.tech.chatapp.data

data class Chat(
    val id : Int,
    val direction : Boolean = true,
    val message : String = "",
    val time : String = ""
)

val chatList = listOf(
    Chat(1,true,"Hey Whatsapp!","12:00 PM"),
    Chat(2,false,"Hey Whatsapp!What are you doing bro.","12:00 PM"),
    Chat(3,true,"I'm just learning jetpack compose in android","12:00 PM"),
    Chat(4,false,"Oh nice cool.","12:00 PM"),
    Chat(5,true,"yeh","12:00 PM"),
    Chat(6,false,"You have to create osm UI in jetpack compose for android application","12:00 PM"),
    Chat(7,false,"yes bro","12:00 PM"),
    Chat(8,true,"Nice and keep growing in your life.","12:00 PM"),
    Chat(9,true,"Thanks dude.","12:00 PM"),
    Chat(10,true,"now tell me something about your living day.","12:00 PM"),
    Chat(11,false,"Nothing to happen,just coding and mathematics for nimcet","12:00 PM"),
    Chat(12,true,"oh great","12:00 PM"),
    Chat(13,false,"thanks","12:00 PM"),
    Chat(14,false,"Ok bro bye.","12:00 PM"),
    Chat(15,true,"Bye.","12:00 PM")
)
