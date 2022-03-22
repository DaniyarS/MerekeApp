package dev.dslam.merekeapp.views

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.inputmethod.EditorInfo
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.setPadding
import androidx.core.widget.doAfterTextChanged
import dev.dslam.merekeapp.R
import dev.dslam.merekeapp.utils.setLeftDrawable
import dev.dslam.merekeapp.utils.setRightDrawable

class SearchEditText
@JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = androidx.appcompat.R.attr.editTextStyle
) : AppCompatEditText(context, attributeSet, defStyle) {

    init {
        setLeftDrawable(R.drawable.ic_search)
        setPadding(16)
        setHint(R.string.str_search)
        textSize = resources.getDimension(R.dimen.edittext_size)
        inputType = InputType.TYPE_CLASS_TEXT
        background = ResourcesCompat.getDrawable(resources, R.drawable.search_background, null)
        setTextChangeListener()
        setOnEditorActionListener()
        setDrawablesListener()
        imeOptions = EditorInfo.IME_ACTION_SEARCH
    }

    companion object {
        private const val DRAWABLE_LEFT_INDEX = 0
        private const val DRAWABLE_RIGHT_INDEX = 2
    }

    private var queryTextListener: QueryTextListener? = null

    private fun setTextChangeListener() {
        doAfterTextChanged {
            if (it.isNullOrBlank()) {
                setRightDrawable(0)
            } else {
                setRightDrawable(R.drawable.ic_close)
            }
            queryTextListener?.onQueryTextChange(it.toString())
        }
    }

    private fun setOnEditorActionListener() {
        setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                queryTextListener?.onQueryTextSubmit(text.toString())
                true
            } else {
                false
            }
        }
    }

    private fun setDrawablesListener() {
        setOnTouchListener(OnTouchListener { view, event ->
            view.performClick()
            if (event.action == MotionEvent.ACTION_UP) {
                when {
                    rightDrawableClicked(event) -> {
                        setText("")
                        return@OnTouchListener true
                    }
                    leftDrawableClicked(event) -> {
                        queryTextListener?.onQueryTextSubmit(text.toString())
                        return@OnTouchListener true
                    }
                    else -> {
                        return@OnTouchListener false
                    }
                }
            }
            false
        })
    }

    private fun rightDrawableClicked(event: MotionEvent): Boolean {

        val rightDrawable = compoundDrawables[DRAWABLE_RIGHT_INDEX]

        return if (rightDrawable == null) {
            false
        } else {
            val startOfDrawable = width - rightDrawable.bounds.width() - paddingRight
            val endOfDrawable = startOfDrawable + rightDrawable.bounds.width()
            startOfDrawable <= event.x && event.x <= endOfDrawable
        }

    }

    private fun leftDrawableClicked(event: MotionEvent): Boolean {

        val leftDrawable = compoundDrawables[DRAWABLE_LEFT_INDEX]

        return if (leftDrawable == null) {
            false
        } else {
            val startOfDrawable = paddingLeft
            val endOfDrawable = startOfDrawable + leftDrawable.bounds.width()
            startOfDrawable <= event.x && event.x <= endOfDrawable
        }

    }

    fun setQueryTextChangeListener(queryTextListener: QueryTextListener) {
        this.queryTextListener = queryTextListener
    }

    interface QueryTextListener {

        fun onQueryTextSubmit(query: String?)

        fun onQueryTextChange(newText: String?)

    }

}
