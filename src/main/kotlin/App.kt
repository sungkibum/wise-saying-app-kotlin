package com.ll

import com.ll.com.ll.WiseSaying

class App {
        fun run() {
            println("== 명언 앱 ==")
            val wiseSayingList = mutableListOf<WiseSaying>()
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
                    val wiseSaying = WiseSaying(num, wise, author)
                    println("${num}번 명언이 등록되었습니다.")
                    wiseSayingList.add(wiseSaying)
                    num++
                } else if (cmd == "목록") {
                    if (wiseSayingList.isEmpty()) {
                        println("등록된 명언이 없습니다.")
                        continue
                    }
                    println("번호 / 작가 / 명언")
                    println("------------------")
                    for (wiseSaying in wiseSayingList.sortedByDescending { it.id }) {
                        println("${wiseSaying.id} / ${wiseSaying.author} / ${wiseSaying.wise}")
                    }
                    }
                }
            }
        }


