package com.example.nam.demobasekotlin.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.nam.demobasekotlin.BuildConfig
import java.lang.reflect.InvocationTargetException

/**
 * Created by nam on 11/12/2017.
 */
class BaseSubActivity : BaseActivity() {

    private lateinit var  fragment : BaseFragment
    companion object {
        val EXTRA_FRAGMENT_CLASS = BuildConfig.APPLICATION_ID + ".EXTRA_FRAGMENT_CLASS"
        val EXTRA_FRAGMENT_ARGS = BuildConfig.APPLICATION_ID + ".EXTRA_FRAGMENT_ARGS"
        fun createIntent(context:Context):Intent {
            return Intent(context,BaseSubActivity::class.java)
        }
        fun start(activity:Activity,intent:Intent) {
            activity.startActivity(intent)
        }

        fun startForResulrt(activity: Activity,intent: Intent,requestCode:Int){
            activity.startActivityForResult(intent,requestCode)
        }

        fun startForResult(activity: Activity, intent: Intent, requestCode: Int) {
            activity.startActivityForResult(intent, requestCode)
        }
    }

    override fun initFragment(): BaseFragment? {
        val extras = intent.extras ?: return null
        val clazz = extras.getSerializable(EXTRA_FRAGMENT_CLASS) as Class<*>

        try {
            val c = clazz.getConstructor()
            try {
                fragment = c.newInstance() as BaseFragment
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InvocationTargetException) {
                e.printStackTrace()
            }

        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        }

          val args = extras.getBundle(EXTRA_FRAGMENT_ARGS)
          if (args != null) fragment.setArguments(args)
        return fragment
    }

}