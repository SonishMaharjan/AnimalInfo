package com.zoo.so_ni.animalinfo

/**
 * Created by so_ni on 9/1/2018.
 */
class Animal {
    var name:String? = null
    var des:String? = null
    var img:Int? = null
    var isVegan:Boolean? = null


    constructor(name:String,des:String,img:Int,isVegan:Boolean)
    {
        this.name = name
        this.des= des
        this.img = img
        this.isVegan = isVegan
    }


}