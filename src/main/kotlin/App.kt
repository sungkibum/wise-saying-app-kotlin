package com.ll

class App {
    companion object {
        fun run() {
            println("== 명언 앱 ==")
            var num = 1;
            while (true) {
                print("명령) ")
                val cmd = readlnOrNull()!!.trim()    //cmd에 null 일 리가 없기 때문에 !! 삽입    null일 수 있다면 ? 사용
                if (cmd == "종료") {
                    break
                } else if (cmd == "등록") {
                    print("명언 : ")
                    val wise = readlnOrNull()!!.trim()
                    print("작가 : ")
                    val author = readlnOrNull()!!.trim()
                    println("${num}번 명언이 등록되었습니다.")
                    num++
                }
            }
        }
    }

}