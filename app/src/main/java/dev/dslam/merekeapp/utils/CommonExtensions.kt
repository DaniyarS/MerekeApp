package dev.dslam.merekeapp.utils

import android.app.DatePickerDialog
import android.content.Context
import android.content.res.Resources
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import java.util.*

private const val DRAWABLE_LEFT_INDEX = 0
private const val DRAWABLE_TOP_INDEX = 1
private const val DRAWABLE_RIGHT_INDEX = 2
private const val DRAWABLE_BOTTOM_INDEX = 3

fun TextView.setLeftDrawable(@DrawableRes drawableResId: Int) {

    val leftDrawable = if (drawableResId != 0) {
        ContextCompat.getDrawable(context, drawableResId)
    } else {
        null
    }
    val topDrawable = compoundDrawables[DRAWABLE_TOP_INDEX]
    val rightDrawable = compoundDrawables[DRAWABLE_RIGHT_INDEX]
    val bottomDrawable = compoundDrawables[DRAWABLE_BOTTOM_INDEX]

    setCompoundDrawablesWithIntrinsicBounds(
        leftDrawable,
        topDrawable,
        rightDrawable,
        bottomDrawable
    )
}

fun TextView.setRightDrawable(@DrawableRes drawableResId: Int) {

    val leftDrawable = compoundDrawables[DRAWABLE_LEFT_INDEX]
    val topDrawable = compoundDrawables[DRAWABLE_TOP_INDEX]
    val rightDrawable = if (drawableResId != 0) {
        ContextCompat.getDrawable(context, drawableResId)
    } else {
        null
    }
    val bottomDrawable = compoundDrawables[DRAWABLE_BOTTOM_INDEX]

    setCompoundDrawablesWithIntrinsicBounds(
        leftDrawable,
        topDrawable,
        rightDrawable,
        bottomDrawable
    )
}

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

@RequiresApi(Build.VERSION_CODES.N)
fun EditText.transformIntoDatePicker(context: Context, format: String, maxDate: Date? = null) {
    isFocusableInTouchMode = false
    isClickable = true
    isFocusable = false

    val myCalendar = Calendar.getInstance()
    val datePickerOnDataSetListener =
        DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, monthOfYear)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            val sdf = SimpleDateFormat(format, Locale.US)
            setText(sdf.format(myCalendar.time))
        }

    setOnClickListener {
        DatePickerDialog(
            context, datePickerOnDataSetListener, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)
        ).run {
            maxDate?.time?.also { datePicker.maxDate = it }
            show()
        }
    }
}
