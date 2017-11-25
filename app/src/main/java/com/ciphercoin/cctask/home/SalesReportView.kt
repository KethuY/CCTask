package com.ciphercoin.ciphercoin.home

import com.ciphercoin.cctask.home.models.SalesReport


/**
 * Created by satya on 25-Nov-17.
 */
interface SalesReportView {
    fun showProgressDialog();
    fun dismissProgressDialog();
    fun setDataToViews(salesReport: SalesReport?);
}