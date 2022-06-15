package com.fiz.e_learn.domain.models

import com.fiz.e_learn.R

data class Course(
    val id: Int = 0,
    val name: String = "",
    val category: String = "",
    val author: String = "",
    val structure: List<StructureItem> = listOf(),
    val includes: List<String> = listOf(),
    val willLearn: List<String> = listOf(),
    val annotation: String = "",
    val description: String = "",
    val countLectures: Int = 0,
    val length: Double = 0.0,
//    val lastUpdate: LocalDate =LocalDate.now(),
    val pictureResourceMap: Int = 0,
    val video: Int = 0,
    val rating: Double = 0.0,
    val countVoted: Int = 0,
    val allVoted: Int = 0,
    val cost: Double = 0.0,
    val bestSeller: Boolean = false
)

data class StructureItem(val nameEpisode:String, val description:String="")

val coursesStore = listOf(
    Course(
        id = 0,
        name = "Generator on there Internet tend",
        author = "Stephen Moris",
        cost = 14.50,
        pictureResourceMap = R.drawable.card4,
        rating = 4.5,
        bestSeller = false
    ),
    Course(
        id = 1,
        name = "Coding with Python Interface",
        author = "Stephen Moris",
        annotation = "A long established fact that a reader will beens distract by the readable content of a page when looking attes its layout. A long established fact that a reader will beens distract by the readable content of a page when looking attes its layout... read more",
        description = "There are many variations of passages Ipsum’s available, but the majority will have suffered were going to use a passage. All the Lorem Ipsum generators on the Internets tend to repeat predefined chunks.",
        cost = 14.50,
        countVoted = 122,
        allVoted = 25190,
        pictureResourceMap = R.drawable.card3,
//        lastUpdate=LocalDate.of(2021,6,2),
        includes = listOf(
            "10.5 hrs on demand video",
            "15 Question Patterns",
            "Support Files",
            "Access on all Devices",
            "Certificate of Completions"
        ),
        countLectures = 179,
        length = 20.4,
        structure = listOf(
            StructureItem("Introduction to 3D Animations & tools"),
            StructureItem("Basics of 3D Animation Theory", "All the Lorem Ipsum generators on the tools repeat predefined chunks."),
            StructureItem("What are Tools use in Design"),
            StructureItem("The Selection Tools"),
            StructureItem("Objective of the 3D Animations"),
            StructureItem("The Conclusion"),
        ),
        willLearn = listOf(
            "There are many variations of passages of Ipsum available, but the majority will have suffered alteration.",
            "What is some form by injected, orients slightly believable if you are going to use a passage.",
            "A handful of model sentence what are which looks reasonable.",
        ),
        rating = 2.5,
        bestSeller = true
    ),
    Course(
        id = 2,
        name = "Basic Intro with the\n" +
                "Development",
        pictureResourceMap = R.drawable.card4,
        author = "Stephen Moris",
        cost = 14.50,
        rating = 3.5,
        bestSeller = false
    ),
    Course(
        id = 3,
        name = "Generator on there Internet tend",
        author = "Stephen Moris",
        cost = 14.50,
        pictureResourceMap = R.drawable.card5,
        rating = 1.5,
        bestSeller = true
    ),
    Course(
        id = 4,
        name = "Generator on there Internet tend",
        author = "Stephen Moris",
        cost = 14.50,
        pictureResourceMap = R.drawable.card3,
        rating = 2.0,
        bestSeller = true
    ),
    Course(
        id = 5,
        name = "Generator on there Internet tend",
        author = "Stephen Moris",
        cost = 14.50,
        pictureResourceMap = R.drawable.card2,
        rating = 1.5,
        bestSeller = true
    ),
    Course(
        id = 6,
        name = "Generator on there Internet tend",
        author = "Stephen Moris",
        cost = 14.50,
        pictureResourceMap = R.drawable.card1,
        rating = 5.0,
        bestSeller = false
    ),
)