package com.example.studentregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentregister.db.Student
import com.example.studentregister.db.StudentDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var clearButton: Button
    private lateinit var studentRecyclerView: RecyclerView
    private lateinit var viewModel: StudentViewModel
    private lateinit var adapter: StudentRecyclerViewAdapter
    private lateinit var selectedStudent: Student
    private var isListItemClicked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameEditText = findViewById(R.id.etName)
        emailEditText = findViewById(R.id.etEmail)
        saveButton = findViewById(R.id.btnSave)
        clearButton = findViewById(R.id.btnClear)
        studentRecyclerView = findViewById(R.id.rvStudent)

        val dao = StudentDatabase.getInstance(application).getStudentDao()
        val factory = StudentViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory).get(StudentViewModel::class.java)

        saveButton.setOnClickListener {
            if (isListItemClicked) {
                updateStudentData()
                clearFields()
            } else {
                saveStudent()
                clearFields()
            }
        }
        clearButton.setOnClickListener {
            if (isListItemClicked) {
                deleteStudentData()
                clearFields()
            } else {
                clearFields()
            }
        }
        initRecyclerView()

    }

    private fun saveStudent() {
//        val name = nameEditText.text.toString()
//        val email = emailEditText.text.toString()
//        val student = Student(0,name,email)
//        viewModel.insertStudent(student)
        viewModel.insertStudent(
            Student(
                0,
                nameEditText.text.toString(),
                emailEditText.text.toString()
            )

        )
    }

    private fun updateStudentData() {
        viewModel.updateStudent(
            Student(
                selectedStudent.id,
                nameEditText.text.toString(),
                emailEditText.text.toString()
            )
        )

        saveButton.text = "Save"
        clearButton.text = "Clear"
        isListItemClicked = true


    }

    private fun deleteStudentData() {
        viewModel.deleteStudent(
            Student(
                selectedStudent.id,
                nameEditText.text.toString(),
                emailEditText.text.toString()
            )
        )
    }
    private fun clearFields() {
        nameEditText.setText("")
        emailEditText.setText("")

    }
    private fun initRecyclerView(){
        studentRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = StudentRecyclerViewAdapter{
            selectedItem : Student -> listenItemClicked(selectedItem)
        }
        studentRecyclerView.adapter = adapter
        displayStudents()
    }

    private fun displayStudents() {
        viewModel.Students.observe(this, {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })
    }

    private fun listenItemClicked(student: Student){
//        Toast.makeText(
//            this,
//            "Student name is ${student.name} ",
//            Toast.LENGTH_LONG
//        ).show()
        selectedStudent = student
        saveButton.text = "Update"
        clearButton.text = "Delete"
        isListItemClicked = true
        nameEditText.setText(selectedStudent.name)
        emailEditText.setText(selectedStudent.email)
    }
}