package com.study.studybase.communication

/**
 *
 * 2018/1/19
 * Description: 执行无参数无返回值
 * @author yutt
 */
abstract class FunctionNPNR (functionName : String): Function(functionName){
    abstract fun doOnListener()
}