package com.study.studybase.communication

/**
 *
 * 2018/1/19
 * Description: 执行有参数无返回值的方法
 * @author yutt
 */
abstract class FunctionYPNR(functionName : String) : Function(functionName) {
    abstract fun <PARAMS> doOnListener(params : PARAMS)
}