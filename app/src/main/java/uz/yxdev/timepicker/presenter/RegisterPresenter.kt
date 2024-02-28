package uz.yxdev.timepicker.presenter

import uz.yxdev.timepicker.data.repository.Repository
import uz.yxdev.timepicker.screen.RegisterScreen

class RegisterPresenter(
    private val view: RegisterScreen,
    private val repository: Repository
) {
    fun create() {
        val name = view.getName()
        val date = view.getDate()
        val time = view.getTime()
        repository.create(
            name = name,
            date = date,
            time = time,
        )
        view.sendBtnClick()
    }
}