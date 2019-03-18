package com.peisia.peisia.data.world

/**
 * Created by 호양이 on 2019-03-17.
 */
data class Room(val id:Int, val name:String, val desc:String, val exits:MutableMap<String, Int>)