package com.ll.com.ll.wiseSaying.service

import com.ll.com.ll.wiseSaying.wiseSaying.WiseSaying

class WiseSayingService {

    val wiseSayingList = mutableListOf<WiseSaying>()
    var lastId = 0;

    fun write(wise: String, author: String): WiseSaying {
        val wiseSaying = WiseSaying(++lastId, wise, author)
        wiseSayingList.add(wiseSaying)
        return wiseSaying
    }

    fun isEmpty(): Boolean {
        return wiseSayingList.isEmpty()
    }

    fun findAll() : List<WiseSaying>{
        return wiseSayingList
    }

    fun findById(id: Int): WiseSaying? {
        return wiseSayingList.find { it.id == id }
    }

    fun delete(wiseSaying: WiseSaying) {
        wiseSayingList.remove(wiseSaying)
    }

    fun modify(wiseSaying: WiseSaying, updatedAuthor: String, updatedWise: String) {
        wiseSaying.wise = updatedWise
        wiseSaying.author = updatedAuthor
    }


}