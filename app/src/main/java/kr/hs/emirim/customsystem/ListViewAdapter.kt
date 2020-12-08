package kr.hs.emirim.customsystem

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item.view.*

class ListViewAdapter(var customerList : ArrayList<CustomerC>) : BaseAdapter() {
    override fun getCount(): Int {
        return customerList.size
    }

    override fun getItem(p0: Int): Any {
        return customerList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        var rowItemView = view
        if (rowItemView == null) {
            rowItemView = View.inflate(parent?.context, R.layout.item, null)
        }
        val customer = customerList[position]
        rowItemView!!.list_name_gender.text = "이름 : " + customer.name + "/" + customer.gender
        rowItemView!!.list_tel.text = "연락처 : " + customer.tel
        rowItemView!!.list_email.text = "이메일 : " + customer.email
        rowItemView!!.list_location.text = "지역 : " + customer.location + "\n" + "등급 : " + customer.vip
        return rowItemView
    }

}