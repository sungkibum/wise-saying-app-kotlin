package com.ll

import com.ll.com.ll.Rq
import com.ll.com.ll.WiseSaying

class App {
        fun run() {
            println("== 명언 앱 ==")
            val wiseSayingList = mutableListOf<WiseSaying>()
            var lastId = 0;
            while (true) {
                print("명령) ")

                val cmd = readlnOrNull()!!.trim()    //cmd에 null 일 리가 없기 때문에 !! 삽입    null일 수 있다면 ? 사용

                val rq = Rq(cmd)

                if (rq.action == "종료") {
                    break
                } else if (rq.action == "등록") {
                    print("명언 : ")
                    val wise = readlnOrNull()!!.trim()
                    print("작가 : ")
                    val author = readlnOrNull()!!.trim()
                    val wiseSaying = WiseSaying(++lastId, wise, author)
                    println("${lastId}번 명언이 등록되었습니다.")
                    wiseSayingList.add(wiseSaying)
                } else if (rq.action == "목록") {
                    if (wiseSayingList.isEmpty()) {
                        println("등록된 명언이 없습니다.")
                        continue
                    }
                    println("번호 / 작가 / 명언")
                    println("------------------")
                    for (wiseSaying in wiseSayingList.sortedByDescending { it.id }) {
                        println("${wiseSaying.id} / ${wiseSaying.author} / ${wiseSaying.wise}")
                    }
                } else if (rq.action == "삭제") {
                    val id = rq.getParamValueAsInt("id", 0)
                    if (id == 0) {
                        println("id를 입력해주세요.")
                        continue
                    }

                    println("입력된 id : $id")

                    val removed = wiseSayingList.removeIf{ it.id == id }


                    if (removed) {
                        println("${id}번 명언을 삭제하였습니다.")
                    } else {
                        println("${id}번 명언은 존재하지 않습니다.")
                    }
                }
            }
        }
}


