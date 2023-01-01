const http=require("http");
const fs=require("fs");
const url=require("url");
const m1=require("./public/moduletrial");

server=http.createServer(function(resp,req){
var q=url.parse(req.url,true);
console.log(q);

switch(q.pathname){
    case "/home":
        rs=fs.createReadStream("./public/hello.html")
        resp.writeHeader(200,{'content-type':'text/html'});
        rs.pipe(resp);
        break;

        case "/submit_data":
            resp.write("<h1>in submit data");
            resp.write("num1: "+q.query.num1+' num2: '+q.query.num2);
            var ans=m1.addition(q.query.num1,q.query.num2);
            resp.write("<h4>addition = "+ans+"</h4>")
            resp.end();
            break;
}
});
server.listen(4000);
console.log("srver is running at port 3000");