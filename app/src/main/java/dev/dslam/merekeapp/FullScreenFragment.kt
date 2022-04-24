package dev.dslam.merekeapp

import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

abstract class FullScreenFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onStart() {
        super.onStart()
        dialog?.let {
            with(it.window!!) {
                setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            }
        }
    }
}
