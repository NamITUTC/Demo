package com.example.nam.demobasekotlin.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by nam on 14/12/2017.
 */
class Item{
    @SerializedName("owner")
    @Expose
     val owner: Owner? = null
    @SerializedName("is_accepted")
    @Expose
     val isAccepted: Boolean? = null
    @SerializedName("score")
    @Expose
     val score: Int? = null
    @SerializedName("last_activity_date")
    @Expose
     val lastActivityDate: Int? = null
    @SerializedName("last_edit_date")
    @Expose
     val lastEditDate: Int? = null
    @SerializedName("creation_date")
    @Expose
     val creationDate: Int? = null
    @SerializedName("answer_id")
    @Expose
     val answerId: Int? = null
    @SerializedName("question_id")
    @Expose
     val questionId: Int? = null
}