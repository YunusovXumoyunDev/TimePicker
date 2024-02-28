package uz.yxdev.timepicker.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.yxdev.timepicker.R
import uz.yxdev.timepicker.data.repository.Repository
import uz.yxdev.timepicker.databinding.ScreenRegisterBinding
import uz.yxdev.timepicker.databinding.ScreenUserBinding
import uz.yxdev.timepicker.presenter.RegisterPresenter
import uz.yxdev.timepicker.presenter.UserPresenter


class UserScreen : Fragment(R.layout.screen_user) {
    private var _binding: ScreenUserBinding? = null
    private val binding: ScreenUserBinding get() = _binding!!
    private lateinit var repository: Repository
    private lateinit var presenter: UserPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = ScreenUserBinding.bind(view)
        repository = Repository(requireContext())
        presenter = UserPresenter(this, repository)
        loadUi()
    }
    private fun loadUi(){
        binding.name.text=repository.getName()
        binding.date.text=repository.getDate()
        binding.time.text=repository.getTime()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}