package com.example.everythingapp.util

val buttonTextToTypeMap = mapOf(
    "C" to ButtonTypes.CLEAR,
    "()" to ButtonTypes.BRACES,

    "%" to ButtonTypes.OPERATOR,
    "/" to ButtonTypes.OPERATOR,
    "*" to ButtonTypes.OPERATOR,
    "-" to ButtonTypes.OPERATOR,
    "+" to ButtonTypes.OPERATOR,

    "0" to ButtonTypes.OPERAND,
    "1" to ButtonTypes.OPERAND,
    "2" to ButtonTypes.OPERAND,
    "3" to ButtonTypes.OPERAND,
    "4" to ButtonTypes.OPERAND,
    "5" to ButtonTypes.OPERAND,
    "6" to ButtonTypes.OPERAND,
    "7" to ButtonTypes.OPERAND,
    "8" to ButtonTypes.OPERAND,
    "9" to ButtonTypes.OPERAND,
    "." to ButtonTypes.OPERAND,

    "=" to ButtonTypes.EVALUATE,
    "+/-" to ButtonTypes.INVERT
)