package com.study.studybase.base

import android.app.Application
import kotlin.properties.Delegates

/**
 *
 * 2018/1/30
 * Description:
 * @author yutt
 */
class BaseApplication : Application() {
  companion object {
      var instance : BaseApplication by Delegates.notNull()
  }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}