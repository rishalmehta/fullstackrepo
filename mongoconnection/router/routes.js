const express=require("express")
var mongoose=require("mongoose")
var schema=mongoose.schema
var router=express.Router()

//defining model
var empschema=new schema({
    empid:String,
    ename:{type:String,trim:true,required:true},
    sal:string
})

var Emp=mongoose.model('emptab',empschema,'emptab')

router.get("/",(req,resp)=>{
    Emp.find().exec((err,data)=>{
        if(err){
           // console.log("cannot fetch data from mongo collection")
            resp.status(500).send("cannot fetch data from mongo collection")
        }
        else{
            resp.send(data)
        }
    })

});

router.get("/employee/:empid",(req,resp)=>{
    Emp.find({empid:req.params.id}).exec((err,data)=>{
        if(err){
            console.log("cannot retrive data")
            
        }
        else{
            resp.send(data)
        }
    })
});


router.post("/employee",(req,resp)=>{
    var empobj=new Emp({empid:req.params.id,ename:req.params.ename,sal:req.params.sal})
    empobj.save((err,data)=>{
        if(err){
            resp.status(500).send("error cannot post")
        }
        else{
            resp.send(data)
        }
    })
});


module.exports=router;