package com.example.imeianimations

import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsAnimation
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_imei.*

class ImeiAnimationFragment : Fragment(R.layout.fragment_imei) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = view.windowInsetsController

        openKeyBoardButton.setOnClickListener {
            controller?.show(WindowInsets.Type.ime())
        }

        closeKeyBoardButton.setOnClickListener {
            controller?.hide(WindowInsets.Type.ime())
        }

        val deferringInsetsListener = RootViewDeferringInsetsCallback(
            persistentInsetTypes = WindowInsets.Type.systemBars(),
            deferredInsetTypes = WindowInsets.Type.ime()
        )

        parentLayout.setWindowInsetsAnimationCallback(deferringInsetsListener)
        parentLayout.setOnApplyWindowInsetsListener(deferringInsetsListener)

        randomEditText.setWindowInsetsAnimationCallback(
            TranslateDeferringInsetsAnimationCallback(
                view = randomEditText,
                persistentInsetTypes = WindowInsets.Type.systemBars(),
                deferredInsetTypes = WindowInsets.Type.ime(),
                // We explicitly allow dispatch to continue down to binding.messageHolder's
                // child views, so that step 2.5 below receives the call
                dispatchMode = WindowInsetsAnimation.Callback.DISPATCH_MODE_CONTINUE_ON_SUBTREE
            )
        )

        randomRv.setWindowInsetsAnimationCallback(
            TranslateDeferringInsetsAnimationCallback(
                view = randomRv,
                persistentInsetTypes = WindowInsets.Type.systemBars(),
                deferredInsetTypes = WindowInsets.Type.ime()
            )
        )

//        randomEditText.setWindowInsetsAnimationCallback(
//            ControlFocusInsetsAnimationCallback(randomEditText)
//        )
    }
}