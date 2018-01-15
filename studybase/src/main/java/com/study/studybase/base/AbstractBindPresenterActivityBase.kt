package com.study.studybase.base

import com.study.studybase.`interface`.IBaseView

/**
 *
 * 2018/1/15
 * e-mail: yutt@xinguangnet.com
 * Description:
 * @author yutt
 */
abstract class AbstractBindPresenterActivityBase<out T : PresenterBase<IBaseView>> : AbstractActivityBase() {
    private var mPresenter : T ? = null

    override fun initPresenter()  {
        this.mPresenter = getPresenter()
        mPresenter?.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detachView()
    }

    abstract fun getPresenter(): T?
}