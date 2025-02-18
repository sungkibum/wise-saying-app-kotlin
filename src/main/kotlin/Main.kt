package com.ll


fun main() {
    println("== 명언 앱 ==")

    while (true) {
        print("명령) ")
        val cmd = readlnOrNull()!!.trim()    //cmd에 null 일 리가 없기 때문에 !! 삽입    null일 수 있다면 ? 사용
        if (cmd == "종료") {
            break
        }

    }
}