package com.example.formjc

object Utils {
    fun joinData(vararg fields: String): String {
        var result = ""

        fields.forEach { field ->
            if (field.isNotEmpty()) {
                result += "$field\n"
            }
        }

        return result
    }
}