import {usestate} from 'react';
import axios from 'axios';

const senddate=(props) =>{
    const [userdata,setusrdata]=usestate({username:"",course:"",purchasedate:""});

    const savedata = (event)=>{
        event.preventDefault();
        axios.post('http://localhost:5163/api/user',userdata);        
    }

    const handleChange=(event)=>{
        const {name,value} = event.target
        setApiData({...apiData,[name]:value})
    }

    return(
        <>
        <br></br>
        <h4>Add new user</h4>
        <form method="POST" onsubmit={savedata}>
            <input type="text" name="username" onchange={handleChange} placeholder="username"></input>
            <input type="text" name="courses" onchange={handleChange} placeholder="course"></input>
            <input type="text" name="purchasedate" onchange={handleChange} placeholder="course"></input>
            <input type="submit"/>
        </form>
        </>
    )
}
export default senddate;