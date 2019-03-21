package com.peisia.peisia.data.temp

import com.peisia.peisia.data.world.WorldObject

/**
 * Created by 호양이 on 2019-03-21.
 */
class TempDataObjects {
    fun getObjects() : MutableMap<Long, WorldObject>{
        val tempObjs : MutableMap<Long, WorldObject> = mutableMapOf()
        tempObjs.put(7175500005000050000,WorldObject(7175500005000050000,"kaminus"))
        tempObjs.put(7175500105000050010,WorldObject(7175500105000050010,"릿세"))
        tempObjs.put(7175500105000050010,WorldObject(7175500105000050010,"두리"))
        tempObjs.put(7175500105001050010,WorldObject(7175500105001050010,"자연"))
        tempObjs.put(7175500105002050010,WorldObject(7175500105002050010,"쥐"))
        tempObjs.put(7175500105002050020,WorldObject(7175500105002050020,"왕쥐의 머리카락"))
        tempObjs.put(7175500105001050020,WorldObject(7175500105001050020,"바위"))
        tempObjs.put(7175500105000050020,WorldObject(7175500105000050020,"캠핑카"))
        tempObjs.put(7175500105000050020,WorldObject(7175500105000050020,"바사"))
        tempObjs.put(7175500105000050030,WorldObject(7175500105000050030,"피규어-배-바사"))
        tempObjs.put(7175500105000050020,WorldObject(7175500105000050020,"연습장 지도"))
        tempObjs.put(7175500105000050010,WorldObject(7175500105000050010,"나뭇가지"))
        tempObjs.put(7175500105001050030,WorldObject(7175500105001050030,"나뭇가지(황금)"))
        tempObjs.put(7175500105001050020,WorldObject(7175500105001050020,"냠냠이"))
        tempObjs.put(7175500105001050010,WorldObject(7175500105001050010,"레드젬"))
        tempObjs.put(7175500105002050010,WorldObject(7175500105002050010,"유로"))
        tempObjs.put(7175500105002050020,WorldObject(7175500105002050020,"금"))
        tempObjs.put(7175500105002050030,WorldObject(7175500105002050030,"초보자 도움 방"))
        return tempObjs
    }
}