const http=require("http");
const fs=require("fs");
server=http.createServer(function(req,resp){
    rs=fs.createReadStream("./public/hello.html");
    rs.pipe(resp);
});

server.listen(6000);
console.log("server is listening at port no. 3000")