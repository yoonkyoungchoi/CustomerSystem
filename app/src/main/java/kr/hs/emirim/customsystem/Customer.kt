package kr.hs.emirim.customsystem

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Customer(var context: Context) : SQLiteOpenHelper(context, "customer", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        var tableCreSql = "create table customerTBL (name varchar(20), gender varchar(5), tel char(20), email varchar(30), level varchar(10), location varchar(20));"
        p0!!.execSQL(tableCreSql)

//        p0!!.execSQL("insert into CustomTBL values('최윤경',  '여자', '010-5257-2035',  '안산 와동')")
//        p0!!.execSQL("insert into CustomTBL values('조혜령',  '여자', '010-5257-2035',  '용인 기흥구')")
//        p0!!.execSQL("insert into CustomTBL values('이승민',  '여자', '010-5257-2035',  '강서구 가양')")
//        p0!!.execSQL("insert into CustomTBL values('조순형',  '여자', '010-5257-2035',  '전라도')")
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("drop table if exists customerTBL")
        onCreate(p0)
    }
}