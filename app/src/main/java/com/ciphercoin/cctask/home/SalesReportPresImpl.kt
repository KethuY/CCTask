package com.ciphercoin.ciphercoin.home

import android.util.Log
import com.ciphercoin.cctask.home.SalesReportPresenter
import com.ciphercoin.cctask.home.models.SalesReport
import com.ciphercoin.cctask.restapi.ApiClient


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by satya on 25-Nov-17.
 */

class SalesReportPresImpl( var mSalesReportView: SalesReportView?) : SalesReportPresenter {

    init {
        mSalesReportView?.showProgressDialog()
    }

    override fun getSalesReport(key: String?, token: String?) {
        val enq = ApiClient.getRetrofitService().getSalesReport(key, token)
        enq.enqueue(object : Callback<SalesReport> {
            override fun onResponse(call: Call<SalesReport>, response: Response<SalesReport>) {
                Log.e("TAG", "response" + response.code())
                Log.e("TAG", "response" + response.body())
                val salesReport = response.body()
                mSalesReportView?.setDataToViews(salesReport)
                mSalesReportView?.dismissProgressDialog()
            }

            override fun onFailure(call: Call<SalesReport>, t: Throwable) {
                mSalesReportView?.dismissProgressDialog()
                Log.e("TAG", "response" + t.message)

            }
        })

    }
}
