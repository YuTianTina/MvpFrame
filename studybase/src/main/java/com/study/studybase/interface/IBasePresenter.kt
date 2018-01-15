package com.study.studybase.`interface`

/**
 *
 * 2018/1/15
 * e-mail: yutt@xinguangnet.com
 * Description: 底层P层的接口
 * @author yutt
 */
interface IBasePresenter<in IBaseView>{
    /**
     * View 的绑定
     */
    fun attachView(view:  IBaseView)

    /**
     * View 的解绑
     */
    fun detachView()
}