package kr.ptus.listview_20200530

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kr.ptus.listview_20200530.adapters.StudentsAdapter
import kr.ptus.listview_20200530.datas.Student
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    val students = ArrayList<Student>()
    lateinit var studentAdapter : StudentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        students.add(Student("조경진", 1988, gender = true))
        students.add(Student("김광철", 1966, gender = true))
        students.add(Student("김재환", 1993, gender = true))
        students.add(Student("박수정", 1994, gender = false))
        students.add(Student("신용석", 1988, gender = true))
        students.add(Student("엄곤지", 1984, gender = false))
        students.add(Student("이승원", 1978, gender = true))
        students.add(Student("이현호", 1981, gender = true))

        studentAdapter = StudentsAdapter(this, R.layout.students_list_item, students)

        studentsListView.adapter = studentAdapter

    }
}
