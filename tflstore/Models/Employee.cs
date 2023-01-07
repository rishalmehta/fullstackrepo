namespace Employeedata;

public class Employee{

    public int Empid{get;set;}
    public string Ename{get;set;}
    public double Esal{get;set;}
    public string Deptname{get;set;}

    public Employee(){
    }


    public Employee(int empid){
        this.Empid=empid;
    }

    public Employee(int empid,string ename,double esal,string deptname){
        this.Empid=empid;
        this.Ename=ename;
        this.Esal=esal;
        this.Deptname=deptname;
    }

    public override string ToString()
    {
        string str=string.Format("\n empid = "+Empid+"\n ename = "+Ename+"\n emp sal = "+Esal+"\n departname = "+Deptname);
        return str;
    }

}