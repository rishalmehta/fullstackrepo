const http=require("http");
server=http.createServer(function(req,resp){
    console.log("url = "+req.url)
    resp.writeHeader(200,{'content-type':'text/html'});
    switch(req.url){
        case "/home":
            resp.write("<h2>welcome to home page</h2>");
            resp.end();
            break;
            case"/aboutus":
            resp.write("<h2>aboutus page</h2>");
            resp.end();
            break;
            default:
                resp.write("<h2>default case</h2>");
                resp.end();    
                break;
    }
});

server.listen(3000);
console.log("server is running at port at 3000");