package uz.yxdev.timepicker.screen

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.core.view.isVisible
import androidx.fragment.app.commit
import uz.yxdev.timepicker.R
import uz.yxdev.timepicker.data.repository.Repository
import uz.yxdev.timepicker.databinding.ScreenRegisterBinding
import uz.yxdev.timepicker.presenter.RegisterPresenter
import java.util.Calendar

class RegisterScreen : Fragment(R.layout.screen_register), DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {
    private var _binding: ScreenRegisterBinding? = null
    private val binding: ScreenRegisterBinding get() = _binding!!
    private lateinit var repository: Repository
    private lateinit var presenter: RegisterPresenter

    private var day = 0
    private var month = 0
    private var year = 0
    private var hour = 0
    private var min = 0

    private var savedDay = 0
    private var savedMonth = 0
    private var savedYear = 0
    private var savedHour = 0
    private var savedMin = 0
    private var date: String? = null
    private var time: String? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = ScreenRegisterBinding.bind(view)
        repository = Repository(requireContext())
        presenter = RegisterPresenter(this, repository)
        loadUiClickable()
    }

    fun sendBtnClick() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment,
                UserScreen(),
                "User Screen"
            )
            addToBackStack(null)
        }
    }

    fun dateClick() {
        getDateTimeCalendar()
        binding.calendar.isVisible=true
        DatePickerDialog(requireContext(), this, year, month, day).show()
    }

    fun timeClick() {
        getDateTimeCalendar()
        binding.time.isVisible=true
        TimePickerDialog(requireContext(), this, hour, min, true).show()
    }
    fun getName(): String = binding.nameEt.text.toString()
    fun getDate():String=date.toString()
    fun getTime():String=time.toString()
    private fun loadUiClickable(){
        binding.sendBtn.setOnClickListener {
            presenter.create()
        }
        binding.timeEt.setOnClickListener {
            timeClick()
        }
        binding.dateEt.setOnClickListener {
            dateClick()
        }
    }
    private fun getDateTimeCalendar() {
        val cal: Calendar = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        min = cal.get(Calendar.MINUTE)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year
        this.date = "$savedDay/$savedMonth/$savedYear"
        binding.dateEt.text="$savedDay/$savedMonth/$savedYear"
        binding.calendar.isVisible=false
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour = hourOfDay
        savedMin = minute
        this.time = "$savedHour:$savedMin"
        binding.timeEt.text="$savedHour:$savedMin"
        binding.time.isVisible=false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}