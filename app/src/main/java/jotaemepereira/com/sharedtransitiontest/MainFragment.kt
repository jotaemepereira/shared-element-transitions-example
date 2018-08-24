package jotaemepereira.com.sharedtransitiontest

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        smallImage.setOnClickListener({ startSecondActivity() })
    }

    private fun startSecondActivity() {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity as AppCompatActivity, smallImage, "test")
        startActivity(Intent(context, SecondActivity::class.java), options.toBundle())
    }
}