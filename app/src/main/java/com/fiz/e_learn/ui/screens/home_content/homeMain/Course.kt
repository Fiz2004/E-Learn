package com.fiz.e_learn.ui.screens.home_content.homeMain

data class Course(
    val name: String="",
    val category: String="",
    val author:String="",
    val includes:List<String> =listOf(),
    val willLearn:List<String> =listOf(),
    val description:String="",
    val img: Int=0,
    val video:Int=0,
    val rating: Double=0.0,
    val countVoted:Int=0,
    val cost:Double=0.0,
    val bestSeller: Boolean=false
)