package kr.hs.emirim.customsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list.*
import kr.hs.emirim.customsystem.CustomerC
import kr.hs.emirim.customsystem.ListViewAdapter
import kr.hs.emirim.customsystem.R

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        var customerList : ArrayList<CustomerC> = arrayListOf<CustomerC>()
        var customer : Customer = Customer(this)
        var sqlDB = customer.readableDatabase
        var cursor = sqlDB.rawQuery("select * from customerTBL", null)
        while (cursor.moveToNext()) {
            customerList.add(CustomerC(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)))
        }
        cursor.close()
        sqlDB.close()


        var adapter1 = ListViewAdapter(customerList)
        list.adapter = adapter1
        list.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(applicationContext, "선택 " + customerList.get(i).name, Toast.LENGTH_SHORT).show()
        }
    }
}