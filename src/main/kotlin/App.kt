package com.ll

import com.ll.com.ll.Rq
import com.ll.com.ll.wiseSaying.controller.SystemController
import com.ll.com.ll.wiseSaying.controller.WiseSayingController

class App {
        fun run() {
            val wiseSayingController = WiseSayingController()
            val systemController = SystemController()
            println("== 명언 앱 ==")

            while (true) {
                print("명령) ")
                val cmd = readlnOrNull()!!.trim()    //cmd에 null 일 리가 없기 때문에 !! 삽입    null일 수 있다면 ? 사용
                val rq = Rq(cmd)

                when (rq.action) {
                    "종료" -> {
                        systemController.actionExit(rq)
                        break
                    }
                    "등록" -> wiseSayingController.actionWrite(rq)
                    "목록" -> wiseSayingController.actionList(rq)
                    "삭제" -> wiseSayingController.actionDelete(rq)
                    "수정" -> wiseSayingController.actionModify(rq)
                }
            }
        }
}


