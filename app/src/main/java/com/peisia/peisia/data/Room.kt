package com.peisia.peisia.data

/**
 * Created by 호양이 on 2019-03-17.
 */
data class Room(val id:Int, val title:String, val desc:String, val exits:Map<String, Int>)