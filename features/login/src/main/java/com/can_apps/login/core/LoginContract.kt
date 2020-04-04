package com.can_apps.login.core

internal interface LoginContract {

    interface View {
        fun welcome()

        fun close()
    }

    interface Presenter {
        fun bind(view: View)

        fun unbind()

        fun onViewCreated()

        fun onBackPressed()
    }

    interface Interactor {}
    interface Repository {}
}