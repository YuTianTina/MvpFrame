package com.study.studybase.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.study.studybase.R
import com.study.studybase.`interface`.IBaseView
import com.study.studybase.communication.FunctionManager

/**
 *
 * 2018/1/15
 * Description: 基类Activity
 * @author yutt
 */
abstract class AbstractActivityBase : AppCompatActivity(), IBaseView, View.OnClickListener {

    /**
     * 内容主flame
     */
    private var flBase : FrameLayout? = null
    /**
     * 标题栏
     */
    private var toolbar : Toolbar? = null
    /**
     * 标题栏的正文标题
     */
    private var tvTitle : TextView? = null
    /**
     * 标题栏的右边栏位
     */
    private var tvRight : TextView? = null
    /**
     * 标题栏的左边回退键
     */
    private var imgLeft: ImageView? = null

    var context : Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)
        context = this
        // Toolbar初始化
        initToolbar()
        // baseView初始化
        initBaseView(savedInstanceState)
    }

    abstract fun initPresenter()

    /**
     * 初始化baseView
     */
    private fun initBaseView(savedInstanceState: Bundle?) {
        flBase = findViewById(R.id.fl_content)
        val viewContent = layoutInflater.inflate(getContentLayout(), flBase, true)
        initLoad(viewContent, savedInstanceState)
    }

    /**
     * 标题栏的初始化
     */
    private fun initToolbar(){
        toolbar = findViewById(R.id.tb)
        toolbar?.removeAllViews()
        val customNormalToolbar : View = layoutInflater.inflate(R.layout.base_layout_toolbar, null)
        tvTitle = customNormalToolbar.findViewById(R.id.tv_title)
        tvRight = customNormalToolbar.findViewById(R.id.tv_right)
        imgLeft = customNormalToolbar.findViewById(R.id.img_left)
        imgLeft?.setOnClickListener(this)
        val lp : Toolbar.LayoutParams = Toolbar.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        toolbar?.addView(customNormalToolbar, lp)
    }

    /**
     * 获取主视觉的layoutId
     */
    @LayoutRes abstract fun getContentLayout() : Int

    /**
     * 界面初始化
     */
    abstract fun initLoad(view : View, savedInstanceState: Bundle?)

    /**
     * 设置标题栏正文标题
     */
    fun setToolbarTitle(@StringRes resId : Int){
        tvTitle?.text = getString(resId)
    }
    /**
     * 设置标题栏的左边按键的图案
     */
    fun setToolbarLeft(@DrawableRes resId: Int){
        imgLeft?.setImageResource(resId)
    }
    /**
     * 设置标题栏右边的文本内容
     */
    fun setToolbarRight(@StringRes resId: Int){
        setToolbarRightVisible(true)
        tvRight?.text = getString(resId)
    }

    /**
     * 设置标题栏右边的点击事件
     */
    fun setToolbarRightOnClick(listener : View.OnClickListener){
        setToolbarRightVisible(true)
        tvRight?.setOnClickListener(listener)
    }

    /**
     * 设置标题栏右边是否可见
     */
    fun setToolbarRightVisible(visibility : Boolean){
        if(visibility){
            if(View.GONE == tvRight?.visibility){
                tvRight?.visibility = View.VISIBLE
            }
        }else{
            tvRight?.visibility = View.GONE
        }
    }

    fun setToolbarLeftImageOnClick(listener: View.OnClickListener){
        imgLeft?.setOnClickListener(listener)
    }

    override fun onClick(v: View?) {
        when(v){
            imgLeft -> {
                finish()
            }
        }
    }

    /**
     * 通信绑定
     */
    fun bindFragmentCommunity(fragmentTag : String){
        val fm : FragmentManager = supportFragmentManager
        val fragmentBase : AbstractFragmentBase? = fm.findFragmentByTag(fragmentTag) as? AbstractFragmentBase
        voidFragmentCommunity(fragmentBase?.functionManager!!)
    }

    /**
     * 通信处理
     */
    abstract fun voidFragmentCommunity(functionManager: FunctionManager)
}