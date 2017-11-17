package com.dp.logcatapp.util

import com.dp.logger.MyLogger

object PreferenceKeys {

    const val MAIN_PREF_SCREEN = "pref_key_main_screen"

    object Appearance {

        const val KEY_THEME = "pref_key_appearance_theme"
        const val KEY_USE_BLACK_THEME = "pref_key_appearance_use_black_theme"

        object Theme {

            const val AUTO = "0"
            const val LIGHT = "1"
            const val DARK = "2"
        }

        object Default {

            const val THEME = Theme.AUTO
            const val USE_BLACK_THEME = false
        }
    }

    object Logcat {
        const val KEY_POLL_INTERVAL = "pref_key_logcat_poll_interval"
        const val KEY_BUFFERS = "pref_key_logcat_buffers"

        object Default {
            const val POLL_INTERVAL = "250"
            val BUFFERS: Set<String> = getDefaultBufferValues()

            private fun getDefaultBufferValues(): Set<String> {
                val bufferValues = mutableSetOf<String>()
                for (buffer in com.dp.logcat.Logcat.DEFAULT_BUFFERS) {
                    val index = com.dp.logcat.Logcat.AVAILABLE_BUFFERS.indexOf(buffer)
                    if (index != -1) {
                        bufferValues += index.toString()
                    }
                }
                MyLogger.logDebug(PreferenceKeys::class,
                        "Default buffer values: $bufferValues")
                return bufferValues
            }
        }
    }

    object About {
        const val KEY_VERSION_NAME = "pref_key_version_name"
    }
}