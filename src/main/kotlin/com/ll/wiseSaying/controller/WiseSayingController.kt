package com.ll.com.ll.wiseSaying.controller

import com.ll.com.ll.Rq
import com.ll.com.ll.wiseSaying.service.WiseSayingService

class WiseSayingController {

    val wiseSayingService = WiseSayingService()


    fun actionWrite(rq: Rq) {
        print("명언 : ")
        val wise = readlnOrNull()!!.trim()
        print("작가 : ")
        val author = readlnOrNull()!!.trim()
        val wiseSaying = wiseSayingService.write(wise, author)

        println("${wiseSaying.id}번 명언이 등록되었습니다.")

    }

    fun actionList(rq: Rq) {
        if (wiseSayingService.isEmpty()) {
            println("등록된 명언이 없습니다.")
            return
        }
        println("번호 / 작가 / 명언")
        println("------------------")
        val wiseSayingList = wiseSayingService.findAll()
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

        val wiseSaying = wiseSayingService.findById(id)
        if (wiseSaying == null) {
            println("${id}번 명언은 존재하지 않습니다.")
            return
        }

        wiseSayingService.delete(wiseSaying)

        println("${id}번 명언을 삭제하였습니다.")
    }

    fun actionModify(rq: Rq) {
        val id = rq.getParamValueAsInt("id", 0)
        if (id == 0) {
            println("id를 입력해주세요.")
            return
        }

        val wiseSaying = wiseSayingService.findById(id)

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

        wiseSayingService.modify(wiseSaying, updatedAuthor, updatedWise)


        println("${id}번 명언을 수정하였습니다.")
    }
}