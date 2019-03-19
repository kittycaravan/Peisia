package com.peisia.peisia.data.temp

import com.peisia.peisia.data.world.thing.Room

/**
 * Created by 호양이 on 2019-03-20.
 */
class TempDataMapHelpBeginer {
    fun getMap() : MutableMap<Long, Room> {
        val tempRooms : MutableMap<Long, Room> = mutableMapOf()
        tempRooms.put(7175500005000050000 , Room(
            7175500005000050000, "초보자 도움 방"
            , "- 이동하는 방법 -"
                    + "\n방 설명에 현재 방과 연결된 방으로 이동 가능한 방향이 표시됩니다."
            , mutableMapOf("동" to 7175500005001050000)
        )
        )
        tempRooms.put(7175500005001050000 , Room(
            7175500005001050000, "초보자 도움 방"
            , "- 대화하는 방법 -"
                    + "\n\"안녕 말\" 이나 \"안녕 ㅁ\" 이라고 입력하시면 '<케릭터명>님이 말합니다. \"안녕\" ' 이라고 표시됩니다."
            , mutableMapOf("서" to 7175500005000050000, "북" to 7175500005001050010)
        )
        )
        tempRooms.put(7175500005001050010 , Room(
            7175500005001050010, "초보자 도움 방"
            , "- 내 상태를 확인 -"
                    + "\n케릭터의 전반적인 상태를 확인하려면 \"상태\" 또는 \"상\" 이라고 입력합니다."
            , mutableMapOf("서" to 7175500005000050010, "남" to 7175500005001050000)
        )
        )
        tempRooms.put(7175500005000050010, Room(
            7175500005000050010, "초보자 도움 방"
            , "- 물건과의 상호작용 -"
                    + "\n소지품을 확인하려면 \"소지품\" 또는 \"소\" 라고 입력하세요."
            , mutableMapOf("동" to 7175500005001050010)
        )
        )
        return tempRooms
    }
}