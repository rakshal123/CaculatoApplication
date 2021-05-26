package com.example.calculatorapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    //Numbers
    private lateinit var one:TextView
    private lateinit var two:TextView
    private lateinit var three:TextView
    private lateinit var four:TextView
    private lateinit var five:TextView
    private lateinit var six:TextView
    private lateinit var seven:TextView
    private lateinit var eight:TextView
    private lateinit var nine:TextView
    private lateinit var zero:TextView
    //Operators
    private lateinit var plus:TextView
    private lateinit var minus:TextView
    private lateinit var divide:TextView
    private lateinit var multiply:TextView
    private lateinit var modulo:TextView
    //others
    private lateinit var allClear:TextView
    private lateinit var sin:TextView
    private lateinit var cos:TextView
    private lateinit var tan:TextView
    private lateinit var open_brac:TextView
    private lateinit var close_brac:TextView
    private lateinit var equals:TextView
    private lateinit var backspace:ImageView
    private lateinit var expression:TextView
    private lateinit var result:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Numbers
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        //Operator
        plus = findViewById(R.id.plus)
        minus = findViewById(R.id.minus)
        divide = findViewById(R.id.division)
        multiply = findViewById(R.id.multiply)
        modulo = findViewById(R.id.modulo)
        //others
        allClear = findViewById(R.id.allClear)
        sin = findViewById(R.id.sin)
        cos = findViewById(R.id.cos)
        tan = findViewById(R.id.tan)
        open_brac = findViewById(R.id.brac_open)
        close_brac = findViewById(R.id.brac_close)
        equals = findViewById(R.id.equals)
        expression=findViewById(R.id.expression)
        result=findViewById(R.id.result)
        backspace=findViewById(R.id.backspace)

        one.setOnClickListener{ appendWord(one.text,true)}
        two.setOnClickListener{ appendWord(two.text,true)}
        three.setOnClickListener{ appendWord(three.text,true)}
        four.setOnClickListener{ appendWord(four.text,true)}
        five.setOnClickListener{ appendWord(five.text,true)}
        six.setOnClickListener{ appendWord(six.text,true)}
        seven.setOnClickListener{ appendWord(seven.text,true)}
        eight.setOnClickListener{ appendWord(eight.text,true)}
        nine.setOnClickListener{ appendWord(nine.text,true)}
        zero.setOnClickListener{ appendWord(zero.text,true)}
        //operators
        plus.setOnClickListener{ appendWord(plus.text,false)}
        minus.setOnClickListener{ appendWord(minus.text,false)}
        divide.setOnClickListener{ appendWord(divide.text,false)}
        multiply.setOnClickListener{ appendWord(multiply.text,false)}
        modulo.setOnClickListener{ appendWord(modulo.text,false)}
        open_brac.setOnClickListener{ appendWord(open_brac.text,false)}
        close_brac.setOnClickListener{ appendWord(close_brac.text,false)}
        sin.setOnClickListener{appendWord(sin.text,false)}
        cos.setOnClickListener{appendWord(cos.text,false)}
        tan.setOnClickListener{appendWord(tan.text,false)}

        backspace.setOnClickListener{
            try {
                if (expression?.text != "") {
                    expression?.text = expression?.text.substring(0, expression?.text.length - 1)
                    result?.hint = expression?.text
                }
                else{
                    expression?.text=""
                }
            }
            catch(e:Exception)
            {

            }
        }

        equals.setOnClickListener{
        try {
            var value = ExpressionBuilder((expression?.text).toString()).build()
            var answer = value.evaluate()
            result?.text=(answer).toString()
            result.hint=result.text
            expression?.text=""
        }catch (e: Exception)
        {
            result?.text=e.message
            result.hint=""
            expression.text=""
        }
        }
        allClear.setOnClickListener{
            result?.text=""
            expression?.text=""
            result?.hint=""
        }
    }

    private fun appendWord(text: CharSequence?, b: Boolean) {
        if(result?.text.isEmpty()) {
            expression?.append(text)
        }
        else
        {
            if(b)
            {
                //expression?.text=""
                //result?.hint=""

                result?.text=""
                expression?.append(text)
                //expression?.text=""
            }
            else
            {
                expression?.text=result?.text
                result?.text=""
                expression?.append(text)
            }
        }
        result?.hint=expression?.text
    }
}