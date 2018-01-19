package com.study.studybase.base

import android.content.Context
import android.support.v4.app.Fragment
import com.study.studybase.communication.FunctionManager

/**
 *
 * 2018/1/19
 * Description: base Fragment
 * @author yutt
 */
class AbstractFragmentBase : Fragment(){
    var functionManager : FunctionManager = FunctionManager()
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is AbstractActivityBase){
            context.bindFragmentCommunity(tag)
        }
    }

    override fun onDetach() {
        super.onDetach()
        functionManager.clear()
    }
}