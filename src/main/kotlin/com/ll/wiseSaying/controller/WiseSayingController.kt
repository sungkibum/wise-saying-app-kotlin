package com.ll.com.ll.wiseSaying.controller

import com.ll.com.ll.Rq
import com.ll.com.ll.wiseSaying.wiseSaying.WiseSaying

class WiseSayingController {
    val wiseSayingList = mutableListOf<WiseSaying>()
    var lastId = 0;

    fun actionWrite(rq: Rq) {
        print("명언 : ")
        val wise = readlnOrNull()!!.trim()
        print("작가 : ")
        val author = readlnOrNull()!!.trim()
        val wiseSaying = WiseSaying(++lastId, wise, author)
        println("${lastId}번 명언이 등록되었습니다.")
        wiseSayingList.add(wiseSaying)
    }

    fun actionList(rq: Rq) {
        if (wiseSayingList.isEmpty()) {
            println("등록된 명언이 없습니다.")
            return
        }
        println("번호 / 작가 / 명언")
        println("------------------")
        for (wiseSaying in wiseSayingList.sortedByDescending { it.id }) {
            println("${wiseSaying.id} / ${wiseSaying.author} / ${wiseSaying.wise}")
        }
    }

    fun actionDelete(rq: Rq) {
        val id = rq.getParamValueAsInt("id", 0)
        if (id == 0) {
            println("id를 입력해주세요.")
            return
        }

        println("입력된 id : $id")

        val removed = wiseSayingList.removeIf{ it.id == id }


        if (removed) {
            println("${id}번 명언을 삭제하였습니다.")
        } else {
            println("${id}번 명언은 존재하지 않습니다.")
        }
    }

    fun actionModify(rq: Rq) {
        val id = rq.getParamValueAsInt("id", 0)
        if (id == 0) {
            println("id를 입력해주세요.")
            return
        }

        println("입력된 id : $id")

        val wiseSaying = wiseSayingList.firstOrNull{it.id == id}

        if (wiseSaying == null) {
            println("${id}번 명언은 존재하지 않습니다.")
            return
        }

        println("명언(기존) : ${wiseSaying.wise}")
        print("명언 : ")
        val updatedWise = readlnOrNull()!!.trim()
        println("작가(기존) : ${wiseSaying.author}")
        print("작가 : ")
        val updatedAuthor = readlnOrNull()!!.trim()

        wiseSaying.wise = updatedWise
        wiseSaying.author = updatedAuthor

        println("${id}번 명언을 수정하였습니다.")
    }
}