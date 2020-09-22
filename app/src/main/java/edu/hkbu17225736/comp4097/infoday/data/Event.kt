//package edu.hkbu17225736.comp4097.infoday.data
//
//data class Event (
//    val id: Int,
//    val title: String,
//    val deptId: String,
//    var bookmarked:Boolean = false //This value may change in run-time
//) {}

package edu.hkbu17225736.comp4097.infoday.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Event (
    @PrimaryKey
    val id: Int,
    val title: String,
    val deptId: String,
    var bookmarked:Boolean = false
) { } //the curly braces can be omitted.