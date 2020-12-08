package kr.hs.emirim.customsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        add_btn.setOnClickListener {
            var name = add_name.text.toString()
            var gender = ""
            if(add_man.isChecked) {
                gender="남"
            } else {
                gender="여"
            }

            val items = arrayOf("일반등급","A등급","S등급","VIP")
            val myAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)

            level.adapter = myAdapter
            level.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, Id: Long) {
                    var level1 = items[position]
                }
            }

            var tel = add_tel.text.toString();
            var email = add_email.text.toString();
            var location = add_location.text.toString()
            var customer : Customer = Customer(this)
            var sqlDB = customer.writableDatabase
            var insertSql = "insert into customerTBL values ('" + name + "', '" + gender + "', '" + tel + "', '" + email + "', '" + level + "', '" + location + "')"
            sqlDB.execSQL(insertSql)
            Toast.makeText(applicationContext, "insert ok " + name, Toast.LENGTH_SHORT).show()
            sqlDB.close()
        }
    }
}