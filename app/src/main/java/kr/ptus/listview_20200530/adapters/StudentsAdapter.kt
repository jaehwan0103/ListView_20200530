package kr.ptus.listview_20200530.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kr.ptus.listview_20200530.R
import kr.ptus.listview_20200530.datas.Student
import java.util.ArrayList

class StudentsAdapter(context: Context, resId: Int, list: List<Student>) :
    ArrayAdapter<Student>(context, resId, list) {

    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null){
            tempRow = inf.inflate(R.layout.students_list_item, null)

        }

        val row = tempRow!!

        val data = mList.get(position)
        val nameAndAgeTxt = row.findViewById<TextView>(R.id.nameAndAgeTxt)
        val genderTxt = row.findViewById<TextView>(R.id.genderTxt)

        nameAndAgeTxt.text = "${data.name}(${data.getKoreanAge(2020)}세)"

        if (data.isMale){

            genderTxt.text = "남성 수강생"

        }

        else {
            genderTxt.text = "여성 수강생"
        }

        return row

    }


}