package com.peisia.peisia.ui
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.peisia.peisia.R
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class ActivityLogin : AppCompatActivity() {
    private val TAG = this::class.simpleName // 태그 설정. 당분간 이걸로.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Toast.makeText(this, "로그인화면에 들어왔다~", Toast.LENGTH_SHORT).show()
        Log.v(TAG,"==== ==== $TAG 야옹")

        login_btn_login.setOnClickListener {
            //todo: 로그인처리

            //todo: id,pw 유효하게 로그인하면 게이트 진입
            if(true){
                startActivity<ActivityGate>()   // anko 라이브러리를 이용한 액티비티 전환.
            }
        }
    }
}
