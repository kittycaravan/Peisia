package com.peisia.peisia

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    var mAuth : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        FirebaseApp.initializeApp(this) // 이걸 책에서 배먹음 =ㅅ= 모르는 사람들은 어쩌라고 // 이거 안해도 잘됨 =ㅅ= 뭔가 정책이 바뀐듯

        mAuth = FirebaseAuth.getInstance()

        createUserId("kittycaravan@gmail.com","abcd1234@@")
    }

    fun createUserId(email : String, pw : String){
        mAuth?.createUserWithEmailAndPassword(email, pw)
            ?.addOnCompleteListener(this,{ task ->
                if(task.isSuccessful) {
                    Log.i("TAG","==== ==== 야아옹")
                } else {
                    Log.i("TAG","==== ==== 아우웅..")
                }
            })
    }
}
