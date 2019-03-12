package com.peisia.peisia.ui
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.peisia.peisia.R
import org.jetbrains.anko.startActivity
class ActivitySplash : AppCompatActivity() {
    private val TAG = this::class.simpleName // 태그 설정. 당분간 이걸로.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Toast.makeText(this, "스플래시 애니가 나오고 있다~", Toast.LENGTH_SHORT).show()
        Log.v(TAG,"==== ==== $TAG 야옹")

        //todo 애니메이션 후 다음 액티 이동
        // 2019.3.10 sungmo.ahn 스플래시에서 5초후 액티비티메인 이동
        Handler().postDelayed({
            finish()    // 현 스플래시 액티비티는 끝.
            startActivity<ActivityEntrance>()   // anko 라이브러리를 이용한 액티비티 전환.
        }, 5000)
    }
}
