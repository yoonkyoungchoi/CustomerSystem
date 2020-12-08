package kr.hs.emirim.customsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    var list_spinner = arrayOf("일반등급", "S등급", "A등급", "VIP등급")
    
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
            var vip = ""
            if(add_normal.isChecked){
                vip="일반등급"
            }else if (add_S.isChecked){
                vip="S등급"
            }else if (add_A.isChecked){
                vip="A등급"
            }else if (add_VIP.isChecked){
                vip="VIP등급"
            }
            var tel = add_tel.text.toString();
            var email = add_email.text.toString();
            var location = add_location.text.toString()
            var customer : Customer = Customer(this)
            var sqlDB = customer.writableDatabase
            var insertSql = "insert into customerTBL values ('" + name + "', '" + gender + "', '" + tel + "', '" + email + "', '" + vip + "', '" + location + "')"
            sqlDB.execSQL(insertSql)
            Toast.makeText(applicationContext, "insert ok " + name, Toast.LENGTH_SHORT).show()
            sqlDB.close()
        }
    }
}