package com.peisia.peisia.ui
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.peisia.peisia.R
class ActivityCharacterCreate : AppCompatActivity() {
    private val TAG = this::class.simpleName // 태그 설정. 당분간 이걸로.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_create)

        Toast.makeText(this, "케릭터 생성화면에 들어왔다~", Toast.LENGTH_SHORT).show()
        Log.v(TAG,"==== ==== $TAG 야옹")
    }
}
