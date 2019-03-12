package com.peisia.peisia.ui
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.peisia.peisia.R
import kotlinx.android.synthetic.main.activity_gate.*
import org.jetbrains.anko.startActivity

class ActivityGate : AppCompatActivity() {
    private val TAG = this::class.simpleName // 태그 설정. 당분간 이걸로.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gate)

        Toast.makeText(this, "게이트 앞에 왔다~", Toast.LENGTH_SHORT).show()
        Log.v(TAG,"==== ==== $TAG 야옹")

        //todo: 케릭터 선택하기

        gate_btn_create_character.setOnClickListener {
            //todo: 케릭터 생성
            startActivity<ActivityCharacterCreate>()   // anko 라이브러리를 이용한 액티비티 전환.
        }

        gate_btn_enter_single_game.setOnClickListener {
            //todo: 월드 진입. (케릭터 선택 후 진입하도록 수정할 것)
            startActivity<ActivityWorld>()   // anko 라이브러리를 이용한 액티비티 전환.
        }
    }
}
