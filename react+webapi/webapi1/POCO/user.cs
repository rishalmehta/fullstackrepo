namespace MYPRACTICE.webapi1.POCO;
using System.ComponentModel.DataAnnotations;

public class user{
    public int userid{get;set;}

    [Required]
    public string username{get;set;}

    [Required]
    public string course{get;set;}

    [Required]
    public string purchasedate{get;set;}
}