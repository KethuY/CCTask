package com.ciphercoin.cctask.splashnew

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.ciphercoin.cctask.R
import com.ciphercoin.cctask.home.SalesReportActivity
import com.ciphercoin.ciphercoin.splash.SplashPresenter
import com.ciphercoin.ciphercoin.splash.SplashPresenterImpl
import com.ciphercoin.ciphercoin.splash.SplashView

class SplashActivity : AppCompatActivity(), SplashView {

    var mSplashView: SplashView? = null;
    var mSplashPresenter: SplashPresenter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setUp()
    }

    private fun setUp() {
        mSplashView = this
        mSplashPresenter = SplashPresenterImpl(mSplashView)
        mSplashPresenter?.fadeTheLogo();
        mSplashPresenter?.sleepForTwoSeconds();
    }

    override fun fadeTheLogo() {
        val image = findViewById<ImageView>(R.id.imageview)
        val animation = AnimationUtils.loadAnimation(applicationContext, R.anim.fade)
        image.startAnimation(animation)
    }

    override fun navigateToHomePage() {
        val intent = Intent(this, SalesReportActivity::class.java)
        startActivity(intent)
        finish()
    }
}
