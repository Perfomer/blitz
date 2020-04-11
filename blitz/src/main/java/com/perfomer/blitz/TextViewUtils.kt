package com.perfomer.blitz

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

internal var TextView.diffedValue: String
    get() = text.toString()
    set(value) {
        if (text.toString() == value) return
        text = value
    }