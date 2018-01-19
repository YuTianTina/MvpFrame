package com.study.studybase.communication

/**
 *
 * 2018/1/19
 * Description: 执行无参数有返回值的方法
 * @author yutt
 */
abstract class FunctionNPYR(functionName : String) : Function(functionName) {
    abstract fun <Result> doOnListener () : Result
}