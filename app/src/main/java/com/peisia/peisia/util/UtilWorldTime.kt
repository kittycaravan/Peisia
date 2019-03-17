package com.peisia.peisia.util

/**
 * Created by 호양이 on 2019-03-17.
 */
class UtilWorldTime {
    fun getWorldSecFromWorldMilliSec(worldMilliSec : Long) : Long{
        return worldMilliSec / 1000
    }
}