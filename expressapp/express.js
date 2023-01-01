const express=require("express");
var app=express();
var bodyparser=require("body-parser");
const memparr=require("./moduleemparr");

app.use(bodyparser.urlencoded({extended:false}));

app.get("/",function(req,resp){
    resp.send("public/empform.html",{root:__dirname});
});

app.get("/empdata",function(req,resp){
    if(req.query.btn==="add"){
        var id=parseInt(req.query.id);
        var name=req.query.name;
        var desg=req.query.desg;
        var ob={id,name,desg};
        memparr.insertEmp(ob);
        console.log(memparr.getlength());
        resp.send("added successfully");
    }
    else{
        var id=req.query.id;
        var ob=memparr.searchEmp(id);
        if(ob!=null){
            resp.send(JSON.stringify(ob));
        }
        else{
            resp.send("employee not found");
        }
    }
})

app.listen(3000);
console.log("server is listening at port 3000");