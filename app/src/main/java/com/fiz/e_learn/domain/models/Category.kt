package com.fiz.e_learn.domain.models

import com.fiz.e_learn.R

data class Category(
    val name: String,
    val iconResourceMap: String
)

val categoriesStore: List<Category> = listOf(
    Category(name = "Designing", iconResourceMap = "ic_designing"),
    Category(name = "Development", iconResourceMap = "ic_development"),
    Category(name = "Business", iconResourceMap = "ic_business"),
    Category(name = "Finance & Accounting", iconResourceMap = "ic_finance_Accounting"),
    Category(name = "IT Sectors", iconResourceMap = "ic_it_Sectors"),
    Category(name = "Photography", iconResourceMap = "ic_photography"),
    Category(name = "Health & Fitness", iconResourceMap = "ic_health_fitness"),
    Category(name = "Music", iconResourceMap = "ic_music"),
)

val resourceMapCategories: Map<String, Int> = mapOf(
    "ic_designing" to R.drawable.favorites_ic_designing,
    "ic_development" to R.drawable.favorites_ic_development,
    "ic_business" to R.drawable.favorites_ic_business,
    "ic_finance_Accounting" to R.drawable.favorites_ic_finance_accounting,
    "ic_it_Sectors" to R.drawable.favorites_ic_it_sectors,
    "ic_photography" to R.drawable.favorites_ic_photography,
    "ic_health_fitness" to R.drawable.favorites_ic_health_fitness,
    "ic_music" to R.drawable.favorites_ic_music,
)