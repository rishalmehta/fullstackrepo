var emp=[
    {id:1,name:"aayush",desg:"developer"},
    {id:2,name:"ram",desg:"UI/UX"},
    {id:3,name:"shravan",desg:"developer"}
]

exports.insertEmp=function(ob){
  emp.push(ob);
}

exports.getlength=function(){
    return emp.length;
}

exports.searchEmp=function(id){
    for(var empob of emp){
        if(empob.id===parseInt(id)){
            return empob;
        }
    }
    return null;
}