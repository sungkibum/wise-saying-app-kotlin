package com.ll.com.ll.wiseSaying.wiseSaying

data class WiseSaying(
    var id: Int,
    var wise: String,
    var author: String
    ){
    constructor(wise: String, author: String) : this(0, wise, author)
}
