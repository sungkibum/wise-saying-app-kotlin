package com.ll.com.ll.wiseSaying.service

import com.ll.com.ll.wiseSaying.repository.WiseSayingRepository
import com.ll.com.ll.wiseSaying.wiseSaying.WiseSaying

class WiseSayingService {


    private val wiseSayingRepository = WiseSayingRepository()

    fun write(wise: String, author: String): WiseSaying {
       return wiseSayingRepository.save(WiseSaying(wise, author))
    }

    fun isEmpty(): Boolean {
        return wiseSayingRepository.isEmpty()
    }

    fun findAll() : List<WiseSaying>{
        return wiseSayingRepository.findAll()
    }

    fun findById(id: Int): WiseSaying? {
        return wiseSayingRepository.findById(id)
    }

    fun delete(wiseSaying: WiseSaying) {
        wiseSayingRepository.delete(wiseSaying)
    }

    fun modify(wiseSaying: WiseSaying, updatedWise: String, updatedAuthor: String,) {
        wiseSayingRepository.modify(wiseSaying, updatedWise, updatedAuthor)
    }


}