package com.perfomer.blitz

import android.view.View
import android.widget.TextView

/*
 * Designed and developed by 2020 Perfomer (Denis Balchugov)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

internal class BlitzAttachListener(
    private val target: TextView
) : View.OnAttachStateChangeListener {

    internal var time: Long = 0
        set(value) {
            if (field == value) return
            field = value
            updateRunnableSubscription()
        }

    internal var showSeconds: Boolean = true
        set(value) {
            if (field == value) return
            field = value
            updateRunnableSubscription()
        }

    private val runnable = object : Runnable {
        override fun run() {
            val diff = System.currentTimeMillis() - time
            val blitzTime = getBlitzTime(diff)

            target.diffedValue = blitzTime.getText(target.resources, diff, showSeconds)
            target.postDelayed(this, blitzTime.updateRateMs)
        }
    }

    override fun onViewDetachedFromWindow(v: View?) {
        target.removeCallbacks(runnable)
    }

    override fun onViewAttachedToWindow(v: View?) {
        updateRunnableSubscription()
    }

    fun dropCounter() {
        target.removeCallbacks(runnable)
    }

    private fun updateRunnableSubscription() {
        target.removeCallbacks(runnable)
        target.post(runnable)
    }

}