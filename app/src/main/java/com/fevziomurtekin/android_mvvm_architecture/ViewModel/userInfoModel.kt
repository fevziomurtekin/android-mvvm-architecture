package com.fevziomurtekin.android_mvvm_architecture.ViewModel

class userInfoModel{

    var imgUrl : String = ""
    var repos_count:Int=0
    var following_count:Int=0
    var followers_count:Int=0
    var username:String=""

    fun userInfoModel(imgUrl:String, repos_count:Int, following_count:Int
                      , followers_count:Int, username:String){

        this.imgUrl         = imgUrl
        this.repos_count    = repos_count
        this.following_count= following_count
        this.followers_count= followers_count
        this.username       = username
    }





}