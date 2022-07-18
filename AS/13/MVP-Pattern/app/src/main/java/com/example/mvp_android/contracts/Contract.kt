package com.example.mvp_android.contracts

interface Contract {
    interface View {
        fun showProgress()

        fun hideProgress()

        fun setString(string: String?)
    }
    interface Model {
        interface OnFinishedListener {
            fun onFinished(string: String)
        }
        fun getNextComponentDescription(onFinishedListener: OnFinishedListener)
    }
    interface Presenter {
        fun onButtonClick()
        fun onDestroy()
    }
}