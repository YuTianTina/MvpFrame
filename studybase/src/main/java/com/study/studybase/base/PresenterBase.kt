package com.study.studybase.base

import com.study.studybase.`interface`.IBasePresenter
import com.study.studybase.`interface`.IBaseView

/**
 *
 * 2018/1/15
 * e-mail: yutt@xinguangnet.com
 * Description: 基础P层
 * @author yutt
 */
class PresenterBase<in T : IBaseView> : IBasePresenter<T> {
    private var baseView : T ? = null

    override fun attachView(view: T) {
        this.baseView = view
    }

    override fun detachView() {
        this.baseView = null
    }

    fun isViewAttach (): Boolean{
        return null == baseView
    }

    fun checkViewAttach(){
        if(!isViewAttach()) throw IllegalStateException("View should be attached")
    }
}