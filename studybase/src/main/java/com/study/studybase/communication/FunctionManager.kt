package com.study.studybase.communication

/**
 *
 * 2018/1/19
 * Description: 通信管理类
 * @author yutt
 */
class FunctionManager{
    private var npnrMap : MutableMap<String, FunctionNPNR> = HashMap()
    private var npyrMap : MutableMap<String, FunctionNPYR> = HashMap()
    private var ypnrMap : MutableMap<String, FunctionYPNR> = HashMap()
    private var ypyrMap : MutableMap<String, FunctionYPYR> = HashMap()
    /**
     * 添加方法
     */
    fun add(function: Function) : FunctionManager{
        val functionName : String = function.functionName
        when(function){
            is FunctionNPNR -> npnrMap[functionName] = function
            is FunctionNPYR -> npyrMap[functionName] = function
            is FunctionYPNR -> ypnrMap[functionName] = function
            is FunctionYPYR -> ypyrMap[functionName] = function
        }
        return this
    }

    /**
     * 清除所有Functions
     */
    fun clear(){
        npnrMap.clear()
        npyrMap.clear()
        ypnrMap.clear()
        ypyrMap.clear()
    }

    fun avoidNPNR(functionName : String){
        npnrMap[functionName]?.doOnListener() ?: throw FunctionException(FunctionException.errorMessage)
    }

    fun <RESULT> avoidNPYR(functionName: String) : RESULT {
        return npyrMap[functionName]?.doOnListener() ?: throw FunctionException(FunctionException.errorMessage)
    }

    fun <PARAMS> avoidYPNR(functionName: String, params : PARAMS){
        ypnrMap[functionName]?.doOnListener(params) ?: throw FunctionException(FunctionException.errorMessage)
    }

    fun <PARAMS, RESULT> avoidYPYR(functionName: String, params: PARAMS) : RESULT{
        return ypyrMap[functionName]?.doOnListener(params) ?: throw FunctionException(FunctionException.errorMessage)
    }



}