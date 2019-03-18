package com.peisia.peisia.data.world.thing

import com.peisia.peisia.data.world.Thing

/**
 * Created by 호양이 on 2019-03-17.
 */
//data class Room(val id:Int, val name:String, val desc:String, val exits:MutableMap<String, Int>)
//class Room(id : Long, name : String, val desc:String, val exits:MutableMap<String, Int>) : WorldObject(id, name){
class Room(id : Long, name : String, val desc:String, val exits:MutableMap<String, Int>) : Thing(id, name){

/*    override var name: String = ""
        get(){
            Log.v("호양이","==== ==== 호출됨 name b get")
            return super.name
        }*/

//        set(value) {
//            Log.v("호양이","==== ==== 호출됨 name b set")
//            super.name = value
//        }

/*    override var id : Long
        get(){
            Log.v("호양이","==== ==== 호출됨 id b get")
            return super.id
        }

        set(value) {
            Log.v("호양이","==== ==== 호출됨 id b set")
            super.id = value
        }
    override var roomname: String
        get(){
            Log.v("호양이","==== ==== 호출됨 name b get")
            return super.name
        }

        set(value) {
            Log.v("호양이","==== ==== 호출됨 name b set")
            super.name = value
        }*/
}