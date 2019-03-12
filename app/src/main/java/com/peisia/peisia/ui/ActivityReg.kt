package com.peisia.peisia.ui
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.peisia.peisia.R
import org.jetbrains.anko.startActivity
class ActivityReg : AppCompatActivity() {
    private val TAG = this::class.simpleName // 태그 설정. 당분간 이걸로.

    var mAuth : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        Toast.makeText(this, "회원가입 화면에 들어왔다~", Toast.LENGTH_SHORT).show()
        Log.v(TAG,"==== ==== $TAG 야옹")

//        FirebaseApp.initializeApp(this) // 이걸 책에서 배먹음 =ㅅ= 모르는 사람들은 어쩌라고 // 이거 안해도 잘됨 =ㅅ= 뭔가 정책이 바뀐듯

        mAuth = FirebaseAuth.getInstance()

        //todo: 하드코딩 아이디/pw 회원 생성
        createUserId("kittycaravan@gmail.com","abcd1234@@")
    }

    fun createUserId(email : String, pw : String){
        mAuth?.createUserWithEmailAndPassword(email, pw)
            ?.addOnCompleteListener(this,{ task ->
                if(task.isSuccessful) {
                    Toast.makeText(this, "회원가입 성공", Toast.LENGTH_LONG)
                    Log.i(TAG,"==== ==== 야아옹")
                    finish()
                    startActivity<ActivityLogin>()   // anko 라이브러리를 이용한 액티비티 전환.
                } else {
                    Toast.makeText(this, "회원가입 실패", Toast.LENGTH_LONG)
                    Log.i(TAG,"==== ==== 아우웅..")
                }
            })
    }
}
