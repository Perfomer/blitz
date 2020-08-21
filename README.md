# blitz
<img src="https://jitpack.io/v/Perfomer/blitz.svg"> [![GitHub license](https://img.shields.io/github/license/Perfomer/blitz)](https://github.com/Perfomer/blitz/blob/master/LICENSE)

**blitz** is a very lightweight Android library that allows you to set a **self-updating string with relative time** in `TextView` in **just one line of code**.

<img src="art/blitz_preview.gif" width="420">

**DOESN'T require** using custom `TextView`.

It will **not overheadly** update your `TextView`: e.g. if your relative time is `5 minutes ago` then **blitz** will send update only after one minute, not every second. The same with others time units: hours updates once an hour, etc.

Don't be scared to **use it in your `ViewHolder`s**, 'cause **blitz** won't let anything leak and will take care of the system resources.

### Briefly usage:
```kotlin
val myTextView: TextView = ...
val eventTime: Long = ...

// just one line of code and that is it!
myTextView.setTimeAgo(eventTime)
```

## Languages support:
- <img src="https://emojio.ru/images/apple-b/1f1fa-1f1f8.png" alt="🇺🇸" width="16"> English
- <img src="https://emojio.ru/images/apple-b/1f1f7-1f1fa.png" alt="🇷🇺" width="16"> Russian
- <img src="https://emojio.ru/images/apple-b/1f1ea-1f1f8.png" alt="🇪🇸" width="16"> Spanish (by [webserveis](https://github.com/webserveis))
- <img src="https://emojio.ru/images/apple-b/1f1eb-1f1f7.png" alt="🇫🇷" width="16"> French (by [fxbeuvry-luna](https://github.com/fxbeuvry-luna))
- <img src="https://emojio.ru/images/apple-b/1f1f3-1f1f1.png" alt="🇳🇱" width="16"> Dutch (by [Pygmalion69](https://github.com/Pygmalion69))
- <img src="https://emojio.ru/images/apple-b/1f1f9-1f1ed.png" alt="🇹🇭" width="16"> Thai (by [minibugdev](https://github.com/minibugdev))
- <img src="https://emojio.ru/images/apple-b/1f1ee-1f1f7.png" alt="🇮🇷" width="16"> Persian/Farsi (by [SinaDalvand](https://github.com/sinadalvand))
- <img src="https://emojio.ru/images/apple-m/1f1f2-1f1f0.png" alt="🇲🇰" width="16"> Macedonian (by [CraZyLegenD](https://github.com/CraZyLegenD))
- <img src="https://emojio.ru/images/apple-m/1f1ee-1f1e9.png" alt="🇮🇩" width="16"> Indonesian (by [utsmannn](https://github.com/utsmannn))
- <img src="https://emojio.ru/images/apple-m/1f1f9-1f1f7.png" alt="🇮🇩" width="16"> Turkish (by [necatisozer](https://github.com/necatisozer))



There's not your language? You can help the community by sending a **Pull Request**.

## Installation:
### Step 1
Add repository to your `gradle.build` file **(project)**
```gradle
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```
### Step 2
Add dependency to your `gradle.build` file __(app) or other module__
```gradle
dependencies {
   implementation 'com.github.perfomer:blitz:LATEST_VERSION'
}
```
See the latest release version here: <img src="https://jitpack.io/v/Perfomer/blitz.svg">.

## Usage:
### TextView
If you want to set the **self-updating string with relative time** direct into the `TextView` then use extesnsion method:
```kotlin
myTextView.setTimeAgo(eventTime)
```

You can also customize it a bit:
```kotlin
myTextView.setTimeAgo(
  // Can be Long or java.util.Date
  time = eventTime,
  
  // If [true]: Show the exact seconds count if time difference is less than minute 
  // Or if [false]: Show "just now" message in that case.
  showSeconds = true, 
  
  // Don't want auto-update? Just set it to false.
  autoUpdate = false 
)
```

If you don't want to get time updates more than use cancel method:
```kotlin
myTextView.cancelTimeAgoUpdates()
```

### String
If you just want to get a time-relative string, then you can use the following extension methods:
```kotlin
val contextString: String = context.getTimeAgo(time = eventTime, showSeconds = false)
val resourcesString: String = resources.getTimeAgo(time = eventTime, showSeconds = false)
```

## Communication:
- If you found a bug, please [open an Issue](https://github.com/Perfomer/blitz/issues).
- If you have a feature request, please [open an Issue](https://github.com/Perfomer/blitz/issues).
- If you want to contribute, please [submit a Pull request](https://github.com/Perfomer/blitz/pulls).

## License:
```
Apache 2.0 LICENSE

Copyright (c) 2020 Denis Balchugov.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
