package com.ciphercoin.cctask.home

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.ciphercoin.cctask.R
import com.ciphercoin.cctask.home.models.Earnings
import com.ciphercoin.cctask.home.models.LogRequest
import com.ciphercoin.cctask.home.models.Sales
import com.ciphercoin.cctask.home.models.SalesReport
import com.ciphercoin.ciphercoin.home.SalesReportPresImpl
import com.ciphercoin.ciphercoin.home.SalesReportView


class SalesReportActivity : AppCompatActivity(), SalesReportView {
    var mSalesReportPresenter: SalesReportPresenter? = null
    var mSalesReportView: SalesReportView? = null;
    var todaySalesTv: TextView? = null
    var todayEarnTv: TextView? = null
    var currentMonSalesTv: TextView? = null
    var currentMonEarnTv: TextView? = null
    var lastMonSalesTv: TextView? = null
    var lastMonEarnTv: TextView? = null
    var totalSalesTv: TextView? = null
    var totalEarnTv: TextView? = null
    var requestSpeed: TextView? = null
    var overrideTv: TextView? = null
    var userId: TextView? = null
    var logRequest: TextView? = null
    var progressDialog: ProgressDialog? = null
    var salesStatus: Sales? = null
    var earningStatus: Earnings? = null
    var logReq: LogRequest? = null
    val KEY = "f03e7b2b3c975656a4321869d925a25c"
    val TOKEN = "a30c1e85127469c364fb50443d9a459e"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_sales)
        initializeView();
        progressDialog = ProgressDialog(this)
        mSalesReportView = this
        mSalesReportPresenter = SalesReportPresImpl(mSalesReportView)
        mSalesReportPresenter?.getSalesReport(KEY, TOKEN)

    }

    private fun initializeView() {
        todaySalesTv = findViewById<TextView>(R.id.today_sales_tv)
        todayEarnTv = findViewById<TextView>(R.id.today_earn_tv)
        currentMonSalesTv = findViewById<TextView>(R.id.cm_sales_tv)
        currentMonEarnTv = findViewById<TextView>(R.id.cm_earn_tv)
        lastMonSalesTv = findViewById<TextView>(R.id.lm_sales_tv)
        lastMonEarnTv = findViewById<TextView>(R.id.lm_earn_tv)
        totalSalesTv = findViewById<TextView>(R.id.totals_sales_tv)
        totalEarnTv = findViewById<TextView>(R.id.totals_earn_tv)
        requestSpeed = findViewById<TextView>(R.id.req_speed);
        overrideTv = findViewById<TextView>(R.id.override_tv);
        userId = findViewById<TextView>(R.id.user_id);
        logRequest = findViewById<TextView>(R.id.log_req_tv);
    }

    override fun showProgressDialog() {
        progressDialog?.setMessage("Loading...\n Please wait")
        progressDialog?.setCancelable(false)
        progressDialog?.show();
    }

    override fun setDataToViews(salesReport: SalesReport?) {

        salesStatus = salesReport?.getStats()?.getSales();
        earningStatus = salesReport?.getStats()?.getEarnings();
        logReq = salesReport?.getLogRequest()

        //Basic Info
        overrideTv?.text = logReq?.override
        userId?.text = logReq?.user_id
        logRequest?.text = logReq?.log_requests
        requestSpeed?.text = salesReport?.getRequest_speed()

        //Sales
        todaySalesTv?.text = salesStatus?.today
        currentMonSalesTv?.text = salesStatus?.current_month
        lastMonSalesTv?.text = salesStatus?.last_month
        totalSalesTv?.text = salesStatus?.totals

        //Earnings
        todayEarnTv?.text = earningStatus?.today
        currentMonEarnTv?.text = earningStatus?.current_month
        lastMonEarnTv?.text = earningStatus?.last_month
        totalEarnTv?.text = earningStatus?.totals


    }

    override fun dismissProgressDialog() {
          progressDialog?.dismiss()
    }


}
