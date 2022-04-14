package com.fiz.e_learn.ui.screens.home_content.home_main

import com.fiz.e_learn.R

data class Course(
    val id:Int=0,
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
    val allVoted:Int=0,
    val cost:Double=0.0,
    val bestSeller: Boolean=false
)


val listCategories = listOf(
    "Design",
    "Development",
    "Business",
    "Music",
    "It & Software",
    "Health@Fitness",
    "Business",
    "Design",
    "Development",
    "Business",
    "Music",
    "It & Software",
    "Health@Fitness",
    "Business",
)
val courses = listOf(
    Course(
        id=0,
        name = "Generator on there Internet tend",
        author = "Stephen Moris",
        cost = 14.50,
        img = R.drawable.card4,
        rating = 4.5,
        bestSeller = false
    ),
    Course(
        id=1,
        name = "Coding with Python Interface",
        author = "Stephen Moris",
        description="A long established fact that a reader will beens distract by the readable content of a page when looking attes its layout... read more A long established fact that a reader will beens distract by the readable content of a page when looking attes its layout... read more",
        cost = 14.50,
        countVoted=122,
        allVoted=25190,
        img = R.drawable.card3,
        rating = 2.5,
        bestSeller = true
    ),
    Course(
        id=2,
        name = "Basic Intro with the\n" +
                "Development",
        img = R.drawable.card4,
        author = "Stephen Moris",
        cost = 14.50,
        rating = 3.5,
        bestSeller = false
    ),
    Course(
        id=3,
        name = "Generator on there Internet tend",
        author = "Stephen Moris",
        cost = 14.50,
        img = R.drawable.card5,
        rating = 1.5,
        bestSeller = true
    ),
    Course(
        id=4,
        name = "Generator on there Internet tend",
        author = "Stephen Moris",
        cost = 14.50,
        img = R.drawable.card3,
        rating = 2.0,
        bestSeller = true
    ),
    Course(
        id=5,
        name = "Generator on there Internet tend",
        author = "Stephen Moris",
        cost = 14.50,
        img = R.drawable.card2,
        rating = 1.5,
        bestSeller = true
    ),
    Course(
        id=6,
        name = "Generator on there Internet tend",
        author = "Stephen Moris",
        cost = 14.50,
        img = R.drawable.card1,
        rating = 5.0,
        bestSeller = false
    ),
)