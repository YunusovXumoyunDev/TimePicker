package uz.yxdev.timepicker.presenter

import uz.yxdev.timepicker.data.repository.Repository
import uz.yxdev.timepicker.screen.UserScreen

class UserPresenter(
    private val view:UserScreen,
    private val repository: Repository
) {
}