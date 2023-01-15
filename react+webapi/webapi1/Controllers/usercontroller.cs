using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Cors;
namespace webapi1.Controllers;
using MYPRACTICE.webapi1.DAL;
using MYPRACTICE.webapi1.POCO;

[ApiController]
[Route("api/[controller]")]
public class  usercontroller: ControllerBase
{
    private readonly ILogger<usercontroller> _logger;

    //public List<user> usrlist=new List<user>();
    public usercontroller(ILogger<usercontroller> logger)
    {
        _logger = logger;
    }

    //getting data from database
    [HttpGet]
    [EnableCors()]
    public IEnumerable<user> Getallusers()
    {
        List<user>user=dataaccess.GetAllUser();
        return user;
    }

    //finding and giving user by id
    [Route("{id}")]
    [HttpGet]
    [EnableCors()]
    public ActionResult<user> GetUserById(int id){
        return dataaccess.GetUserById(id);
    }

    //add new user
    [HttpPost]
    [EnableCors()]
    public IActionResult AddNewUser(user newusr){
        dataaccess.AddNewUser(newusr);
        return Ok(new{message = "new user added"});
    }

    //delete user
    [HttpDelete]
    [EnableCors()]
    public IActionResult DeleteUser(int id){
        dataaccess.DeleteUser(id);
        return Ok(new {message = "user deleted"});
    }
}
