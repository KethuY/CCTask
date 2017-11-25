package com.ciphercoin.ciphercoin.splash

import android.os.Handler

/**
 * Created by satya on 25-Nov-17.
 */

class SplashPresenterImpl(var splashView: SplashView?) : SplashPresenter {

    override fun fadeTheLogo() {
        splashView?.fadeTheLogo()
    }

    override fun sleepForTwoSeconds() {

        Handler().postDelayed(
                {
                    splashView?.navigateToHomePage();

                }, SPLASH_TIME_OUT.toLong())
    }

    companion object {
        private val SPLASH_TIME_OUT = 2000
    }
}
