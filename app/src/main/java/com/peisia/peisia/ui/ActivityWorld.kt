package com.peisia.peisia.ui
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.peisia.peisia.data.Room
import kotlinx.android.synthetic.main.activity_world.*
import kotlin.concurrent.timer

import com.peisia.peisia.R
import com.peisia.peisia.util.UtilWorldTime

class ActivityWorld : AppCompatActivity() {
    private val TAG = this::class.simpleName // 태그 설정. 당분간 이걸로.
    var worldTimeMs : Long = 0L
    var worldTimeSec : Long = 0L
    var worldCurrentRoom : Int = 1000  //todo: 하드코딩. 첫 시작 룸을 강제로 1000 번 방부터 시작.
    val rooms:MutableMap<String, Room> = mutableMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.peisia.peisia.R.layout.activity_world)

        rooms.put("1000" , Room(1000,"초보자 도움 방"
                        ,"- 이동하는 방법 -"
                                + "\n방 설명에 현재 방과 연결된 방으로 이동 가능한 방향이 표시됩니다."
                        , mapOf("동" to 1001)))
        rooms.put("1001" , Room(1001,"초보자 도움 방"
            ,"- 대화하는 방법 -"
                    + "\n\"안녕 말\" 이나 \"안녕 ㅁ\" 이라고 입력하시면 '<케릭터명>님이 말합니다. \"안녕\" ' 이라고 표시됩니다."
            ,mapOf("서" to 1000, "남" to 1002)))
        rooms.put("1002" , Room(1002,"초보자 도움 방"
            ,"- 내 상태를 확인 -"
                    + "\n케릭터의 전반적인 상태를 확인하려면 \"상태\" 또는 \"상\" 이라고 입력합니다."
            ,mapOf("서" to 1003, "북" to 1001)))
        rooms.put("1003", Room(1003,"초보자 도움 방"
            ,"- 물건과의 상호작용 -"
                    + "\n소지품을 확인하려면 \"소지품\" 또는 \"소\" 라고 입력하세요."
            ,mapOf("동" to 1002)))

        setWorldTimer()
        ////    cmd 입력 버튼 눌렸을 때
        world_btn_cmd_enter.setOnClickListener {
            editTextToProcCmd(world_edit_text_cmd.text.toString())
            clearEditText() // 에디트 텍스트 클리어
        }
        displayRoom(worldCurrentRoom)   // 최초 진입시 현재 방 정보를 출력.
    }

    fun displayWorldTime(){
        worldTimeMs += 100L
        val utilWorldTime = UtilWorldTime()
        worldTimeSec = utilWorldTime.getWorldSecFromWorldMilliSec(worldTimeMs)

        var stringWorldTimeSec = ""
        if(worldTimeMs % 1000 == 0L && worldTimeMs != 0L){
            stringWorldTimeSec = "월드 시간:${worldTimeSec} 초"
            val spannable = SpannableString(stringWorldTimeSec)
            spannable.setSpan(ForegroundColorSpan(Color.parseColor("#FF00FF")), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            world_display_object_txt_world_time.setText(spannable, TextView.BufferType.SPANNABLE)
        }


        if(worldTimeMs % 3000 == 0L && worldTimeMs != 0L){
            scrollToEnd()
            addObjectToObjectScreen()
        }
    }

    fun setWorldTimer() {
        timer(period = 100) {
            runOnUiThread {
                displayWorldTime()
            }
        }
    }

    /**
     * 스크롤스크린에 에디트 텍스트에 입력한 글을 추가함
     */
    fun addEditTextToScrollScreen(s : String?){
        val topTV1 = TextView(this)
        topTV1.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        topTV1.setBackgroundColor(Color.parseColor("#00FFFFFF"))
        topTV1.setPadding(10, 0, 10, 0)
        topTV1.setTextColor(Color.parseColor("#FF7200"))
        topTV1.textSize = 10f
        topTV1.text = s
        world_scroll_ll.addView(topTV1)
    }

    /**
     * 오브젝트 스크린에 오브젝트 표시
     */
    fun addObjectToObjectScreen(){
        val topTV1 = TextView(this)
        topTV1.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        topTV1.setBackgroundColor(Color.parseColor("#00FFFFFF"))
        topTV1.setPadding(10, 0, 10, 0)
        topTV1.setTextColor(Color.parseColor("#FF7200"))
        topTV1.textSize = 10f
        topTV1.text = "Kaminus"

        val plControl = topTV1.layoutParams as FrameLayout.LayoutParams /*변경하고 싶은 레이아웃의 파라미터 값을 가져 옴*/
        /*해당 margin값 변경*/
        plControl.bottomMargin = 30
        plControl.topMargin = 30
        plControl.leftMargin = 30
        /*변경된 값의 파라미터를 해당 레이아웃 파라미터 값에 셋팅*/
        topTV1.layoutParams = plControl
        world_display_obj_fl.addView(topTV1)
    }

    fun scrollToEnd(){
        Handler().postDelayed(Runnable {
            //여기에 딜레이 후 시작할 작업들을 입력
            world_scroll.fullScroll(View.FOCUS_DOWN)
        }, 100) // n (ms)초 정도 딜레이를 준 후 시작
    }

    // 에디트 텍스트에 입력된 글 명령어를 처리
    fun editTextToProcCmd(cmd : String){
        // 명령이 영어면 한글로 변환(일단 출구명령들만)
        val cmd = changInputExitEnglishNameToKorean(cmd)
        checkAvailIntoRoomExit(worldCurrentRoom, cmd)
    }

    // 에디트 텍스트에 입력된 내용을 삭제
    fun clearEditText(){
        world_edit_text_cmd.text.clear()
    }

    //// 이동 처리
    fun checkAvailIntoRoomExit(roomId : Int, cmdDirection : String) {
        var availEnterRommNumber : Int = rooms[roomId.toString()]?.exits?.get(cmdDirection) ?: 0
        if(availEnterRommNumber != 0){
            worldCurrentRoom = availEnterRommNumber // 방 이동 처리
            ////    새 방 정보 출력
            displayRoom(worldCurrentRoom)
            scrollToEnd()
        }
    }

    fun changInputExitEnglishNameToKorean(s : String) : String{
        return when(s){
            "e" -> "동"
            "w" -> "서"
            "s" -> "남"
            "n" -> "북"
            "d" -> "밑"
            "u" -> "위"
            else -> ""
        }
    }

    fun displayRoom(roomId : Int){
        val stringRoomId = roomId.toString()
        addEditTextToScrollScreen(String.format(resources.getString(R.string.format_world_room_title), rooms[stringRoomId]?.title))
        addEditTextToScrollScreen(rooms[stringRoomId]?.desc)
    }
}