package com.example.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response
import retrofit2.create

/*
        To use retrofit
        ----------------
        1 - Make a POJO / Data class -> representing the JSON object
        2 - Make a empty class that returns a Array -> representing JSON Array
        3 - Make a Service interface -> that holds all fn for network transaction
        4 - Make a retrofit instance -> using singleton pattern
        5 - In Main Activity
                - Building retrofit instance , providing it with , service interface
                - Making live response array -> putting in livedata -> which calls a network transaction function from retrofit service instance
                - Observing the live data


 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Finding textView
        val textView : TextView = findViewById(R.id.textView)

        //Instance of retrofit service -> implementing service interface
        val retrofitService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)

        val responseLiveData : LiveData<Response<Album>> = liveData {
           // val response = retrofitService.getSpecificAlbums()
            val response2 = retrofitService.getSpecificAlbums(6)
            emit(response2)

        }

/*
        - The observe method is used on a  LiveData object named responseLiveData.
        - "this" refers to the current activity or fragment where this code resides/MainActivity
        - The Observer interface defines a method that will be called whenever the value of responseLiveData changes.
        - The lambda expression { ... } defines the code to be executed when the Observer is triggered.


*/
        responseLiveData.observe(this, Observer {

/*
            - Inside the lambda, it refers to the latest value emitted by responseLiveData.
            - it.body() attempts to access the response body (assuming it's a network response).
            - If the response body is not null, it calls listIterator() to create an iterator over the albums list (assuming the body contains a list).
            - The albumsList variable stores this iterator.
*/
            val albumsList = it.body()?.listIterator()


            //This line checks if the albumsList iterator is not null (i.e., the response body was valid and contained a list).
            if (albumsList !=null){
                while (albumsList.hasNext()){
                    //Storing the iterator
                    val albumItem = albumsList.next()
                    //  Log.i("TAGY",albumItem.title)

                    //Storing the iterator title data in a var
                    val result = " Album Title: ${albumItem.title} \n"

                    //Attaching the result to textview to show on screen
                    textView.append(result)


                }
            }
        })

    }
}