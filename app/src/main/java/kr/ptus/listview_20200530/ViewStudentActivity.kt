package kr.ptus.listview_20200530

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_student.*
import kr.ptus.listview_20200530.datas.Student

class ViewStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student)

        val student = intent.getSerializableExtra("student") as Student

        nameTxt.text = student.name
        ageTxt.text = "${student.getKoreanAge(2020)}세 (${student.birthYear})"

        if (student.isMale) {
            genederTxt.text = "남성"
        } else {
            genederTxt.text = "여성"
        }


    }
}
