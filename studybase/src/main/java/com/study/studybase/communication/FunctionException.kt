package com.study.studybase.communication

/**
 *
 * 2018/1/19
 * Description: 通信异常
 * @author yutt
 */
class FunctionException(exception : String) : Exception(){
    companion object {
        val errorMessage : String = "No such Method"
    }
}