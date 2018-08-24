package jotaemepereira.com.sharedtransitiontest

import android.content.Context
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.image.view.*

class SecondFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view_pager.adapter = ImagePagerAdapter(context!!)
    }

    class ImagePagerAdapter(val context: Context): PagerAdapter() {

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        override fun getCount(): Int {
            return 1
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view = LayoutInflater.from(context).inflate(R.layout.image, container, false)
            view.image.setImageDrawable(context.resources.getDrawable(R.drawable.bug_189903))
            container.addView(view)
            view.setTag("viewImage")
            view.viewTreeObserver.addOnPreDrawListener(
                    object : ViewTreeObserver.OnPreDrawListener {
                        override fun onPreDraw(): Boolean {
                            view.getViewTreeObserver().removeOnPreDrawListener(this)
                            ActivityCompat.startPostponedEnterTransition(context as SecondActivity)
                            return true
                        }
                    })

            return view
        }

    }
}