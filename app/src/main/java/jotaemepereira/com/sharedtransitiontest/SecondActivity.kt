package jotaemepereira.com.sharedtransitiontest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity



class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        if (savedInstanceState == null) {
            postponeEnterTransition()
        }

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment())
                .commit()
    }
}