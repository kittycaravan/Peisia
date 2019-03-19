package com.peisia.peisia.data.temp

import com.peisia.peisia.data.world.thing.Room

/**
 * Created by 호양이 on 2019-03-20.
 */
class TempDataMapPractice {
    fun getMap() : MutableMap<Long, Room> {
        val tempRooms : MutableMap<Long, Room> = mutableMapOf()
        tempRooms.put(7175500105000050010 ,
            Room(
                7175500105000050010, "연습장 입구"
            , "연습장 입구다"
            , mutableMapOf("동" to 7175500105001050010)
            )
        )
        tempRooms.put(7175500105001050010 ,
            Room(
                7175500105001050010, "연습장"
            , "연습장이다"
            , mutableMapOf("동" to 7175500105002050010, "서" to 7175500105000050010)
            )
        )
        tempRooms.put(7175500105002050010 ,
            Room(
                7175500105002050010, "연습장"
            , "연습장이다"
            , mutableMapOf("북" to 7175500105002050020, "서" to 7175500105001050010)
            )
        )
        tempRooms.put(7175500105002050020 ,
            Room(
                7175500105002050020, "연습장"
            , "연습장이다"
            , mutableMapOf("남" to 7175500105002050010, "서" to 7175500105001050020)
            )
        )
        tempRooms.put(7175500105001050020 ,
            Room(
                7175500105001050020, "연습장 중앙"
            , "연습장 중앙이다"
            , mutableMapOf("동" to 7175500105002050020, "서" to 7175500105000050020)
            )
        )
        tempRooms.put(7175500105000050020 ,
            Room(
                7175500105000050020, "연습장"
            , "연습장이다"
            , mutableMapOf("동" to 7175500105001050020, "북" to 7175500105000050030)
            )
        )
        tempRooms.put(7175500105000050030 ,
            Room(
                7175500105000050030, "연습장"
            , "연습장이다"
            , mutableMapOf("동" to 7175500105001050030, "남" to 7175500105000050020)
            )
        )
        tempRooms.put(7175500105001050030 ,
            Room(
                7175500105001050030, "연습장"
            , "연습장이다"
            , mutableMapOf("서" to 7175500105000050030, "동" to 7175500105002050030)
            )
        )
        tempRooms.put(7175500105002050030 ,
            Room(
                7175500105002050030, "연습장 출구"
            , "연습장 출구다"
            , mutableMapOf("서" to 7175500105001050030)
            )
        )
        return tempRooms
    }
}