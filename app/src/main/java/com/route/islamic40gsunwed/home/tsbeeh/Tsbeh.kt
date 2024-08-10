package com.route.islamic40gsunwed.home.tsbeeh

import com.route.islamic40gsunwed.Constants

class Tsbeh {
    private var tsbehList = arrayOf("Sobhan allah","Elhamd lelah", "La aelah aela allah","Allah akber" )
     var counter: Int = 0
    private var index: Int = 0
     private fun isLimitExceeded(): Boolean{
        return counter == Constants.ZEKR_LIMIT
    }
     fun getCurrentTsbeh(): String{
        return tsbehList.get(index)
    }
     fun incrementTsbeeh(){
        counter++
        if(isLimitExceeded()){
            counter =0
            index = ++index%4

        }
    }

}