package com.peisia.peisia.ui
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.peisia.peisia.R
import kotlinx.android.synthetic.main.activity_world.*
import kotlin.concurrent.timer
class ActivityWorld : AppCompatActivity() {
    private val TAG = this::class.simpleName // 태그 설정. 당분간 이걸로.
    var n = 0

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
    }

    fun setWorldTimer() {
        timer(period = 100) {
            runOnUiThread {
                addTextColor()
            }
        }
    }
}
