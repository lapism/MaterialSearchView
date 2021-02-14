package com.lapism.search2.internal

import android.animation.ObjectAnimator
import android.content.Context
import android.util.Property
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.core.content.ContextCompat


@Suppress("unused")
class MenuArrowDrawable constructor(context: Context) : DrawerArrowDrawable(context) {

    // *********************************************************************************************
    var position: Float
        get() = progress
        set(position) {
            progress = position
        }

    // *********************************************************************************************
    init {
        color = ContextCompat.getColor(context, android.R.color.white)
        // TODO android:tint="?attr/colorControlNormal"
    }

    // *********************************************************************************************
    fun animate(state: Float, duration: Long) {
        val anim: ObjectAnimator = if (state == ARROW) {
            ObjectAnimator.ofFloat(
                this,
                PROGRESS,
                MENU,
                state
            )
        } else {
            ObjectAnimator.ofFloat(
                this,
                PROGRESS,
                ARROW,
                state
            )
        }
        anim.interpolator = AccelerateDecelerateInterpolator()
        anim.duration = duration
        anim.start()
    }

    // *********************************************************************************************
    companion object {

        const val MENU = 0.0f
        const val ARROW = 1.0f

        private val PROGRESS =
            object : Property<MenuArrowDrawable, Float>(Float::class.java, "progress") {
                override fun set(obj: MenuArrowDrawable, value: Float?) {
                    obj.progress = value!!
                }

                override fun get(obj: MenuArrowDrawable): Float {
                    return obj.progress
                }
            }
    }

}