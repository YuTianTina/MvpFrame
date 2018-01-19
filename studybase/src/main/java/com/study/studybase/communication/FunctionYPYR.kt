package com.study.studybase.communication

/**
 *
 * 2018/1/19
 * Description: 执行有参数有返回值的方法
 * @author yutt
 */
abstract class FunctionYPYR (functionName: String) : Function(functionName){
    abstract fun <PARAMS, RESULT> doOnListener(params : PARAMS) : RESULT
}