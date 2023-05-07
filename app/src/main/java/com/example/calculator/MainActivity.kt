package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var mainTV: EditText
    private lateinit var znakTV: TextView
    private lateinit var btn_0: Button
    private lateinit var btn_1: Button
    private lateinit var btn_2: Button
    private lateinit var btn_3: Button
    private lateinit var btn_4: Button
    private lateinit var btn_5: Button
    private lateinit var btn_6: Button
    private lateinit var btn_7: Button
    private lateinit var btn_8: Button
    private lateinit var btn_plus: Button
    private lateinit var btn_minus: Button
    private lateinit var btn_del: Button
    private lateinit var btn_ymn: Button
    private lateinit var btn_9: Button
    private lateinit var btn_clear: Button
    private lateinit var btn_back: Button
    private lateinit var btn_double: Button
    private lateinit var btn_equal: Button
    private lateinit var secondTV: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainTV=findViewById(R.id.main_tv)
        init()
        btn_0.setOnClickListener { setText("0") }
        btn_1.setOnClickListener { setText("1") }
        btn_2.setOnClickListener { setText("2") }
        btn_3.setOnClickListener { setText("3") }
        btn_4.setOnClickListener { setText("4") }
        btn_5.setOnClickListener { setText("5") }
        btn_6.setOnClickListener { setText("6") }
        btn_7.setOnClickListener { setText("7") }
        btn_8.setOnClickListener { setText("8") }
        btn_9.setOnClickListener { setText("9") }
        btn_double.setOnClickListener {
            val str_main=mainTV.text.toString()
            if(str_main.isNotEmpty()&&str_main!="-"&&!str_main.contains(".")) {
                setText(".")
            }
        }
        btn_plus.setOnClickListener {
            math_operation("+")
        }
        btn_minus.setOnClickListener {
            minus_operation()
        }
        btn_del.setOnClickListener {
            math_operation("/")
        }
        btn_ymn.setOnClickListener {
            math_operation("x")
        }
        btn_clear.setOnClickListener {
            mainTV.setText("")
            znakTV.text=""
            secondTV.text=""
        }
        btn_back.setOnClickListener {
             val str=mainTV.text.toString()
            if(str.isNotEmpty()){
                mainTV.setText(str.substring(0,str.length-1))
            }
        }
        btn_equal.setOnClickListener {
            equal_operation()
        }
    }
    fun setText(str:String){
        mainTV.append(str)
    }
    fun setZnak(str: String){
        znakTV.append(str)

    }

    fun init(){
        btn_0=findViewById(R.id.btn_18)
        btn_1=findViewById(R.id.btn_5)
        btn_2=findViewById(R.id.btn_6)
        btn_3=findViewById(R.id.btn_7)
        btn_4=findViewById(R.id.btn_9)
        btn_5=findViewById(R.id.btn_10)
        btn_6=findViewById(R.id.btn_11)
        btn_7=findViewById(R.id.btn_13)
        btn_8=findViewById(R.id.btn_14)
        btn_9=findViewById(R.id.btn_15)
        znakTV=findViewById(R.id.znak_tv)
        btn_plus=findViewById(R.id.btn_16)
        btn_minus=findViewById(R.id.btn_12)
        btn_ymn=findViewById(R.id.btn_8)
        btn_del=findViewById(R.id.btn_4)
        btn_clear=findViewById(R.id.btn_1)
        secondTV=findViewById(R.id.second_tv)
        btn_back=findViewById(R.id.btn_17)
        btn_equal=findViewById(R.id.btn_20)
        btn_double=findViewById(R.id.btn_19)
    }
    fun math_operation(sign:String){
        val str_main=mainTV.text.toString()
        var str_znak=znakTV.text.toString()
        val str_second=secondTV.text.toString()
        var result:Double

        if(str_main.isNotEmpty()&&str_znak.isNotEmpty()&&str_second.isNotEmpty()){
            if(str_znak.equals("+")){
                if(str_main=="-"){
                    Toast.makeText(this,"Введите число корректно",Toast.LENGTH_SHORT).show()
                }else {
                    result = str_second.toDouble() + str_main.toDouble()
                    mainTV.setText("")
                    znakTV.text = sign
                    secondTV.text = result.toString()
                }

            }
            else if(str_znak.equals("-")){
                if(str_main=="-"){
                    Toast.makeText(this,"Введите число корректно",Toast.LENGTH_SHORT).show()
                }else {
                    result = str_second.toDouble() - str_main.toDouble()
                    mainTV.setText("")
                    znakTV.text = sign
                    secondTV.text = result.toString()
                }

            }
            else if(str_znak.equals("/")){
                if(str_main=="-"){
                    Toast.makeText(this,"Введите число корректно",Toast.LENGTH_SHORT).show()
                }else {
                    result = str_second.toDouble() / str_main.toDouble()
                    mainTV.setText("")
                    znakTV.text = sign
                    secondTV.text = result.toString()
                }

            }
            else if(str_znak.equals("x")){
                if(str_main=="-"){
                    Toast.makeText(this,"Введите число корректно",Toast.LENGTH_SHORT).show()
                }else {
                    result = str_second.toDouble() * str_main.toDouble()
                    mainTV.setText("")
                    znakTV.text = sign
                    secondTV.text = result.toString()
                }

            }
        }
        if(str_main.isNotEmpty()&&str_znak.isEmpty()&&str_second.isEmpty()) {
            if(str_main=="-")
                Toast.makeText(this,"Введите число корректно",Toast.LENGTH_SHORT).show()
            else {
                setZnak(sign)
                secondTV.text = mainTV.text.toString()
                mainTV.setText("")
            }
        }
    }
    fun minus_operation(){
        val str_main=mainTV.text.toString()
        var str_znak=znakTV.text.toString()
        val str_second=secondTV.text.toString()
        var result:Double
        if(str_main.isEmpty()&&str_znak.isEmpty()&&str_second.isEmpty()){
            setText("-")
        }
        if(str_main.isEmpty()&&str_znak.isNotEmpty()&&str_second.isNotEmpty()){
            setText("-")
        }
        if(str_main.isNotEmpty()&&str_znak.isNotEmpty()&&str_second.isNotEmpty()){
            if(str_znak.equals("+")){
                if(str_main=="-"){
                    Toast.makeText(this,"Введите число корректно",Toast.LENGTH_SHORT).show()
                }else {
                    result = str_second.toDouble() + str_main.toDouble()
                    mainTV.setText("")
                    znakTV.text = "-"
                    secondTV.text = result.toString()
                }

            }
            else if(str_znak.equals("-")){
                if(str_main=="-"){
                    Toast.makeText(this,"Введите число корректно",Toast.LENGTH_SHORT).show()
                }else {
                    result = str_second.toDouble() - str_main.toDouble()
                    mainTV.setText("")
                    setZnak("-")
                    secondTV.text = result.toString()
                }

            }
            else if(str_znak.equals("/")){
                if(str_main=="-"){
                    Toast.makeText(this,"Введите число корректно",Toast.LENGTH_SHORT).show()
                }else {
                    result = str_second.toDouble() / str_main.toDouble()
                    mainTV.setText("")
                    znakTV.text = "-"
                    secondTV.text = result.toString()
                }

            }
            else if(str_znak.equals("x")){
                if(str_main=="-"){
                    Toast.makeText(this,"Введите число корректно",Toast.LENGTH_SHORT).show()
                }else {
                    result = str_second.toDouble() * str_main.toDouble()
                    mainTV.setText("")
                    znakTV.text = "-"
                    secondTV.text = result.toString()
                }

            }
        }
        if(str_main.isNotEmpty()&&str_znak.isEmpty()&&str_second.isEmpty()) {
            if(str_main=="-"){
                Toast.makeText(this,"Введите число корректно",Toast.LENGTH_SHORT).show()
            }else {
                setZnak("-")
                secondTV.text = mainTV.text.toString()
                mainTV.setText("")
            }
        }
    }
    fun equal_operation(){
        val str_main=mainTV.text.toString()
        val str_znak=znakTV.text.toString()
        val str_second=secondTV.text.toString()
        var result:Double
        if(str_main.isNotEmpty()&&str_znak.isNotEmpty()&&str_second.isNotEmpty()){
            if(str_znak.equals("+")){
                if(str_main=="-"){
                    Toast.makeText(this,"Введите число корректно",Toast.LENGTH_SHORT).show()
                }else {
                    result = str_second.toDouble() + str_main.toDouble()
                    mainTV.setText(result.toString())
                    znakTV.text = ""
                    secondTV.text = ""
                }

            }
            else if(str_znak.equals("-")){
                if(str_main=="-"){
                    Toast.makeText(this,"Введите число корректно",Toast.LENGTH_SHORT).show()
                }else {
                    result = str_second.toDouble() - str_main.toDouble()
                    mainTV.setText(result.toString())
                    znakTV.text = ""
                    secondTV.text = ""
                }

            }
            else if(str_znak.equals("/")){
                if(str_main=="-"){
                    Toast.makeText(this,"Введите число корректно",Toast.LENGTH_SHORT).show()
                }else {
                    result = str_second.toDouble() / str_main.toDouble()
                    mainTV.setText(result.toString())
                    znakTV.text = ""
                    secondTV.text = ""
                }

            }
            else if(str_znak.equals("x")){
                if(str_main=="-"){
                    Toast.makeText(this,"Введите число корректно",Toast.LENGTH_SHORT).show()
                }else {
                    result = str_second.toDouble() * str_main.toDouble()
                    mainTV.setText(result.toString())
                    znakTV.text = ""
                    secondTV.text = ""
                }

            }
        }
    }

}