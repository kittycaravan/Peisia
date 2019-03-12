package com.peisia.peisia.ui
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.peisia.peisia.R
import kotlinx.android.synthetic.main.activity_character_create.*
import kotlinx.android.synthetic.main.activity_entrance.*
import org.jetbrains.anko.startActivity
class ActivityEntrance : AppCompatActivity() {
    private val TAG = this::class.simpleName // 태그 설정. 당분간 이걸로.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)

        Toast.makeText(this, "현관에 들어왔다~", Toast.LENGTH_SHORT).show()
        Log.v(TAG,"==== ==== $TAG 야옹")

        entrance_btn_login.setOnClickListener{
            startActivity<ActivityLogin>()   // anko 라이브러리를 이용한 액티비티 전환.
        }

        entrance_btn_reg.setOnClickListener{
            startActivity<ActivityReg>()   // anko 라이브러리를 이용한 액티비티 전환.
        }
    }
}
