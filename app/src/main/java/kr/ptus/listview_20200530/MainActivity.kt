package kr.ptus.listview_20200530

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kr.ptus.listview_20200530.adapters.StudentsAdapter
import kr.ptus.listview_20200530.datas.Student
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    val students = ArrayList<Student>()
    lateinit var studentAdapter: StudentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        students.add(Student("조경진", 1988, true))
        students.add(Student("김광철", 1966, true))
        students.add(Student("김재환", 1993, true))
        students.add(Student("박수정", 1994, false))
        students.add(Student("신용석", 1988, true))
        students.add(Student("엄곤지", 1984, false))
        students.add(Student("이승원", 1978, true))
        students.add(Student("이현호", 1981, true))

        studentAdapter = StudentsAdapter(this, R.layout.students_list_item, students)

        studentsListView.adapter = studentAdapter

        studentsListView.setOnItemClickListener { parent, view, position, id ->
            Log.d("리스트뷰아이템클릭", "${position}번줄 클릭")

            val clickedStudent = students.get(position)

            val myIntent = Intent(this, ViewStudentActivity::class.java)
            myIntent.putExtra("student", clickedStudent)
            startActivity(myIntent)

        }

        studentsListView.setOnItemLongClickListener { parent, view, position, id ->
//            Toast.makeText(this,"${position}번 줄 롱클릭",Toast.LENGTH_SHORT).show()

            val alert = AlertDialog.Builder(this)
            alert.setTitle("수강생 삭제")
            alert.setMessage("정말 이 수강생을 삭제 하시겟습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->

                students.removeAt(position)
                studentAdapter.notifyDataSetChanged()

            })
            alert.setNegativeButton("취소", null)
            alert.show()


            return@setOnItemLongClickListener true
        }

    }
}
