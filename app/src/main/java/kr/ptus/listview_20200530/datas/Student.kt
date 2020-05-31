package kr.ptus.listview_20200530.datas

import java.io.Serializable

class Student(inputName: String, iby : Int, gender: Boolean) : Serializable {

    val name = inputName
    val birthYear = iby
    val isMale = gender

    fun getKoreanAge(year : Int ) : Int {

        return  year  - this.birthYear + 1

    }


}