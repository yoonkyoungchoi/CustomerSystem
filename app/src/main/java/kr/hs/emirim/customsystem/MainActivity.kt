package kr.hs.emirim.customsystem

import android.app.DownloadManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        main_add.setOnClickListener {
            var intent = Intent(applicationContext, AddActivity::class.java)
            startActivity(intent)
        }

        main_list.setOnClickListener {
            var intent = Intent(applicationContext, ListActivity::class.java)
            startActivity(intent)
//        loadOpenData();
        }
    }

//    fun loadOpenData(){
//        var aq = DownloadManager.Query()
//        var params = HashMap<String, String>()
//        var url = "https://www.google.co.kr/"
//        aq.ajax(url, var result : JSON)
//        params.put("https://www.google.co.kr/")
//    }
}