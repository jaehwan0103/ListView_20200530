package kr.ptus.listview_20200530.datas

class Student(inputName: String, iby : Int, gender: Boolean) {

    val name = inputName
    val birthYear = iby
    val isMale = gender

    fun getKoreanAge(year : Int ) : Int {

        return  year  - this.birthYear + 1

    }


}