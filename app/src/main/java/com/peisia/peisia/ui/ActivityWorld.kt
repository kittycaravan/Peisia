package com.peisia.peisia.ui
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.peisia.peisia.R
import com.peisia.peisia.data.Room
import kotlinx.android.synthetic.main.activity_world.*
import kotlin.concurrent.timer
class ActivityWorld : AppCompatActivity() {
    private val TAG = this::class.simpleName // 태그 설정. 당분간 이걸로.
    var n = 0
    var listRooms:List<Room> = listOf(
        Room(1000,"튜토리얼 룸","튜토리얼 룸입니다.",mapOf("동" to 1001)),
        Room(1001,"튜토리얼 룸","튜토리얼 룸입니다.",mapOf("동" to 1002, "서" to 1000)),
        Room(1002,"튜토리얼 룸","튜토리얼 룸입니다.",mapOf("동" to 1003, "서" to 1001)),
        Room(1003,"튜토리얼 룸","튜토리얼 룸입니다.",mapOf("동" to 1004, "서" to 1002))
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_world)

        Toast.makeText(this, "헬로! 키티! 월드! 에 들어왔다!!!", Toast.LENGTH_SHORT).show()
        Log.v(TAG,"==== ==== $TAG 야옹")

        setWorldTimer()
    }

    fun addTextColor(){
        var s = "고양이가 말합니다. \"야아옹~ 월드 타임 : $n 초\""
        s += "\n개도 말합니다. \"월 월\""
        val spannable = SpannableString(s)
        spannable.setSpan(ForegroundColorSpan(Color.parseColor("#FF00FF")), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        text2.setText(spannable, TextView.BufferType.SPANNABLE)
        n += 100

        if(n % 3000 == 0 && n != 0){
            addText()
            scrollToEnd()
            addText2()
        }
    }

    fun setWorldTimer() {
        timer(period = 100) {
            runOnUiThread {
                addTextColor()
            }
        }
    }

    fun addText(){
        val topTV1 = TextView(this)
        topTV1.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        topTV1.setBackgroundColor(Color.parseColor("#00FFFFFF"))
        topTV1.setPadding(20, 10, 10, 10)
        topTV1.setTextColor(Color.parseColor("#FF7200"))
        topTV1.textSize = 13f
//        topTV1.text = "야옹이"
        topTV1.text = listRooms[2].title
        world_scroll_ll.addView(topTV1)
    }

    fun addText2(){
        val topTV1 = TextView(this)
        topTV1.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        topTV1.setBackgroundColor(Color.parseColor("#00FFFFFF"))
        topTV1.setPadding(20, 10, 10, 10)
        topTV1.setTextColor(Color.parseColor("#FF7200"))
        topTV1.textSize = 13f
        topTV1.text = "프레임에 텍스트"

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
//        runOnUiThread {
            world_scroll.fullScroll(View.FOCUS_DOWN)
//        }
    }
}
