package com.example.androidfundamental.mockito

class TwitterClient {
    fun sendTweet(tweet: ITweet) {
        val message = tweet.message
        // send the message to Twitter
    }
}