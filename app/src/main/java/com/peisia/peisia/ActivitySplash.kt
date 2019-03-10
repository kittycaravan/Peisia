package com.peisia.peisia

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.jetbrains.anko.startActivity

class ActivitySplash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 2019.3.10 sungmo.ahn 스플래시에서 5초후 액티비티메인 이동
        Handler().postDelayed({
            finish()    // 현 스플래시 액티비티는 끝.
            startActivity<ActivityMain>()   // anko 라이브러리를 이용한 액티비티 전환.
        }, 5000)
    }
}
