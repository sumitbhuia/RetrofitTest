package com.example.retrofittest

import com.google.gson.annotations.SerializedName


// 1 - Data class / POJO
data class AlbumItem(

    /*

      Serialization: When you convert an object containing this variable to a different format (e.g., JSON),
      the library looks for the @SerializedName annotation and uses its value instead of the variable's actual name.

      Here , the name of the serialized name is same as that used in the JSON "key" ,
       when the JSON key is matched to serialized name , the data is parsed to the val userId , etc

    */
    @SerializedName("userId")
    val userId : Int ,

    @SerializedName("id")
    val id : Int ,

    @SerializedName("title")
    val title : String
)
