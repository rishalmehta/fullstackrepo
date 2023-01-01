const http=require("http");
server=http.createServer(function(req,resp){
    resp.writeHeader(200,{'content-type':'text/html'});
    console.log("url = "+req.url)

    if(req.url==="/home" && req.method==="GET"){
        resp.write("<h2>you selected home</h2>")
        resp.write("<h3>welcome to our system service</h3>")
        resp.end();
    }
    else if(req.url==="/aboutus"){
        resp.write("<h2>you selected home</h2>")
        resp.write("<h3>welcome to our system service</h3>")
        resp.end();
    }

});

server.listen(3000);
console.log("server is running at port 3000");