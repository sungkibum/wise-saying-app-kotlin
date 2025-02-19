package com.ll.com.ll.wiseSaying.repository

import com.ll.com.ll.wiseSaying.wiseSaying.WiseSaying

class WiseSayingRepository {

    val wiseSayingList = mutableListOf<WiseSaying>()
    var lastId = 0;

    fun save(wiseSaying: WiseSaying): WiseSaying {
        wiseSaying.id = ++lastId
        wiseSayingList.add(wiseSaying)
        return wiseSaying
    }

    fun isEmpty(): Boolean {
        return wiseSayingList.isEmpty()
    }

    fun findAll(): List<WiseSaying> {
        return wiseSayingList
    }

    fun findById(id: Int): WiseSaying? {
        return wiseSayingList.find { it.id == id }
    }

    fun delete(wiseSaying: WiseSaying) {
        wiseSayingList.remove(wiseSaying)
    }

    fun modify(wiseSaying: WiseSaying, updatedWise: String, updatedAuthor: String) {
        wiseSaying.wise = updatedWise
        wiseSaying.author = updatedAuthor
    }


}