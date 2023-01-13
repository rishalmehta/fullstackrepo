const express=require("express")
var app=express()
var mongoose=require("mongoose")
var bodyparser=require("body-parser")
var path=require("path")
var router=require("./router/routes")

mongoose.promise=global.promise

const url='mongodb://0.0.0.0:27017/test'

mongoose.connect(url,{ConnectTimeOutMS:1000},function(err,result){
    if(err){
        console.log("cannot connect to mongodb!")
    }
    else{
        console.log("connected to mongodb")
    }
});

//use middlewares
app.use(bodyparser.json())
app.use(bodyparser.urlencoded({extended:false}))
app.use(express.static(path.join(__dirname,"public")))
app.use("/",router)
app.listen(3000)
console.log("app listening at port 3000")
module.exports=app;

